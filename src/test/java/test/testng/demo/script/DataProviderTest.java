package test.testng.demo.script;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author fokui
 * @date 2019/9/4 15:49
 */
public class DataProviderTest {

    @Test(dataProvider = "params")
    public void dataProviderTest(String name, int age) {
        System.out.println("name: " + name + ";" + "age: " + age);
    }

    @Test(dataProvider = "paramList")
    public void dataMoreTest(String name, int age, String habit) {
        System.out.println("My name is " + name + ";I'm " + age + " years old,and my habit is " + habit);
    }

    @DataProvider(name = "params")
    public Object[][] provideData() {
        Object[][] o = new Object[][]{
                {"Tom", 10},
                {"Bob", 20},
                {"Jerry", 18},
                {"Marry", 22}
        };
        return o;
    }

    @DataProvider(name = "paramList")
    public Object[][] provideData2() {
        Object[][] o = new Object[][]{
                {"Tom", 10,"Swimming"},
                {"Bob", 20,"Skatting"},
                {"Jerry", 18,"Dacing"},
                {"Marry", 22,"Singing"}
        };
        return o;
    }
}
