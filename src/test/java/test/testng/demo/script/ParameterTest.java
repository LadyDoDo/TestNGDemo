package test.testng.demo.script;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author fokui
 * @date 2019/9/4 14:29
 */
public class ParameterTest {

    @Test
    @Parameters({"name", "age"})
    public void parameterTest(String name, int age) {
        System.out.println("name: " + name);
        System.out.println("age: " + age);
    }
}
