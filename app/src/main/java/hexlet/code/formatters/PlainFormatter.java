package hexlet.code.formatters;

import hexlet.code.DifferData;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PlainFormatter {
    public static String formatPlain(List<DifferData> differs) {
        StringBuilder result = new StringBuilder();

        for (DifferData diff: differs) {
            String key = diff.getKey();
            Object oldValue = diff.getOldValue();
            Object newValue = diff.getNewValue();

            if (Objects.equals(oldValue, newValue)) {
                continue;
            }

            if (isString(newValue) && !newValue.equals("null")) {
                StringBuilder sb = new StringBuilder();
                sb.append("'").append(newValue).append("'");
                newValue = sb.toString();
            }

            if (isString(oldValue) && !oldValue.equals("null")) {
                StringBuilder sb = new StringBuilder();
                sb.append("'").append(oldValue).append("'");
                oldValue = sb.toString();
            }

            newValue = isComplexValue(newValue) ? "[complex value]" : newValue;
            oldValue = isComplexValue(oldValue) ? "[complex value]" : oldValue;

            if (oldValue != null && newValue != null) {
                result.append(String.format("Property '%s' was updated. From %s to %s%n", key, oldValue, newValue));
            } else if (oldValue != null && newValue == null) {
                result.append(String.format("Property '%s' was removed%n", key));
            } else if (oldValue == null && newValue != null) {
                result.append(String.format("Property '%s' was added with value: %s%n", key, newValue));
            }

        }
        return result.toString().trim();
    }

    public static boolean isComplexValue(Object value) {
        if (value == null) {
            return false;
        }

        return value instanceof Map
                || value instanceof Collection;
    }

    public static boolean isString(Object value) {
        return value instanceof String;
    }
}
