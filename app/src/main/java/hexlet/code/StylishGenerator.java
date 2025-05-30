package hexlet.code;
import java.util.List;

public class StylishGenerator {
    public static String generateStylish(List<Differ> differs) {
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
}
