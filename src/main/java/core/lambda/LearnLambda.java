package core.lambda;

public class LearnLambda {

    public static void main(String[] args) {
        //helloLambda();
        MyConsumer<String> stringMyConsumer = (s) -> System.out.println("Hello " + s);
        MyConsumer<String> combined = stringMyConsumer.combine((s) -> System.out.println("combined"));
        combined.consume("demo");
    }

    /**
     * Demo basic lambda statements.
     * Also briefly show old ways vs lambda way.
     */
    private static void helloLambda() {
        (new LearnLambda()).consume(new DemoInterface() {
            @Override
            public void show(Object o) {
                System.out.println(o);
            }
        });
        (new LearnLambda()).consume(new DemoInterface() {
            @Override
            public void show(Object o) {
                System.out.println(o);
            }

        });
        (new LearnLambda()).consume(new DemoInterface() {
            @Override
            public void show(Object o) {
                System.out.println(o);
            }

        });
        (new LearnLambda()).consume(o -> System.out.println(o));
        (new LearnLambda()).consume(o -> System.out.println(o));
        (new LearnLambda()).consume(o -> System.out.println(o));
    }

    public interface DemoInterface{
        void show(Object o);
    }


    public LearnLambda() {
    }

    public void consume(DemoInterface demoInterface)
    {
        demoInterface.show("HelloWorld");
    }
}
