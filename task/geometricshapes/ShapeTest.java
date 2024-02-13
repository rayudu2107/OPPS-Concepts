package task.geometricshapes;
import java.util.InputMismatchException;
import java.util.Scanner;

// ShapeTest class to test geometric shapes
public class ShapeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            try {
                // Prompt user to enter shape choice
                System.out.println("Enter shape (1 for Circle, 2 for Rectangle, 3 for Triangle, 4 to Exit):");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Input and process Circle parameters
                        System.out.println("Enter radius for Circle:");
                        double radius = scanner.nextDouble();
                        Circle circle = new Circle(radius);
                        System.out.println("Circle Area: " + circle.calculateArea());
                        System.out.println("Circle Perimeter: " + circle.calculatePerimeter());
                        break;
                    case 2:
                        // Input and process Rectangle parameters
                        System.out.println("Enter length and width for Rectangle:");
                        double length = scanner.nextDouble();
                        double width = scanner.nextDouble();
                        Rectangle rectangle = new Rectangle(length, width);
                        System.out.println("Rectangle Area: " + rectangle.calculateArea());
                        System.out.println("Rectangle Perimeter: " + rectangle.calculatePerimeter());
                        break;
                    case 3:
                        // Input and process Triangle parameters
                        System.out.println("Enter side lengths for Triangle:");
                        double side1 = scanner.nextDouble();
                        double side2 = scanner.nextDouble();
                        double side3 = scanner.nextDouble();
                        Triangle triangle = new Triangle(side1, side2, side3);
                        System.out.println("Triangle Area: " + triangle.calculateArea());
                        System.out.println("Triangle Perimeter: " + triangle.calculatePerimeter());
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        return; // Exit the program
                    default:
                        System.out.println("Invalid choice! Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                // Handle invalid input
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
                choice = 0; // Reset choice to trigger re-entry into loop
            }
        } while (true); // Loop until valid input or exit
    }
}
