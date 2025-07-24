package dev.iseal.ExtraKryoCodecs.Utils;

public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value cannot be null");
        }
        this.key = key;
        this.value = value;
    }

    public K getFirst() {
        return key;
    }

    public V getSecond() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
