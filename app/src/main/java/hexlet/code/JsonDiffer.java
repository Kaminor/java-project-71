package hexlet.code;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class JsonDiffer {
    public String key;
    public String type;
    public Object newValue;
    public Object oldValue;

    public JsonDiffer() {

    }

    public JsonDiffer(String key, String type, Object newValue, Object oldValue) {
        this.key = key;
        this.type = type;
        this.newValue = newValue;
        this.oldValue = oldValue;
    }
}
