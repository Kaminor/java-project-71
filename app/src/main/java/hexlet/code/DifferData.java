package hexlet.code;

public class DifferData {
    public String key;
    public Object newValue;
    public Object oldValue;


    public DifferData(String key, Object newValue, Object oldValue) {
        this.key = key;
        this.newValue = newValue;
        this.oldValue = oldValue;
    }

    public String getKey() {
        return this.key;
    }

    public Object getNewValue() {
        return this.newValue;
    }

    public Object getOldValue() {
        return this.oldValue;
    }
}
