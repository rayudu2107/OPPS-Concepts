package task.geometricshapes;

// Rectangle class inherits from Shape class
public class Rectangle extends Shape {
    // Instance variables to store the length and width of the rectangle
    private double length;
    private double width;

    // Constructor to initialize the Rectangle object with given length and width
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Method to calculate and return the area of the rectangle
    @Override
    public double calculateArea() {
        return length * width; // Area formula: length * width
    }

    // Method to calculate and return the perimeter of the rectangle
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width); // Perimeter formula: 2 * (length + width)
    }
}
