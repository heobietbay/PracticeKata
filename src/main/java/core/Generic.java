package core;

/**
 * This aims to demonstrate Generic syntax, usage of many of
 * "Generic" shapes and forms.
 */
public class Generic {

    public static void main(String[] args) {
        form1();

        System.out.println();

        form2();

        System.out.println();

        boundedTypeNumber();

        System.out.println();

        boundedTypeAndInterface();

        System.out.println();

        boundedTypeWildCard();
    }

    private static void boundedTypeWildCard() {
        BoundedTypeWildCard<Number> typeNumber = new BoundedTypeWildCard<>(new Number[]{ 1,2,3,4,5,6.0,7.0f});
        for(Number number : typeNumber.numberArray)
        {
            System.out.print(number + " ");
        }
        System.out.println("Average is: " + typeNumber.average());

        BoundedTypeWildCard<Integer> typeInteger = new BoundedTypeWildCard<>(new Integer[]{1,2,3,4,5,6,7});
        for(Integer integer : typeInteger.numberArray)
        {
            System.out.print(integer + " ");
        }
        System.out.println("Average is: " + typeInteger.average());

        /* This does not compile
        System.out.println("They have same avg value: " +  typeNumber.sameAvgWithoutWildCard(typeInteger));
        */

        // This does compile
        System.out.println("They have same avg value: " +  typeInteger.sameAvgWithoutWildCard(typeInteger));

        // and this compile as well
        System.out.println("They have same avg value: " +  typeNumber.sameAvg(typeInteger));

    }

    /**
     * This to demonstrate the use of wild card (?).
     * Note that <T extends Number> needs to be declared on BoundedTypeWildCard
     * and then used in  BoundedType<T>.
     * @param <T>
     */
    static class BoundedTypeWildCard<T extends Number> extends BoundedType<T>
    {
        /**
         * Notice the use of <?>. This allows any two BoundedTypeWildCard objects to have their
         * averages compared. So an Integer bounded object can compare to a Double bounded object.
         * Note that declare BoundedTypeWildCard<?> is same as BoundedTypeWildCard.
         * Will address this further.
         * @param boundedTypeWildCard
         * @return true or false
         */
        boolean sameAvg(BoundedTypeWildCard<?> boundedTypeWildCard)
        {
            return this.average() == boundedTypeWildCard.average();
        }
        /**
         * This works only if the passed in boundedTypeWildCard is same type parameter.
         * For ex, if this bound to Integer, can only call {@linkplain BoundedTypeWildCard#sameAvgWithoutWildCard }
         * on same object that bound to Integer.
         * @param boundedTypeWildCard
         * @return true or false
         */
        boolean sameAvgWithoutWildCard(BoundedTypeWildCard<T> boundedTypeWildCard)
        {
            return this.average() == boundedTypeWildCard.average();
        }
        BoundedTypeWildCard(T[] o) {
            super(o);
        }
    }

    private static void boundedTypeAndInterface() {

        BoundedTypeAndInterface<BoundedTypeAndInterface.Teen> boundedTypeTeen = new BoundedTypeAndInterface<>(new BoundedTypeAndInterface.Teen());
        boundedTypeTeen.showType();

        /* This wont compile, since Person itself does not implement runnable

        BoundedTypeAndInterface<BoundedTypeAndInterface.Person> boundedTypePerson = new BoundedTypeAndInterface<>(new BoundedTypeAndInterface.Person());
        boundedTypePerson.showType();

        BoundedTypeAndInterface<BoundedTypeAndInterface.Baby> boundedTypeBaby = new BoundedTypeAndInterface<>(new BoundedTypeAndInterface.Baby());
        boundedTypeBaby.showType();
        */
    }

    /**
     * This is to demonstrate that generic can take a bounded type
     * that extends a type, and that implements an interface.
     * @param <T> is a subclass of Person, and must implement Runnable.
     */
    static class BoundedTypeAndInterface< T extends BoundedTypeAndInterface.Person & Runnable >
    {
        void showType()
        {
            System.out.println(person.getClass().getName());
            person.run();
        }

        BoundedTypeAndInterface(T person) {
            this.person = person;
        }

        T person;

        static class Person
        {

        }

        static class Baby extends Person
        {

        }

        static class Teen extends Person implements Runnable{

            @Override
            public void run() {
                System.out.println("Since I am a teen, I can run fast.");
            }
        }
    }

