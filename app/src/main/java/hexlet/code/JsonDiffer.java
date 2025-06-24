package hexlet.code;
import lombok.Data;
import lombok.AllArgsConstructor;


@Data
@AllArgsConstructor
public final class JsonDiffer {
    private String key;
    private String type;
    private Object newValue;
    private Object oldValue;
}
