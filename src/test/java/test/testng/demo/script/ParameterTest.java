package test.testng.demo.script;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.testng.demo.TestPlus;

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

    @Test
    @Parameters({"a", "b"})
    public void PlusTest(@Optional("1")int a,@Optional("3") int b) {

        TestPlus plus = new TestPlus(a, b);
        plus.sum();
    }
}
