package task.inventorymanagementsystem;
import java.util.Scanner;

/**
 * Represents the main class for the Inventory Management System.
 */
public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Inventory Management System!");
        
        Inventory inventory = new Inventory(); // Moved Inventory initialization outside the loop

        // menu and process user input
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

            // Switch statement to handle user choices
            switch (choice) {
                case 1: // Add new product
                    System.out.println("Enter the product Id:");
                   long productId = Inventory.getValidProductId(input);
                   boolean id = inventory.getProductID(productId);
                   if(!id) {
                    System.out.println("Enter the product name:");
                    String productName = input.nextLine();
                    System.out.println("Enter the product price:");
                    double productPrice = inventory.getValidAmount(input);
                    System.out.println("Enter the product quantity: ");
                    int productQuantity = inventory.getValidProductQuantity(input);
                    inventory.addProduct(productId, productName, productPrice, productQuantity);
                   }
                    break;

                case 2: // Remove product by ID
                    System.out.println("Enter the product Id:");
                    long removeProductId = Inventory.getValidProductId(input);
                    inventory.removeProductById(removeProductId);
                    break;

                case 3: // Update product by ID
                    System.out.println("Enter the product Id:");
                    long updateProductId = Inventory.getValidProductId(input);
                    boolean productByID = inventory.getProductByID(updateProductId);
                    if(productByID) {
                    	System.out.println("Enter the product name:");
                        String updateProductName = input.nextLine();
                        System.out.println("Enter the product price:");
                        double updateProductPrice = inventory.getValidAmount(input);
                        System.out.println("Enter the product quantity: ");
                        int updateProductQuantity = inventory.getValidProductQuantity(input);
                        inventory.updateProductByID(updateProductId, updateProductName, updateProductPrice, updateProductQuantity);
                    }
                    break;

                case 4: // Sell item by ID
                    System.out.println("Enter the product Id:");
                    long sellProductId = Inventory.getValidProductId(input);
                    boolean sellProductByID = inventory.getProductByID(sellProductId);
                   if (sellProductByID) {
                	   System.out.println("Enter the product quantity: ");
                       int sellProductQuantity = inventory.getValidProductQuantity(input);
                       inventory.sellItem(sellProductId, sellProductQuantity);
				}
                    break;

                case 5: // Restock item by ID
                    System.out.println("Enter the product Id:");
                    long reStockProductId = Inventory.getValidProductId(input);
                    boolean reStockProductByID = inventory.getProductByID(reStockProductId);
                   if(reStockProductByID) {
                	   System.out.println("Enter the product quantity: ");
                       int reStockProductQuantity = inventory.getValidProductQuantity(input);
                       inventory.restockItem(reStockProductId, reStockProductQuantity); // Corrected method name
                   }
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
