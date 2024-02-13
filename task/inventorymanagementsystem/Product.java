package task.inventorymanagementsystem;

// Class representing a product in the inventory management system
public class Product {
	
    // Attributes of a product: id, name, price, quantity
    private long id;         // Unique identifier for the product
    private String name;     // Name of the product
    private double price;    // Price of the product
    private int quantity;    // Quantity of the product
    
    // Constructor to initialize the product with provided values
    public Product(long id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter and setter methods for each attribute
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
