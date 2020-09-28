import Annotation.*;

public class TestClass {

    public static  void method0() {
        System.out.println("method0");
    }
    public static  void method1() {
        System.out.println("method1");
    }
    @BeforeSuite
    public static void start() {
        System.out.println("start");
    }
    @Test(priority = 9)
    public static  void method2() {
        System.out.println("method2");
    }
    @Test(priority = 7)
    public static  void method3() {
        System.out.println("method3");
    }
    @Test
    public static  void method4() {
        System.out.println("method4");
    }
    @Test
    public static  void method5() {
        System.out.println("method5");
    }
    @AfterSuite
    public static void end() {
        System.out.println("end");
    }
    @Test(priority = 10)
    public static  void method6() {
        System.out.println("method6");
    }

}
