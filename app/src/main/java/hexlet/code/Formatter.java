package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hexlet.code.generators.JsonGenerator;
import hexlet.code.generators.PlainGenerator;
import hexlet.code.generators.StylishGenerator;
import java.util.List;

public class Formatter {
    public static String formatGenerate(List<DifferData> diffs, String formatName) throws Exception {
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
}
