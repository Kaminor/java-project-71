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
            String status = diff.getStatus();

            switch (status) {
                case "removed":
                    result.append(String.format("  - %s: %s%n", key, oldValue));
                    break;
                case "added":
                    result.append(String.format("  + %s: %s%n", key, newValue));
                    break;
                case "updated":
                    result.append(String.format("  - %s: %s%n", key, oldValue));
                    result.append(String.format("  + %s: %s%n", key, newValue));
                    break;
                case "unchanged":
                    result.append(String.format("    %s: %s%n", key, newValue));
                    break;
                default:
                    throw new RuntimeException(status + " не валидный");
            }
        }

        return result.append("}").toString();
    }
}
