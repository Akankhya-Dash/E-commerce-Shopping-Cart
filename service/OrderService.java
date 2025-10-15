package service;

import java.util.*;
import model.*;
import cart.*;

public class OrderService {
    private List<Order> allOrders; // Stores all orders placed by all users
    private double taxRate = 0.05; // 5% tax
    private double discountThreshold = 5000; // Rs.5000 minimum for discount
    private double discountRate = 0.10; // 10% discount if above threshold

    public OrderService() {
        allOrders = new ArrayList<>();
    }

    // Checkout Process
    public void checkout(User user, Cart cart) {
        if (user == null) {
            System.out.println("Please log in to place an order!");
            return;
        }

        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }

        double subtotal = cart.getTotal();

        // Apply discount
        double discount = 0;
        if (subtotal >= discountThreshold) {
            discount = subtotal * discountRate;
            subtotal -= discount;
        }

        // Apply tax
        double tax = subtotal * taxRate;
        double totalAmount = subtotal + tax;

        // Create a new order
        int orderId = allOrders.size() + 1;
        Order newOrder = new Order(orderId, user, new ArrayList<>(cart.getItems()), totalAmount);

        // Store order in global and user-specific history
        allOrders.add(newOrder);
        user.addOrder(newOrder);

        System.out.println("\n✅ Order placed successfully!");
        System.out.println("Order ID: " + newOrder.getOrderId());
        System.out.println("Total Amount (after tax & discount): ₹" + totalAmount);
        System.out.println("------------------------------------");

        // Empty cart after successful checkout
        cart.clear();
    }

    // Show all orders placed by the current user
    public void viewUserOrders(User user) {
        if (user == null) {
            System.out.println("Please log in to view your orders!");
            return;
        }

        List<Order> orders = user.getOrderHistory();
        if (orders.isEmpty()) {
            System.out.println("You haven't placed any orders yet.");
            return;
        }

        System.out.println("\n Order History for " + user.getUsername() + ":");
        for (Order o : orders) {
            System.out.println("Order ID: " + o.getOrderId() + " | Total: ₹" + o.getTotalAmount());
            for (CartItem item : o.getOrderItems()) {
                System.out.println("  - " + item.getProduct().getName() + " x " + item.getQuantity());
            }
            System.out.println("------------------------------------");
        }
    }

    // View all orders in the system (admin use)
    public void viewAllOrders() {
        System.out.println("\n All Orders in System:");
        for (Order o : allOrders) {
            System.out.println("Order ID: " + o.getOrderId() + " | User: " + o.getUser().getUsername() + " | Total: ₹" + o.getTotalAmount());
        }
    }
}
