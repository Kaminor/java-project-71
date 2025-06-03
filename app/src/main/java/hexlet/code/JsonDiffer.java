package hexlet.code;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class JsonDiffer {
    private String key;
    private String type;
    private Object newValue;
    private Object oldValue;

    public JsonDiffer() {

    }

    public JsonDiffer(String key, String type, Object newValue, Object oldValue) {
        this.key = key;
        this.type = type;
        this.newValue = newValue;
        this.oldValue = oldValue;
    }
}
