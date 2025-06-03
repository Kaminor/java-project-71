package hexlet.code;

public final class DifferData {
    private final String key;
    private final Object newValue;
    private final Object oldValue;


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
