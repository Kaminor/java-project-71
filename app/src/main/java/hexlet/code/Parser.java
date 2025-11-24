package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String cont) throws Exception {
        ObjectMapper objMapper = new ObjectMapper(new YAMLFactory());

        Map<String, Object> dataMap = objMapper.readValue(cont, new TypeReference<Map<String, Object>>() { });

        return dataMap;
    }
}
