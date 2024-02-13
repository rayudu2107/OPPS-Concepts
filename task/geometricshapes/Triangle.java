package task.geometricshapes;

// Triangle class inherits from Shape class
public class Triangle extends Shape {
    // Instance variables to store the lengths of the triangle's sides
    private double side1;
    private double side2;
    private double side3;

    // Constructor to initialize the Triangle object with given side lengths
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Method to calculate and return the area of the triangle
    @Override
    public double calculateArea() {
        // Using Heron's formula to calculate the area of a triangle
        double s = (side1 + side2 + side3) / 2; // Calculate the semi-perimeter
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)); // Area formula using Heron's formula
    }

    // Method to calculate and return the perimeter of the triangle
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3; // Perimeter formula: sum of all sides
    }
}