    private static void boundedTypeNumber() {
        BoundedType<Number> typeNumber = new BoundedType<>(new Number[]{ 1,2,3,4,5,6.0,7.0f});
        for(Number number : typeNumber.numberArray)
        {
            System.out.print(number + " ");
        }
        System.out.println("Average is: " + typeNumber.average());

        // Notice how this only accepts array of integer.
        BoundedType<Integer> typeInteger = new BoundedType<>(new Integer[]{1,2,3,4,5,6,7});
        for(Integer integer : typeInteger.numberArray)
        {
            System.out.print(integer + " ");
        }
        System.out.println("Average is: " + typeInteger.average());

        // This won't compile because String is not a
        // subclass of Number.
        // String strs[] = { "1", "2", "3", "4", "5" };
        // BoundedType<String> strob = new BoundedType<String>(strs);
        // double x = strob.average();
        // System.out.println("strob average is " + v);
    }

    /**
     * This is to demonstrate that we can narrow down the type of parameter passed in.
     * @param <T> T must be either Number, or a class derived from Number.
     */
    static class BoundedType<T extends Number>
    {
        double average()
        {
            double avg = 0.0;
            for(T number : numberArray)
            {
                // since all types which derived from Number inherit its methods, this will compile.
                avg = avg + number.doubleValue();
            }
            return avg/numberArray.length;
        }
        BoundedType(T[] o)
        {
            this.numberArray = o;
        }

        T[] numberArray;
    }

    private static void form2() {
        Form2<Integer, String> tgObj =
                new Form2<Integer, String>(42, "Generics");
        // Show the types.
        tgObj.showTypes();
        // Obtain and show values.
        int v = tgObj.getObj1();
        System.out.println("value: " + v);
        String str = tgObj.getObj2();
        System.out.println("value: " + str);
    }

    /**
     * Second form of Generic. Take 2 type parameters.
     * @param <T>
     * @param <V>
     */
    static class Form2<T,V>
    {
        void showTypes() {
            System.out.println("Type of T is " + obj1.getClass().getName());
            System.out.println("Type of V is " + obj2.getClass().getName());
        }
        Form2(T obj,V obj2) {
            this.obj1 = obj;
            this.obj2 = obj2;
        }

        T getObj1() {
            return obj1;
        }

        V getObj2() {
            return obj2;
        }

        T obj1;

        V obj2;
    }


    private static void form1() {
        Form1<Integer> integerForm1 = new Form1<>(1);
        integerForm1.showType();
        // Get the value in f1. Notice that no cast is needed.
        int v = integerForm1.getAnyObject();
        System.out.println("value: " + v);

        // Create a Form1 object for Strings.
        Form1<String> stringForm1 = new Form1<String>("Generics Test");
        // Show the type of data used by stringForm1.
        stringForm1.showType();
        // Get the value of stringForm1. Again, notice that no cast is needed.
        String str = stringForm1.getAnyObject();
        System.out.println("value: " + str);

        // Note that: Generic Types Differ Based on Their Type Arguments
        // So you CANNOT do this: integerForm1 = stringForm1
    }

    /**
     * Simple. first form of Generic.
     * In this class, T is type param, will be replaced with actual Reference Type
     * when an instance of Form1 is created.
     * @param <T>
     */
    static class Form1<T>
    {
        void showType()
        {
            System.out.println("Type of <obj1> is: " + anyObject.getClass().getName());
        }
        Form1(T obj) {
            this.anyObject = obj;
        }

        T getAnyObject() {
            return anyObject;
        }

        void setAnyObject(T anyObject) {
            this.anyObject = anyObject;
        }

        T anyObject;
    }

    private static void withoutGeneric()
    {
        WithoutGeneric integerForm1 = new WithoutGeneric(1);
        integerForm1.showType();
        // Get the value in f1.
        // Since compiler cant figure out what this is
        // Need a cast
        int v = (Integer) integerForm1.getAnyObject();
        System.out.println("value: " + v);

        System.out.println();

        // Create a Form1 object for Strings.
        WithoutGeneric stringForm1 = new WithoutGeneric("Generics Test");
        // Show the type of data used by stringForm1.
        stringForm1.showType();
        // Again, need a cast - or use toString().
        String str = (String) stringForm1.getAnyObject();
        System.out.println("value: " + str);


        System.out.println("Following operation compiles: integerForm1 = stringForm1; but is conceptually wrong.");
        integerForm1 = stringForm1;

        System.out.println("Will cause runtime error.");
        v = (Integer) integerForm1.getAnyObject();
    }

    static class WithoutGeneric {
        void showType()
        {
            System.out.println("Type of <obj1> is: " + anyObject.getClass().getName());
        }
        WithoutGeneric(Object obj) {
            this.anyObject = obj;
        }

        Object getAnyObject() {
            return anyObject;
        }

        void setAnyObject(Object anyObject) {
            this.anyObject = anyObject;
        }

        Object anyObject;
    }
}
