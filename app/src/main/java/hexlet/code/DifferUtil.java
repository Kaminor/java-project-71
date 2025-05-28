package hexlet.code;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DifferUtil {
    public static List<Differ> buildDiff(Map<String, Object> oldMap, Map<String, Object> newMap) {
        TreeSet<String> allKeys = new TreeSet<>();

        allKeys.addAll(oldMap.keySet());
        allKeys.addAll(newMap.keySet());

        ArrayList<Differ> differ = new ArrayList<>();

        for (String key: allKeys) {
            Object oldValue = oldMap.get(key);
            Object newValue = newMap.get(key);

            differ.add(new Differ(key, newValue, oldValue));

        }
        return differ;
    }
}
