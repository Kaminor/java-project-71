package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Differ {
    public static void generate(String filepath1, String filepath2, String formatName) throws Exception {
        var data1 = Parser.parse(filepath1);
        var data2 = Parser.parse(filepath2);

        var diffs = DifferUtil.buildDiff(data1, data2);
        var result = Formatter.callFormatType(diffs, formatName);

        if (formatName.equals("json")) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String jsonOutput = mapper.writeValueAsString(result);
            System.out.println(jsonOutput);
        } else {
            System.out.println(result);
        }
    }
}
