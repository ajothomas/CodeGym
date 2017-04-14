package Misc;

/**
 * Created by ajothomas on 4/5/17.
 */
class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class RectangleOverlap {
    static boolean doOverlap(Point L1, Point R1, Point L2, Point R2) {
        // If one rectangle is on left side of other
        if(R1.x<L2.x || R2.x<L1.x)
            return false;
        // If one rectangle is above other
        if(R1.y>L2.y || R2.y>L1.y)
            return false;
        return true;
    }

    public static void main(String args[]) {
        Point L1 = new Point(0,10);
        Point R1 = new Point(10,0);

        Point L2 = new Point(5,5);
        Point R2 = new Point(15,0);

        if(doOverlap(L1,R1,L2,R2))
            System.out.println("Rectangles overlap");
        else
            System.out.println("Rectangles do not overlap");

    }
}
