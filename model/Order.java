package model;

import java.util.List;
import cart.Cart;

public class Order {
    private int orderId;
    private User user;
    private List<CartItem> orderItems;
    private double totalAmount;

    public Order(int orderId, User user, List<CartItem> orderItems, double totalAmount) {
        this.orderId = orderId;
        this.user = user;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public List<CartItem> getOrderItems() {
        return orderItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrderItems(List<CartItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // Display order summary
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + user.getUsername());
        System.out.println("Items:");
        for (CartItem item : orderItems) {
            System.out.println("  - " + item.getProduct().getName() + " x " + item.getQuantity());
        }
        System.out.println("Total Amount: ₹" + totalAmount);
        System.out.println("------------------------------------");
    }
}
