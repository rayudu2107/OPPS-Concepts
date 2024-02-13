package task.inventorymanagementsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Represents the inventory management system.
 */
public class Inventory {
    private Map<Long, Product> products = new HashMap<>();

     // Adds a new product to the inventory.
    public void addProduct(long productId, String productName, double productPrice, int productQuantity) {
        Product product = new Product(productId, productName, productPrice, productQuantity);
        products.put(productId, product);
        System.out.println("Product added successfully. Product Id: " + productId + "    Product name: " + productName);
    }

     // Removes a product from the inventory by its ID.
    public void removeProductById(long productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
            System.out.println("Product removed successfully");
        } else {
            System.out.println("Product is not found");
        }
    }

     // Updates the details of a product in the inventory by its ID.     
    public void updateProductByID(long productId, String productName, double newPrice, int newQuantity) {
        if (products.containsKey(productId)) {
            Product productToUpdate = products.get(productId);
            productToUpdate.setName(productName);
            productToUpdate.setPrice(newPrice);
            productToUpdate.setQuantity(newQuantity);
            System.out.println("Product updated successfully. Product Id: " + productId + "    Product name: " + productName);
        } else {
            System.out.println("Product not found");
        }
    }

     // Sells a specified quantity of a product from the inventory.     
    public void sellItem(long productId, int quantityToSell) {
        if (products.containsKey(productId)) {
            Product productToSell = products.get(productId);
            if (productToSell.getQuantity() >= quantityToSell) {
                productToSell.setQuantity(productToSell.getQuantity() - quantityToSell);
                System.out.println("Item sold successfully");
            } else {
                System.out.println("Insufficient quantity available to sell");
            }
        } else {
            System.out.println("Product not found");
        }
    }

     // ReStocks a specified quantity of a product in the inventory.
    public void restockItem(long productId, int quantityToAdd) {
        if (products.containsKey(productId)) {
            Product productToRestock = products.get(productId);
            productToRestock.setQuantity(productToRestock.getQuantity() + quantityToAdd);
            System.out.println("Item restocked successfully");
        } else {
            System.out.println("Product not found");
        }
    }

     // Generates a report of the current inventory.
    public void reportInventory() {
        System.out.println("Inventory Report:");
        for (Product product : products.values()) {
            System.out.println("Product ID: " + product.getId() +
                    " | Product Name: " + product.getName() +
                    " | Price: Rs " + product.getPrice() +
                    " | Quantity: " + product.getQuantity());
        }
    }

     // Validates and retrieves a valid product ID from user input.
    public static long getValidProductId(Scanner input) {
        long productId;
        while (true) {
            try {
                productId = Long.parseLong(input.nextLine());
                break; // Exit loop if parsing successful
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid product id.");
                // Continue loop to allow the user to input again
            }
        }
        return productId;
    }

     // Validates and retrieves a valid product quantity from user input.
    public int getValidProductQuantity(Scanner input) {
        int productQuantity;
        while (true) {
            try {
                productQuantity = Integer.parseInt(input.nextLine());
                if (productQuantity > 0) {
                    break; // Exit loop if parsing successful and quantity is positive
                } else {
                    System.out.println("Error: Product quantity must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid product quantity.");
            }
        }
        return productQuantity;
    }

     // Validates and retrieves a valid amount value from user input.
    public double getValidAmount(Scanner input) {
        double value;
        while (true) {
            try {
                value = Double.parseDouble(input.nextLine());
                if (value < 0) {
                    System.out.println("Error: Value cannot be negative.");
                    continue; // Continue loop to allow the user to input again
                }
                break; // Exit loop if parsing successful
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid price.");
                // Continue loop to allow the user to input again
            }
        }
        return value;
    }

     // Checks if a product with the given ID exists in the inventory.
    public boolean getProductByID(long updateProductId) {
        if (products.containsKey(updateProductId)) {
            return true;
        } else {
            System.out.println("Product is not found");
            return false;
        }
    }

     // Checks if a product ID already exists in the inventory.
    public boolean getProductID(long updateProductId) {
        while (true) {
            if (products.containsKey(updateProductId)) {
                System.out.println(" Error: Product Id already exists.");
                return true;
            } else {
                return false;
            }
        }
    }
}
