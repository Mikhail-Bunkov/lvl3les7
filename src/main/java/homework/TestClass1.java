package homework;

public class TestClass1 {
    @BeforeSuite
    public void testSoutBefore(){
        System.out.println("Test");
    }

    @Test
    public void testSout(){
        System.out.println("Test");
    }

    @AfterSuite
    public void testSoutAfter(){
        System.out.println("Test");
    }
}
