package homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class TestStarter {
    public static void start(Class testClass) {
        int iterat = 0;
        Method beforeSuite = null;
        Method afterSuite = null;
        Method[] methods = testClass.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                iterat++;
                if (iterat == 2) {
                    throw new RuntimeException("Должен быть один метод с аннотацией @BeforeSuite");
                }
                    beforeSuite = m;
            }
        }
        if (iterat == 0) {
            throw new RuntimeException("Должен быть один метод с аннотацией @BeforeSuite");
        }
        iterat =0;


        for (Method method : methods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                iterat++;
                if (iterat == 2) {
                    throw new RuntimeException("Должен быть один метод с аннотацией @AfterSuite");
                }
                    afterSuite = method;
            }
        }
        if (iterat == 0) {
            throw new RuntimeException("Должен быть один метод с аннотацией @AfterSuite");
        }
        iterat =0;

        try {
            beforeSuite.invoke(null);
        }catch (Exception e){
            e.printStackTrace();
        }

        for (Method meth : methods) {
            if (meth.isAnnotationPresent(Test.class)) {
                try {
                    meth.invoke(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            afterSuite.invoke(null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
