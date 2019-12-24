package test.testng.demo;

public class TestPlus {

    private int a;
    private int b;

    public TestPlus(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void sum() {
        System.out.println("a plus b equal to:" + (this.a + this.b));
    }
}
