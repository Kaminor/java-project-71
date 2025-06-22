package hexlet.code.formatters;
import hexlet.code.DifferData;

import java.util.List;

public class StylishFormatter {
    public static String formatStylish(List<DifferData> differs) {
        StringBuilder result = new StringBuilder("{\n");

        for (DifferData diff: differs) {
            String key = diff.getKey();
            Object newValue = diff.getNewValue();
            Object oldValue = diff.getOldValue();

            if (newValue == null && oldValue != null) {
                result.append(String.format("  - %s: %s%n", key, oldValue));
            } else if (newValue != null && oldValue == null) {
                result.append(String.format("  + %s: %s%n", key, newValue));
            } else if (newValue.equals(oldValue)) {
                result.append(String.format("    %s: %s%n", key, newValue));
            } else if (newValue != null && oldValue != null) {
                result.append(String.format("  - %s: %s%n", key, oldValue));
                result.append(String.format("  + %s: %s%n", key, newValue));
            }
        }

        return result.append("}").toString();
    }
}
