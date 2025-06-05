package hexlet.code.generators;

import hexlet.code.DifferData;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PlainGenerator {
    public static String generatePlain(List<DifferData> differs) {
        String result = "";

        for (DifferData diff: differs) {
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
                || value instanceof Collection;
    }

    public static boolean isString(Object value) {
        return value instanceof String;
    }
}
