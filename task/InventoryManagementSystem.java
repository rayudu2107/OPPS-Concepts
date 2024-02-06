package internshiptasks;

import java.util.ArrayList;
import java.util.List;

class Product {
	private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully");
    }

    public void removeProductById(int productId) {
    	for (Product product : products) {
            if (product.getId()==productId) {
            	products.remove(product);
            	System.out.println("Product remved successfully");
                return; 
            }
        }
    	System.out.println("Product is not found");
    }

    public void updateProductByID(int productId,String productName, double newPrice, int newQuantity) {
        for (Product product : products) {
            if (product.getId()==productId) {
            	product.setName(productName);
                product.setPrice(newPrice);
                product.setQuantity(newQuantity);
                System.out.println("Product updated successfully");
                return; 
            }
        }
        System.out.println("Product not found");
    }

    public void printInventory() {
        System.out.println("Inventory Report:");
        for (Product product : products) {
            System.out.println("Product ID: " + product.getId() + " | Product Name: " + product.getName() + " | Price: Rs " + product.getPrice() + " | Quantity: " + product.getQuantity());
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addProduct(new Product(10,"Mobile", 1000, 5));
        inventory.addProduct(new Product(20,"Bag", 500,3));
       
        System.out.println("=======================all product=======================");
        inventory.printInventory();
   
        System.out.println("======================update========================");
        inventory.updateProductByID(10,"Pen", 10, 20);
        
        System.out.println("======================delete========================");
        inventory.removeProductById(20);
        
        System.out.println("=======================all product=======================");
        inventory.printInventory();
    }
}

