import java.util.*;
import java.time.LocalDate;

public class ReportManager {
    public static void generateReports(Scanner scanner, ArrayList<Product> products, ArrayList<Transaction> transactions) {
        System.out.println("1. Low Stock\n2. Sales Report\n3. Inventory Report");
        switch (scanner.nextLine()) {
            case "1" -> {
                for (Product p : products) {
                    if (p.getQuantity() < 5) {
                        System.out.printf("LOW: %s | %s | Qty: %d\n", p.getId(), p.getName(), p.getQuantity());
                    }
                }
            }
            case "2" -> {
                System.out.print("Enter start date (YYYY-MM-DD): ");
                LocalDate start = LocalDate.parse(scanner.nextLine());
                System.out.print("Enter end date (YYYY-MM-DD): ");
                LocalDate end = LocalDate.parse(scanner.nextLine());
                for (Transaction t : transactions) {
                    if (t.getDate().compareTo(start) >= 0 && t.getDate().compareTo(end) <= 0 && t.getType().equals("Sale")) {
                        System.out.printf("%s | %s | Qty: %d | Date: %s\n", t.getTransactionId(), t.getProductId(), t.getQuantity(), t.getDate());
                    }
                }
            }
            case "3" -> displayInventory(products);
        }
    }

    public static void displayInventory(ArrayList<Product> products) {
        for (Product p : products) {
            System.out.printf("%s | %s | Stock: %d\n", p.getId(), p.getName(), p.getQuantity());
        }
    }
}

