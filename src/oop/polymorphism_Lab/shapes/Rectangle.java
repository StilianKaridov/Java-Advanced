package oop.polymorphism_Lab.shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        setHeight(height);
        setWidth(width);
        super.setArea(calculateArea());
        super.setPerimeter(calculatePerimeter());
    }

    public void setHeight(Double height) {
        if (this.height <= 0) {
            throw new IllegalArgumentException("The height cannot be zero or negative number!");
        }
        this.height = height;
    }

    public void setWidth(Double width) {
        if (this.width <= 0) {
            throw new IllegalArgumentException("The width cannot be zero or negative number!");
        }
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public Double calculatePerimeter() {
        return (height + width) * 2;
    }

    @Override
    public Double calculateArea() {
        return height * width;
    }
}
