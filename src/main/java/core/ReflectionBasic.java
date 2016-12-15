package core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by khoa on 2/11/2016.
 */
class Mock{
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Calling setName.");
        this.name = name;
    }
    public Mock()
    {

    }
}
public class ReflectionBasic {

    void callSetName(Object target, Method methodSet, Method methodGet) throws InvocationTargetException, IllegalAccessException {
        synchronized (this)
        {
            System.out.println(Thread.currentThread().getName());
            String name = (String) methodGet.invoke(target);
            if(name == "123")
            {
                System.out.println("No need to set.");
                return;
            }
            methodSet.invoke(target,"123");
        }
    }
    public static void main(String[] args) {
        final ReflectionBasic reflectionBasic = new ReflectionBasic();
        Class mockClass = Mock.class;
        try
        {
            final Object mockObj = mockClass.getConstructor().newInstance();
            final Method setNameMeth = mockClass.getMethod("setName",String.class);
            final Method getNameMeth = mockClass.getMethod("getName");

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Sleep 2 seconds");
                        Thread.sleep(2000);
                        reflectionBasic.callSetName(mockObj,setNameMeth,getNameMeth);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        reflectionBasic.callSetName(mockObj,setNameMeth,getNameMeth);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            });
            t1.setName("First thread.");
            t2.setName("Second thread.");
            t1.start();
            t2.start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void example1() {
        Class mockClass = Mock.class;
        try
        {
            Object mockObj = mockClass.getConstructor().newInstance();
            Method setNameMeth = mockClass.getMethod("setName",String.class);
            setNameMeth.invoke(mockObj,"123");


            Method getNameMeth = mockClass.getMethod("getName");
            Object name = getNameMeth.invoke(mockObj);
            System.out.println(name);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
