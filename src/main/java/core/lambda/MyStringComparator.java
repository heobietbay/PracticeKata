package core.lambda;

import java.util.Objects;
import java.util.function.Function;

public interface MyStringComparator<T> {

    int compare(T t1, T t2);

    /**
     * Build a comparator of type T.
     * How to compare 2 objects of type T? We use keyExtractor to get the key to compare.
     * @param keyExtractor from T -> key of type String
     * @param <T> T
     * @return implantation of MyStringComparator
     */
    static <T> MyStringComparator<T> getComparator(Function<T,String> keyExtractor)
    {
        Objects.requireNonNull(keyExtractor);
        return (t1, t2) -> {
            String keyOfT1 = keyExtractor.apply(t1);
            Objects.requireNonNull(keyOfT1);
            String keyOfT2 = keyExtractor.apply(t2);
            Objects.requireNonNull(keyOfT2);
            return keyOfT1.compareTo(keyOfT2);
        };
    }
}
