import java.time.LocalDate;

public class Transaction {
    private int transactionId;
    private int productId;
    private int quantity;
    private LocalDate date;
    private String type; // "Sale" or "Restock"

    public Transaction(int transactionId, int productId, int quantity, LocalDate date, String type) {
        this.transactionId = transactionId;
        this.productId = productId;
        this.quantity = quantity;
        this.date = date;
        this.type = type;
    }

    // Getters
    public int getTransactionId() { return transactionId; }
    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public LocalDate getDate() { return date; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return transactionId + " | Product ID: " + productId + " | " + quantity + " | " + date + " | " + type;
    }
}
