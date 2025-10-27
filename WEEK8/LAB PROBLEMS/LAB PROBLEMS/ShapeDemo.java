
// LAB PROBLEM 2: Abstract Shape and Drawable Interface
abstract class AbstractShape {
    protected double area;
    protected double perimeter;

    public abstract void calculateArea();
    public abstract void calculatePerimeter();
}

interface Drawable {
    void draw();
}

class Circle extends AbstractShape implements Drawable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        area = Math.PI * radius * radius;
        System.out.println("Circle Area: " + area);
    }

    @Override
    public void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
        System.out.println("Circle Perimeter: " + perimeter);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius " + radius);
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Circle circle = new Circle(7);
        circle.calculateArea();
        circle.calculatePerimeter();
        circle.draw();
    }
}
