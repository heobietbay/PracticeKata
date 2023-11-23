package core.map;

import jdk.internal.util.xml.impl.Pair;

import java.util.LinkedList;

public class CustomMap<K, V> {

    private StorageItem<K,V>[] storage;
    void put(K key, V value) {
        int hash = key.hashCode();
        int idx = hash % storage.length;
        if(storage[idx] == null) {
            storage[idx] = new StorageItem<>(new StorageKey<K>(key), value);
        } else {

        }
    }
    V get(K key) {
        return null;
    }

    public CustomMap() {
        storage = new StorageItem[10000];
    }

    class StorageItem<K,V> {
        private StorageKey<K> storageKey;
        private V value;

        public StorageItem(StorageKey<K> storageKey, V value) {
            this.storageKey = storageKey;
            this.value = value;
        }
    }

    class StorageKey<K> {
        private LinkedList<K> keys;

        public StorageKey() {
            this.keys = new LinkedList<>();
        }

        public StorageKey(K key) {
            this.keys = new LinkedList<>();
            addKey(key);
        }

        public boolean addKey(K key) {
            return keys.add(key);
        }
    }
}
