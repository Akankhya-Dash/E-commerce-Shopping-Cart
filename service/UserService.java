package service;

import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserService {
    private List<User> users;
    private User loggedInUser;

    public UserService() {
        users = new ArrayList<>();
        // You can pre-add some users for quick testing
        users.add(new User(1, "admin", "1234", "admin@example.com"));
    }

    // Register new user
    public void registerUser(String username, String password, String email) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                System.out.println("Username already exists!");
                return;
            }
        }
        int newId = users.size() + 1;
        User newUser = new User(newId, username, password, email);
        users.add(newUser);
        System.out.println("Registration successful! You can now log in.");
    }

    // Login user
    public boolean loginUser(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)) {
                loggedInUser = u;
                System.out.println("Login successful! Welcome, " + u.getUsername());
                return true;
            }
        }
        System.out.println("Invalid username or password!");
        return false;
    }

    // Logout user
    public void logout() {
        if (loggedInUser != null) {
            System.out.println("Goodbye, " + loggedInUser.getUsername());
            loggedInUser = null;
        } else {
            System.out.println("No user is logged in.");
        }
    }

    // Get currently logged-in user
    public User getLoggedInUser() {
        return loggedInUser;
    }

    // View user profile
    public void viewProfile() {
        if (loggedInUser == null) {
            System.out.println("You must log in first!");
            return;
        }
        System.out.println("User Profile:");
        System.out.println("Username: " + loggedInUser.getUsername());
        System.out.println("Email: " + loggedInUser.getEmail());
        System.out.println("Orders: " + loggedInUser.getOrderHistory().size());
    }
}
