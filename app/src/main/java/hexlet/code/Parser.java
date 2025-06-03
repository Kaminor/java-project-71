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
        Path path = Paths.get(fileName);

        if (!path.isAbsolute()) {
            path = Paths.get("src", "test", "resources", "fixtures", fileName);
        }
        return path.toAbsolutePath().normalize();
    }

    public static String readFixture(String fileName) throws Exception {
        var path = getFixturePath(fileName);
        return Files.readString(path);
    }

    public static Map<String, Object> parse(String fileName) throws Exception {
        ObjectMapper objMapper = new ObjectMapper(new YAMLFactory());
        var readFile = readFixture(fileName);

        Map<Object, Object> dataMap = objMapper.readValue(readFile, new TypeReference<Map<Object, Object>>() { });

        return dataMap.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> (String) entry.getKey(),
                        entry -> entry.getValue() != null ? entry.getValue() : "null"
                ));
    }
}
