package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;
import java.util.List;

public class Formatter {
    public static String formatGenerate(List<DifferData> diffs, String formatName) throws Exception {
        if (formatName.equals("json")) {
            return JsonFormatter.formatJson(diffs);
        } else if (formatName.equals("plain")) {
            return PlainFormatter.formatPlain(diffs);
        } else if (formatName.equals("stylish")) {
            return StylishFormatter.formatStylish(diffs);
        } else {
            throw new RuntimeException("Данный формат " + formatName + " не поддерживается");
        }
    }
}
