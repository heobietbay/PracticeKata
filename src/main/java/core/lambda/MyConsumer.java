package core.lambda;

/**
 * My attempt to learn lambda.
 * This interface can be marked with {@link FunctionalInterface} or not, totally optional.
 * <p>A functional interface is an interface with ONE ABSTRACT method.</p>
 * @param <T> generic type
 */
@FunctionalInterface // totally optional
public interface MyConsumer<T> {
    void consume(T t);

    default MyConsumer<T> combine(MyConsumer<T> other){
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
