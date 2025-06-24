package hexlet.code;
import lombok.Data;

@Data
public final class JsonDiffer {
    private final String key;
    private final String type;
    private final Object newValue;
    private final Object oldValue;
}
