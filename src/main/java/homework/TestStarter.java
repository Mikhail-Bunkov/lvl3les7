package homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestStarter {
    public static void start(Class testClass) {
        int iterat = 0;
        Method[] methods = testClass.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                iterat++;

                try {
                    m.invoke(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (iterat == 2) {
                    throw new RuntimeException("Должен быть один метод с аннотацией @BeforeSuite");
                }
            }
        }
        if (iterat == 0) {
            throw new RuntimeException("Должен быть один метод с аннотацией @BeforeSuite");
        }
        iterat =0;


        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        for (Method m : methods) {
            if (m.isAnnotationPresent(AfterSuite.class)) {
                iterat++;

                try {
                    m.invoke(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (iterat == 2) {
                    throw new RuntimeException("Должен быть один метод с аннотацией @AfterSuite");
                }
            }
        }
        if (iterat == 0) {
            throw new RuntimeException("Должен быть один метод с аннотацией @AfterSuite");
        }
        iterat =0;

    }
}
