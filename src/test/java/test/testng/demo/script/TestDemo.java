package test.testng.demo.script;

import org.testng.annotations.*;

public class TestDemo {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite.");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest.");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("beforeGroups.");
    }

    @Test(description = "first method.", groups = "group1")
    public void method1() {
        System.out.println("method1.");
    }

    @Test
    public void method2() {
        System.out.println("method2.");
    }
}
