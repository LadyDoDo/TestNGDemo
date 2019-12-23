package test.testng.demo.script;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.testng.demo.TestHelloWorld;

/**
 * @author miaomiao
 * @date 2019/5/29 11:16
 */
public class TestHelloWorldTest {
    @Test
    public void testcase(){
        TestHelloWorld helloWorld = new TestHelloWorld();
        String str = helloWorld.sayHi();
        Assert.assertNotNull(str);
        Assert.assertEquals(str, "Hello World.");
    }
}
