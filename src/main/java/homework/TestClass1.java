package homework;

public class TestClass1 {
    @BeforeSuite
    public static void testSoutBefore(){
        System.out.println("Test");
    }

    @Test
    public static void testSout(){
        System.out.println("Test");
    }

    @AfterSuite
    public static void testSoutAfter(){
        System.out.println("Test");
    }
}
