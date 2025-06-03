package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Differ {
    public static Object generate(String filepath1, String filepath2, String formatName) throws Exception {
        var data1 = Parser.parse(filepath1);
        var data2 = Parser.parse(filepath2);

        var diffs = DifferUtil.buildDiff(data1, data2);

        if (formatName.equals("json")) {
            var result = JsonGenerator.generateJson(diffs);

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            return mapper.writeValueAsString(result);
        }

        if (formatName.equals("plain")) {
            return PlainGenerator.generatePlain(diffs);
        }

        return StylishGenerator.generateStylish(diffs);
    }

    public static Object generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
