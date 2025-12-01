package hexlet.code;
import java.util.*;

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

            //TODO: доделать логику с существованием ключей в мапе (статусы added и updated)
            if (oldHas && !newHas) {
                diff.add(new DifferData("removed", key, null, oldValue));
            } else if (!oldHas && newHas) {
                diff.add(new DifferData("added", key, newValue, null));
            } else if (Objects.equals(oldValue, newValue)) {
                diff.add(new DifferData("unchanged", key, newValue, null));
            } else if (!Objects.equals(oldValue, newValue)) {
                diff.add(new DifferData("updated", key, newValue, oldValue));
            }

            /*if (oldValue != null && newValue == null) {
                diff.add(new DifferData("removed", key, null, oldValue));
            } else if (oldValue == null && newValue != null) {
                diff.add(new DifferData("added", key, newValue, null));
            } else if (oldValue != null && newValue != null && !oldValue.equals(newValue)) {
                diff.add(new DifferData("updated", key, newValue, oldValue));
            } else if (oldValue != null && newValue != null && oldValue.equals(newValue)) {
                diff.add(new DifferData("unchanged", key, newValue, null));
            }*/

        }
        return diff;
    }
}
