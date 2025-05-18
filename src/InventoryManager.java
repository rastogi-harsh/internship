import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<Product> products;

    public InventoryManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("✅ Product added successfully!");
    }

    public void displayProducts() {
        System.out.println("📦 Product List:");
        for (Product p : products) {
            System.out.println(p.getId() + " | " + p.getName() + " | Qty: " + p.getQuantity() + " | ₹" + p.getPrice() + " | " + p.getCategory());
        }
    }

    public Product getProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public ArrayList<Product> getAllProducts() {
        return products;
    }

    public void restockProduct(int id, int quantity) {
        Product p = getProductById(id);
        if (p != null) {
            p.setQuantity(p.getQuantity() + quantity);
            System.out.println("🔄 Product restocked!");
        } else {
            System.out.println("❌ Product not found!");
        }
    }

    public boolean sellProduct(int id, int quantity) {
        Product p = getProductById(id);
        if (p != null && p.getQuantity() >= quantity) {
            p.setQuantity(p.getQuantity() - quantity);
            System.out.println("✅ Product sold!");
            return true;
        } else {
            System.out.println("❌ Insufficient stock or product not found!");
            return false;
        }
    }
}
