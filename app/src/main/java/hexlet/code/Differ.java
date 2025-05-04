package hexlet.code;
import java.util.TreeMap;
import java.util.Map;

public class Differ {
    public static String generate(Map<String, Object> data1, Map<String, Object> data2) {
        String result = "{\n";
        TreeMap<String, Object> map = new TreeMap<>();

        map.putAll(data1);
        map.putAll(data2);

        for (String key : map.keySet()) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (value1 != null && value2 == null) {
                result += String.format("  - %s: %s%n", key, value1);
            } else if (value1 == null && value2 != null) {
                result += String.format("  + %s: %s%n", key, value2);
            } else if (value1.equals(value2)) {
                result += String.format("    %s: %s%n", key, value1);
            } else if (value1 != null && value2 != null) {
                result += String.format("  - %s: %s%n", key, value1);
                result += String.format("  + %s: %s%n", key, value2);
            }
        }
        return result + "}";
    }
}
