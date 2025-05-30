package hexlet.code;
import java.util.List;


public class Formatter {
    public static Object callFormatType(List<Differ> data, String formatName) {
        if (formatName.equals("plain")) {
            return PlainGenerator.generatePlain(data);
        }

        if (formatName.equals("json")) {
            return JsonGenerator.generateJson(data);
        }

        return StylishGenerator.generateStylish(data);
    }
}
