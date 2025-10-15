package app;

import java.util.*;
import model.*;
import cart.*;
import service.*;


public class ShoppingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductService productService = new ProductService();
        UserService userService = new UserService();
        OrderService orderService = new OrderService();
        Cart cart = new Cart();

        boolean running = true;

        System.out.println("======================================");
        System.out.println("  Welcome to Simple E-Commerce App");
        System.out.println("======================================");

        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1️⃣  Register");
            System.out.println("2️⃣  Login");
            System.out.println("3️⃣  View Products");
            System.out.println("4️⃣  Add Product to Cart");
            System.out.println("5️⃣  View Cart");
            System.out.println("6️⃣  Checkout");
            System.out.println("7️⃣  View Order History");
            System.out.println("8️⃣  View Profile");
            System.out.println("9️⃣  Logout");
            System.out.println("0️⃣  Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: // Register
                    System.out.print("Enter username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    userService.registerUser(username, password, email);
                    break;

                case 2: // Login
                    System.out.print("Enter username: ");
                    username = sc.nextLine();
                    System.out.print("Enter password: ");
                    password = sc.nextLine();
                    userService.loginUser(username, password);
                    break;

                case 3: // View Products
                    productService.listProducts();
                    break;

                case 4: // Add to Cart
                    productService.listProducts();
                    System.out.print("Enter product ID to add: ");
                    int pid = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine();

                    Product product = productService.getProductById(pid);
                    if (product != null) {
                        cart.addProduct(product, qty);
                        System.out.println("✅ Added " + product.getName() + " to cart.");
                    } else {
                        System.out.println("❌ Invalid Product ID!");
                    }
                    break;

                case 5: // View Cart
                    cart.viewCart();
                    break;

                case 6: // Checkout
                    orderService.checkout(userService.getLoggedInUser(), cart);
                    break;

                case 7: // View Order History
                    orderService.viewUserOrders(userService.getLoggedInUser());
                    break;

                case 8: // View Profile
                    userService.viewProfile();
                    break;

                case 9: // Logout
                    userService.logout();
                    break;

                case 0: // Exit
                    running = false;
                    System.out.println("👋 Thank you for shopping with us!");
                    break;

                default:
                    System.out.println("❌ Invalid option! Please try again.");
            }
        }

        sc.close();
    }
}
