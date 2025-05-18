import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static void saveProductsToFile(ArrayList<Product> products, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(products);
        } catch (IOException e) {
            System.out.println("⚠️ Error saving products: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Product> loadProductsFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (ArrayList<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
