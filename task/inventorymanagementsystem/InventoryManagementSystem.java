package task.inventorymanagementsystem;
import java.util.Scanner;

/**
 * Represents the main class for the Inventory Management System.
 */
public class InventoryManagementSystem {
	 public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);

	        System.out.println("Welcome to Inventory Management System!");

	        Inventory inventory = new Inventory();

	        while (true) {
	            System.out.println("========================================================================");
	            System.out.print("1. Add new product\n"
	                    + "2. Remove product by id\n"
	                    + "3. Update product by id\n"
	                    + "4. Sell Item product by id\n"
	                    + "5. Restock Item product by id\n"
	                    + "6. Generate Report\n"
	                    + "7. Exit\n"
	                    + "Enter your choice: ");
	            int choice;
	            try {
	                choice = Integer.parseInt(input.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Error: Please enter a valid integer choice.");
	                continue;
	            }
	            System.out.println("========================================================================");

	            switch (choice) {
	                case 1: // Add new product
	                    inventory.addProduct(input);
	                    break;
	                case 2: // Remove product by ID
	                    inventory.removeProductById(input);
	                    break;
	                case 3: // Update product by ID
	                    inventory.updateProductByID(input);
	                    break;
	                case 4: // Sell item by ID
	                    inventory.sellItem(input);
	                    break;
	                case 5: // Restock item by ID
	                    inventory.restockItem(input);
	                    break;
	                case 6: // Generate report
	                    inventory.reportInventory();
	                    break;
	                case 7: // Exit the program
	                    System.out.println("Thank you for using Inventory Management System!");
	                    input.close();
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Error: Invalid choice.");
	            }
	        }
	    }
}
