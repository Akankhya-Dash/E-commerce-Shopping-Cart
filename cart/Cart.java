package cart;

import java.util.ArrayList;
import java.util.List;
import model.CartItem;
import model.Product;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    // Add product to cart
    public void addProduct(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                System.out.println(quantity + " more " + product.getName() + " added to cart.");
                return;
            }
        }
        items.add(new CartItem(product, quantity));
        System.out.println(product.getName() + " added to cart.");
    }

    // Remove product from cart
    public void removeProduct(int productId) {
        CartItem toRemove = null;
        for (CartItem item : items) {
            if (item.getProduct().getId() == productId) {
                toRemove = item;
                break;
            }
        }
        if (toRemove != null) {
            items.remove(toRemove);
            System.out.println(toRemove.getProduct().getName() + " removed from cart.");
        } else {
            System.out.println("Product not found in cart.");
        }
    }

    // View cart items
    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("Your Cart:");
        for (CartItem item : items) {
            System.out.println(item);
        }
        System.out.println("Total: $" + getTotal());
    }

    // Calculate total
    public double getTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getItemTotal();
        }
        return total;
    }

    // Get items list (used by Order)
    public List<CartItem> getItems() {
        return items;
    }

    // Clear cart after checkout
    public void clear() {
        items.clear();
    }
}
