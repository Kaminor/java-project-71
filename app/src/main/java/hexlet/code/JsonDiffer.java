package hexlet.code;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class JsonDiffer {
    private final String key;
    private final String type;
    public final Object newValue;
    public final Object oldValue;


    public JsonDiffer(String key, String type, Object newValue, Object oldValue) {
        this.key = key;
        this.type = type;
        this.newValue = newValue;
        this.oldValue = oldValue;
    }
}
