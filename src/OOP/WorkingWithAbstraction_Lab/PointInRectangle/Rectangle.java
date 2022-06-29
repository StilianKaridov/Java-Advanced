package OOP.WorkingWithAbstraction_Lab.PointInRectangle;

public class Rectangle {
    private Point A;
    private Point C;

    public Rectangle(Point a, Point c) {
        this.A = a;
        this.C = c;
    }

    public boolean contains(Point point) {
        return A.isEqualOrHigher(point) && C.isEqualOrLower(point);
    }
}
