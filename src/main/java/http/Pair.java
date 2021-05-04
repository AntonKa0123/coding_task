package http;

public class Pair<T, R> {
    private T key;
    private R value;

    public Pair(T key, R value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }
    public R getValue() {
        return value;
    }

    public void setKey(T key) {
        this.key = key;
    }
    public void setValue(R value) {
        this.value = value;
    }
}