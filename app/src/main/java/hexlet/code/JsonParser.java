package hexlet.code;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
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

    public static void main(String[] args) throws Exception {
        //Map<String, Object> data1 = parseJson("file1.json");
        //Map<String, Object> data2 = parseJson("file2.json");
        //var diff = Differ.generate(data1, data2);
        //System.out.println(diff);
    }
}
