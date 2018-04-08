package core.lambda;

import core.model.Investor;

import java.util.function.Function;

public class LearnLambda {

    public static void main(String[] args) {
        //helloLambda();
        //moreBasicLambda();
        comparatorWithLambda();
    }

    private static void comparatorWithLambda() {
        Function<Investor,String> lastNameExtractor = Investor::getLastName;
        MyStringComparator<Investor> investorMyStringComparator = MyStringComparator.getComparator(lastNameExtractor);
        Investor.INVESTOR_LIST.sort((o1, o2) -> investorMyStringComparator.compare(o1,o2));
        Investor.INVESTOR_LIST.forEach( investor -> System.out.println(investor));

        System.out.println("**** Demo sorting investor by age ****");
        Function<Investor,Integer> ageExtractor = Investor::getAge;
        MyGenericComparator<Investor> investorAgeComparator = MyGenericComparator.getComparator(ageExtractor);
        Investor.INVESTOR_LIST.sort((o1, o2) -> investorAgeComparator.compare(o1,o2));
        Investor.INVESTOR_LIST.forEach( investor -> System.out.println(investor));
    }

    private static void moreBasicLambda() {
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
