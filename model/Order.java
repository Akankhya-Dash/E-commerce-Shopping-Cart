package model;

import java.util.List;

public class Order {
    private int id;
    private User user;
    private List<CartItem> items;
    private double total;

    public Order(int id, User user, List<CartItem> items, double total) {
        this.id = id;
        this.user = user;
        this.items = items;
        this.total = total;
    }

    public int getId() { return id; }
    public User getUser() { return user; }
    public List<CartItem> getItems() { return items; }
    public double getTotal() { return total; }

    @Override
    public String toString() {
        return "Order #" + id + " | User: " + user.getUsername() + " | Total: $" + total;
    }
}
