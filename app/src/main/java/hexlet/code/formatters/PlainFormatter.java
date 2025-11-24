package hexlet.code.formatters;

import hexlet.code.DifferData;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class PlainFormatter {
    public static String formatPlain(List<DifferData> diffs) {
        StringBuilder result = new StringBuilder();

        for (DifferData diff : diffs) {
            String key = diff.getKey();
            Object oldValue = diff.getOldValue();
            Object newValue = diff.getNewValue();
            String status = diff.getStatus();

            newValue = stringify(newValue);
            oldValue = stringify(oldValue);

            switch (status) {
                case "removed":
                    result.append(String.format("Property '%s' was removed%n", key));
                    break;
                case "added":
                    result.append(String.format("Property '%s' was added with value: %s%n", key, newValue));
                    break;
                case "updated":
                    result.append(String.format("Property '%s' was updated. From %s to %s%n", key, oldValue, newValue));
                    break;
                case "unchanged":
                    break;
                default:
                    throw new RuntimeException(status + " не валидный");
            }
        }
        return result.toString().trim();
    }

    public static String stringify(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof Collection || value instanceof Map) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        }
        return value.toString();
    }
}
