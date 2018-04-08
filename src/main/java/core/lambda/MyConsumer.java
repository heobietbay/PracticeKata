package core.lambda;

import java.util.Objects;

/**
 * My attempt to learn lambda.
 * This interface can be marked with {@link FunctionalInterface} or not, totally optional.
 * <p>A functional interface is an interface with ONE ABSTRACT method.</p>
 * @param <T> generic type
 */
@FunctionalInterface // totally optional
public interface MyConsumer<T> {

    void consume(T t);

    /**
     * Thanks to Java 8 and above, interface can have default method.
     * This way, we can maintain "ONE ABSTRACT METHOD" rule.
     * <p>This method combines itself with other consumer, return the combined version.</p>
     * @param other other my consumer
     * @return the combined version
     */
    default MyConsumer<T> combine(MyConsumer<T> other){
        Objects.requireNonNull(other);
        return t -> {
            consume(t);
            other.consume(t);
        };
        /* Long version*/
        /*
        return new MyConsumer<T>() {
            @Override
            public void consume(T t) {
                consume(t);
                other.consume(t);
            }
        };
        */
    }
}
