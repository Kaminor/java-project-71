package hexlet.code;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public final class DifferData {
    private final String status;
    private final String key;
    private final Object newValue;
    private final Object oldValue;


    public DifferData(String status, String key, Object newValue, Object oldValue) {
        this.status = status;
        this.key = key;
        this.newValue = newValue;
        this.oldValue = oldValue;
    }
}
