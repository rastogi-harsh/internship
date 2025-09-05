public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String category;

    public Product(int id, String name, int quantity, double price, String category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    
    @Override
    public String toString() {
        return id + " | " + name + " | " + quantity + " | $" + price + " | " + category;
    }
}
