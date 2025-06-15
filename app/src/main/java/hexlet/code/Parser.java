package hexlet.code;
import java.util.Map;
import java.util.stream.Collectors;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Parser {


    public static Map<String, Object> parse(String fileName) throws Exception {
        ObjectMapper objMapper = new ObjectMapper(new YAMLFactory());
        var readFile = FilePath.readFixture(fileName);

        Map<Object, Object> dataMap = objMapper.readValue(readFile, new TypeReference<Map<Object, Object>>() { });

        return dataMap.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> (String) entry.getKey(),
                        entry -> entry.getValue() != null ? entry.getValue() : "null"
                ));
    }
}
