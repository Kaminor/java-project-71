package hexlet.code.generators;
import hexlet.code.DifferData;
import hexlet.code.JsonDiffer;

import java.util.ArrayList;
import java.util.List;

public class JsonGenerator {
    public static List<JsonDiffer> generateJson(List<DifferData> differs) {
        List<JsonDiffer> result = new ArrayList<>();

        for (var element : differs) {
            String key = element.getKey();
            Object oldValue = element.getOldValue();
            Object newValue = element.getNewValue();

            if (oldValue != null && newValue == null) {
                result.add(new JsonDiffer(key, "removed", null, oldValue));
            } else if (oldValue == null && newValue != null) {
                result.add(new JsonDiffer(key, "added", newValue, null));
            } else if (oldValue != null && newValue != null && !oldValue.equals(newValue)) {
                result.add(new JsonDiffer(key, "changed", newValue, oldValue));
            } else if (oldValue != null && newValue != null && oldValue.equals(newValue)) {
                continue;
            }
        }
        return result;
    }
}
