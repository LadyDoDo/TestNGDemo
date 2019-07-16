package test.testng.demo;

/**
 * @author fokui
 * @date 2019/7/9 16:55
 */
public class PlaneCircle extends Circle {
    private final double cx, cy;
    public PlaneCircle(double r, double cx,double cy){
        super(r);
        this.cx = cx;
        this.cy = cy;
    }

    public double getCx() {
        return cx;
    }

    public double getCy() {
        return cy;
    }

    public boolean isInside(double x , double y){
        double dx = x - cx;
        double dy = y - cy;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return (distance < r);
    }
}
