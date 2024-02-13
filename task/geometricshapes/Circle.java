package task.geometricshapes;

// Circle class inherits from Shape class
public class Circle extends Shape {
    // Instance variable to store the radius of the circle
    private double radius;

    // Constructor to initialize the Circle object with a given radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate and return the area of the circle
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius; // Area formula: π * r^2
    }

    // Method to calculate and return the perimeter (circumference) of the circle
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius; // Perimeter formula: 2 * π * r
    }
}
