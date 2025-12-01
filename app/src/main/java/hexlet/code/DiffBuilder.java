package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DiffBuilder {
    public static List<DifferData> buildDiff(Map<String, Object> oldMap, Map<String, Object> newMap) {
        Set<String> allKeys = new TreeSet<>();

        allKeys.addAll(oldMap.keySet());
        allKeys.addAll(newMap.keySet());

        List<DifferData> diff = new ArrayList<>();

        for (String key: allKeys) {
            boolean oldHas = oldMap.containsKey(key);
            boolean newHas = newMap.containsKey(key);
            Object oldValue = oldMap.get(key);
            Object newValue = newMap.get(key);

            if (oldHas && !newHas) {
                diff.add(new DifferData("removed", key, null, oldValue));
            } else if (!oldHas && newHas) {
                diff.add(new DifferData("added", key, newValue, null));
            } else if (Objects.equals(oldValue, newValue)) {
                diff.add(new DifferData("unchanged", key, newValue, null));
            } else if (!Objects.equals(oldValue, newValue)) {
                diff.add(new DifferData("updated", key, newValue, oldValue));
            }
        }
        return diff;
    }
}
