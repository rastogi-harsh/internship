import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
        // Add default admin user
        users.add(new User(1, "admin", "admin123", "Admin"));
        users.add(new User(2, "staff", "staff123", "Staff"));
    }

   
    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
