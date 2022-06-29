package OOP.WorkingWithAbstraction_Lab.PointInRectangle;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEqualOrHigher(Point point) {
        return point.x >= this.x && point.y >= this.y;
    }

    public boolean isEqualOrLower(Point point) {
        return point.x <= this.x && point.y <= this.y;
    }
}
