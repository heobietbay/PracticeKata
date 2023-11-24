package core.map;

import java.util.LinkedList;
import java.util.Objects;

public class CustomMap<K, V> {

    public static void main(String[] args) {
        CustomMap<Integer, Pojo> testMap = new CustomMap<>();

        Pojo p1 = new Pojo("Khoa", 1);
        Pojo p2 = new Pojo("AAA", 2);
        Pojo p3 = new Pojo("Khoa1", 1);

        testMap.put(p1.id, p1);
        testMap.put(p2.id, p2);
        testMap.put(p3.id, p3);

        System.out.println(testMap.get(1).toDebugString());
    }

    private StorageItem<K,V>[] storage;
    void put(K key, V value) {
        int hash = Math.abs(key.hashCode());
        int idx = hash % storage.length;
        if(storage[idx] == null) {
            storage[idx] = new StorageItem<>(key, value);
        } else {
            StorageItem<K,V> temp = storage[idx];
            if(temp.storageKey.equals(key)) {
                temp.value = value;
            } else {
                while (temp.next != null) {
                    if(temp.next.storageKey.equals(key)) {
                        temp.next.value = value;
                        break;
                    }
                    temp = temp.next;
                }
                if(temp.next == null) {
                    temp.next = new StorageItem<>(key, value);
                }
            }
        }
    }
    V get(K key) {
        int hash = Math.abs(key.hashCode());
        int idx = hash % storage.length;
        StorageItem<K,V> temp = storage[idx];
        if(temp != null) {
            while (temp != null) {
                if(temp.storageKey.equals(key)) {
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public CustomMap() {
        storage = new StorageItem[10000];
    }

    class StorageItem<K,V> {
        K storageKey;
        V value;

        StorageItem<K,V> next;

        public StorageItem(K storageKey, V value) {
            this.storageKey = storageKey;
            this.value = value;
        }
    }

    static class Pojo {
        String name;
        Integer id;

        public Pojo(String name, Integer id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pojo pojo = (Pojo) o;
            return Objects.equals(name, pojo.name) && Objects.equals(id, pojo.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }

        public String toDebugString() {
            return "Pojo{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}
