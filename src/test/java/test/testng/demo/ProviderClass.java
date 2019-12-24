package test.testng.demo;

import org.testng.annotations.DataProvider;

import java.util.Iterator;

/**
 * @author fokui
 * @date 2019/9/5 17:33
 */
public class ProviderClass {
    @DataProvider(name = "test")
    public static Object[][] testData() {
        return new Object[][]{
                {"Tom", 12},
                {"Jimmy", 20}
        };
    }
}
