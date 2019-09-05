package test.testng.demo.script;

import org.testng.annotations.Test;
import test.testng.demo.ProviderClass;

/**
 * @author fokui
 * @date 2019/9/5 17:36
 */
public class ProviderClassTest {

    @Test(dataProviderClass = ProviderClass.class,dataProvider = "test")
    public void dataTest(String name, int age) {
        System.out.println("name: " + name + " ;age: " + age);
    }
}
