package hexlet.code;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Parser {
    public static Path getFixturePath(String fileName) {
        return Paths.get("src", "main", "resources", fileName)
                .toAbsolutePath().normalize();
    }

    public static String readFixture(String fileName) throws Exception {
        var path = getFixturePath(fileName);
        return Files.readString(path);
    }

    public static Map<String, Object> parseJson(String file) throws Exception {
        ObjectMapper objMapper = new ObjectMapper();
        var readFile = readFixture(file);

        return objMapper.readValue(readFile, new TypeReference<Map<String, Object>>() { });
    }

    public static Map<String, Object> parseYaml(String fileName) throws Exception {
        ObjectMapper objMapper = new ObjectMapper(new YAMLFactory());
        var readFile = readFixture(fileName);

        Map<Object, Object> dataMap = objMapper.readValue(readFile, new TypeReference<Map<Object, Object>>() { });

        return dataMap.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> (String) entry.getKey(),
                        entry -> entry.getValue() != null ? entry.getValue() : "null"
                ));
    }

    public static void main(String[] args) throws Exception {
        var data1 = parseJson("file1.json");
        var data2 = parseJson("file2.json");

        var diffs = DifferUtil.buildDiff(data1, data2);
        var result = Formatter.generate(diffs);

        System.out.println(result);
    }
}
