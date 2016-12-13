package core;

/**
 * This aims to demonstrate Generic syntax, usage of many of
 * "Generic" shapes and forms.
 */
public class Generic {

    public static void main(String[] args) {
        form1();
        form2();
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

        System.out.println();

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
