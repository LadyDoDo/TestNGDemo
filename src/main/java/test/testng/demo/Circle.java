package test.testng.demo;

/**
 * @author fokui
 * @date 2019/7/9 16:40
 */
public class Circle {
    public static final double PI =  3.14159;
    public static double radiansToDegrees(double radians){
        return radians * 180 / PI;
    }
    public double r;
    public Circle(double r){this.r = r;}
    public Circle(){this(1.0);}
    public double area(double r){
        this.r = r;
        return PI * r * r;
    }
    public double circumference(double r){
        this.r = r;
        return 2 * PI * r;
    }
}
