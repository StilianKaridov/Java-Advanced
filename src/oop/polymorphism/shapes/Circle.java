package oop.polymorphism.shapes;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double radius) {
        setRadius(radius);
        super.setArea(calculateArea());
        super.setPerimeter(calculatePerimeter());
    }

    public void setRadius(Double radius) {
        if (this.radius < 0) {
            throw new IllegalArgumentException("The radius cannot be negative number!");
        }
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
