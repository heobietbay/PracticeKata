package core.lambda;

import java.util.Objects;
import java.util.function.Function;

public interface MyGenericComparator<T> {
    int compare(T t1, T t2);

    /**
     * Build a comparator of type T.
     * How to compare 2 objects of type T? We use keyExtractor to get the key to compare.
     * @param keyExtractor from T -> key that extends Comparable
     * @param <T> T
     * @return implementation of MyGenericComparator
     */
    static <T> MyGenericComparator<T> getComparator(Function<T,? extends Comparable> keyExtractor)
    {
        Objects.requireNonNull(keyExtractor);
        return (t1, t2) -> {
            Comparable keyOfT1 = keyExtractor.apply(t1);
            Objects.requireNonNull(keyOfT1);
            Comparable keyOfT2 = keyExtractor.apply(t2);
            Objects.requireNonNull(keyOfT2);
            return keyOfT1.compareTo(keyOfT2);
        };
    }
}
