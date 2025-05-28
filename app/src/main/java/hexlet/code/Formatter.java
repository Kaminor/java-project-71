package hexlet.code;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Formatter {

    public static String generate(List<Differ> differs) {
        String result = "{\n";

        for (Differ diff: differs) {
            String key = diff.getKey();
            Object newValue = diff.getNewValue();
            Object oldValue = diff.getOldValue();

            if (newValue == null && oldValue != null) {
                result += String.format("  - %s: %s%n", key, oldValue);
            } else if (newValue != null && oldValue == null) {
                result += String.format("  + %s: %s%n", key, newValue);
            } else if (newValue.equals(oldValue)) {
                result += String.format("    %s: %s%n", key, newValue);
            } else if (newValue != null && oldValue != null) {
                result += String.format("  - %s: %s%n", key, oldValue);
                result += String.format("  + %s: %s%n", key, newValue);
            }
        }

        return result + "}";
    }

    public static String generate(List<Differ> differs, String formatName) {
        var diff = generate(differs);

        if (formatName.equals("plain")) {
            return plain(differs);
        }
        return diff;
    }

    public static String plain(List<Differ> differs) {
        String result = "";

        for (Differ diff: differs) {
            String key = diff.getKey();
            Object oldValue = diff.getOldValue();
            Object newValue = diff.getNewValue();

            if (Objects.equals(oldValue, newValue)) {
                continue;
            }

            if (isString(newValue) && !newValue.equals("null")) {
                newValue = "'" + newValue + "'";
            }

            if (isString(oldValue) && !oldValue.equals("null")) {
                oldValue = "'" + oldValue + "'";
            }

            newValue = isComplexValue(newValue) ? "[complex value]" : newValue;
            oldValue = isComplexValue(oldValue) ? "[complex value]" : oldValue;

            if (oldValue != null && newValue != null) {
                result += String.format("Property '%s' was updated. From %s to %s%n", key, oldValue, newValue);
            } else if (oldValue != null && newValue == null) {
                result += String.format("Property '%s' was removed%n", key);
            } else if (oldValue == null && newValue != null) {
                result += String.format("Property '%s' was added with value: %s%n", key, newValue);
            }

        }
        return result.trim();
    }

    public static boolean isComplexValue(Object value) {
        if (value == null) {
            return false;
        }

        return value instanceof Map
                || value instanceof Collection
                || value.getClass().isArray();
    }

    public static boolean isString(Object value) {
        return value instanceof String;
    }
}
