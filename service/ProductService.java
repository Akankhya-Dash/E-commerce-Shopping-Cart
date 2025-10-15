package service;

import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ProductService {
    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();

        // Preloaded sample products for demo
        products.add(new Product(1, "Laptop", 65000.0, 10));
        products.add(new Product(2, "Smartphone", 25000.0, 20));
        products.add(new Product(3, "Headphones", 2000.0, 30));
        products.add(new Product(4, "Smartwatch", 5000.0, 15));
        products.add(new Product(5, "Backpack", 1200.0, 25));
    }

    // Display all products (formatted for console)
    public void listProducts() {
        System.out.println("\n🛍️ Available Products:");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-5s %-20s %-10s %-10s%n", "ID", "Product", "Price(₹)", "Stock");
        System.out.println("--------------------------------------------------");
        for (Product p : products) {
            System.out.printf("%-5d %-20s %-10.2f %-10d%n",
                    p.getId(), p.getName(), p.getPrice(), p.getStock());
        }
        System.out.println("--------------------------------------------------");
    }

    // Find product by ID
    public Product getProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    // Reduce stock after order
    public void reduceStock(int productId, int quantity) {
        Product p = getProductById(productId);
        if (p != null && p.getStock() >= quantity) {
            p.setStock(p.getStock() - quantity);
        } else {
            System.out.println("⚠️ Not enough stock for: " + p.getName());
        }
    }

    // Add a new product (optional admin feature)
    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added successfully!");
    }

    // Get all products
    public List<Product> getProducts() {
        return products;
    }
}
