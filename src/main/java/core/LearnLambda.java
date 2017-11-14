package core;

public class LearnLambda {


    public LearnLambda() {
    }

    public void consume(DemoInterface demoInterface)
    {
        demoInterface.show("HelloWorld");
    }

    public static void main(String[] args) {

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
}
