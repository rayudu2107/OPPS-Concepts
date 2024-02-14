package task.inventorymanagementsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Represents the inventory management system.
 */
public class Inventory {
    // Map to store products with their IDs as keys
    private Map<Long, Product> products = new HashMap<>();

    // Method to add a new product to the inventory
    public void addProduct(Scanner input) {
        System.out.println("Enter the product Id:");
        long productId = getValidProductId(input); // Validate and retrieve product ID
        if (products.containsKey(productId)) {
            System.out.println("Error: Product Id already exists.");
            return;
        }
        // Retrieve other product details from the user
        System.out.println("Enter the product name:");
        String productName = input.nextLine();
        System.out.println("Enter the product price:");
        double productPrice = getValidAmount(input);
        System.out.println("Enter the product quantity: ");
        int productQuantity = getValidProductQuantity(input);
        // Create a new Product object and add it to the inventory
        Product product = new Product(productId, productName, productPrice, productQuantity);
        products.put(productId, product);
        System.out.println("Product added successfully.");
    }

    // Method to remove a product from the inventory by its ID
    public void removeProductById(Scanner input) {
        System.out.println("Enter the product Id:");
        long productId = getValidProductId(input); // Validate and retrieve product ID
        if (products.containsKey(productId)) {
            products.remove(productId);
            System.out.println("Product removed successfully");
        } else {
            System.out.println("Error: Product not found.");
        }
    }

    // Method to update details of a product in the inventory by its ID
    public void updateProductByID(Scanner input) {
        System.out.println("Enter the product Id:");
        long productId = getValidProductId(input); // Validate and retrieve product ID
        if (products.containsKey(productId)) {
            Product productToUpdate = products.get(productId);
            // Retrieve updated product details from the user
            System.out.println("Enter the product name:");
            String productName = input.nextLine();
            System.out.println("Enter the product price:");
            double productPrice = getValidAmount(input);
            System.out.println("Enter the product quantity: ");
            int productQuantity = getValidProductQuantity(input);
            // Update the product details
            productToUpdate.setName(productName);
            productToUpdate.setPrice(productPrice);
            productToUpdate.setQuantity(productQuantity);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Error: Product not found.");
        }
    }

    // Method to sell a specified quantity of a product from the inventory
    public void sellItem(Scanner input) {
        System.out.println("Enter the product Id:");
        long productId = getValidProductId(input); // Validate and retrieve product ID
        if (products.containsKey(productId)) {
            Product productToSell = products.get(productId);
            System.out.println("Enter the quantity to sell:");
            int quantityToSell = getValidProductQuantity(input); // Validate and retrieve quantity
            if (quantityToSell <= productToSell.getQuantity()) {
                productToSell.setQuantity(productToSell.getQuantity() - quantityToSell);
                System.out.println("Item sold successfully.");
            } else {
                System.out.println("Error: Insufficient quantity available to sell.");
            }
        } else {
            System.out.println("Error: Product not found.");
        }
    }

    // Method to restock a specified quantity of a product in the inventory
    public void restockItem(Scanner input) {
        System.out.println("Enter the product Id:");
        long productId = getValidProductId(input); // Validate and retrieve product ID
        if (products.containsKey(productId)) {
            Product productToRestock = products.get(productId);
            System.out.println("Enter the quantity to restock:");
            int quantityToAdd = getValidProductQuantity(input); // Validate and retrieve quantity
            productToRestock.setQuantity(productToRestock.getQuantity() + quantityToAdd);
            System.out.println("Item restocked successfully.");
        } else {
            System.out.println("Error: Product not found.");
        }
    }

    // Method to generate a report of the current inventory
    public void reportInventory() {
        System.out.println("Inventory Report:");
        for (Product product : products.values()) {
            System.out.println("Product ID: " + product.getId() +
                    " | Product Name: " + product.getName() +
                    " | Price: Rs " + product.getPrice() +
                    " | Quantity: " + product.getQuantity());
        }
    }

    // Method to validate and retrieve a valid product ID from user input
    public static long getValidProductId(Scanner input) {
        long productId;
        while (true) {
            try {
                productId = Long.parseLong(input.nextLine());
                if (productId <= 0) {
                    System.out.println("Error: Please enter a positive product id.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid product id.");
            }
        }
        return productId;
    }

    // Method to validate and retrieve a valid product quantity from user input
    public int getValidProductQuantity(Scanner input) {
        int quantity;
        while (true) {
            try {
                quantity = Integer.parseInt(input.nextLine());
                if (quantity <= 0) {
                    System.out.println("Error: Quantity must be greater than 0.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid quantity.");
            }
        }
        return quantity;
    }

    // Method to validate and retrieve a valid amount value from user input
    public double getValidAmount(Scanner input) {
        double amount;
        while (true) {
            try {
                amount = Double.parseDouble(input.nextLine());
                if (amount <= 0) {
                    System.out.println("Error: Amount must be greater than 0.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid amount.");
            }
        }
        return amount;
    }
}
