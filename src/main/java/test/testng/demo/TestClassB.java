package test.testng.demo;

/**
 * @author fokui
 * @date 2019/7/9 17:43
 */
public class TestClassB extends TestClassA{
    public int i = 2;
    public int f(){return -i;}
    public static char g(){return 'B';}
    public char c(){return super.g();}

    public static void main(String[] args){
        TestClassB b = new TestClassB();
        System.out.println(b.i);
        System.out.println(b.g());
        System.out.println(TestClassB.g());
        System.out.println(b.c());
    }
}
