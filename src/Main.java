import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager userManager = new UserManager();
        InventoryManager inventoryManager = new InventoryManager();

        // Load saved products
        inventoryManager.getAllProducts().addAll(FileManager.loadProductsFromFile("products.dat"));

        System.out.print("👤 Username: ");
        String username = sc.nextLine();
        System.out.print("🔒 Password: ");
        String password = sc.nextLine();
        

        User currentUser = userManager.login(username, password);
        if (currentUser == null) {
            System.out.println("❌ Invalid credentials. Exiting.");
            return;
        }

        System.out.println("✅ Login successful as " + currentUser.getRole());
        int choice;

        do {
            System.out.println("\n===== 📋 Menu =====");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Restock Product");
            System.out.println("4. Sell Product");
            System.out.println("5. Save & Exit");
            System.out.print("👉 Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (currentUser.getRole().equalsIgnoreCase("Admin")) {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Qty: ");
                        int qty = sc.nextInt();
                        System.out.print("Price: ");
                        double price = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Category: ");
                        String cat = sc.nextLine();
                        Product p = new Product(id, name, qty, price, cat);
                        inventoryManager.addProduct(p);
                    } else {
                        System.out.println("❌ Only Admins can add products.");
                    }
                    break;
                case 2:
                    inventoryManager.displayProducts();
                    break;
                case 3:
                    System.out.print("Product ID: ");
                    int restockId = sc.nextInt();
                    System.out.print("Quantity to add: ");
                    int restockQty = sc.nextInt();
                    inventoryManager.restockProduct(restockId, restockQty);
                    break;
                case 4:
                    System.out.print("Product ID: ");
                    int sellId = sc.nextInt();
                    System.out.print("Quantity to sell: ");
                    int sellQty = sc.nextInt();
                    inventoryManager.sellProduct(sellId, sellQty);
                    break;
                case 5:
                    FileManager.saveProductsToFile(inventoryManager.getAllProducts(), "products.dat");
                    System.out.println("💾 Data saved. Exiting...");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
