package org.riwi.delivery.service;

import org.riwi.delivery.model.entity.DeliveryMan;
import org.riwi.delivery.model.entity.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
    private final ArrayList<Product> products = new ArrayList<>();
    Scanner objScanner = new Scanner(System.in);

    public void createProduct() {
        System.out.print("Enter product name:");
        String name = objScanner.next();
        System.out.print("Enter product price:");
        double price = objScanner.nextDouble();
        System.out.print("Enter category:");
        String category = objScanner.next();
        String id = String.valueOf(System.currentTimeMillis());

        Product product = new Product(id, name, category, price);
        products.add(product);
    }

    public void deleteProduct(String id) {
        Product currentProduct = getProductById(id);
        products.remove(currentProduct);
    }

    public void updateProduct(String id) {
        System.out.print("Enter new product name:");
        String name = objScanner.next();
        System.out.print("Enter new product price:");
        double price = objScanner.nextDouble();
        System.out.print("Enter new category:");
        String category = objScanner.next();

        Product product = getProductById(id);

        product.setCategory(category);
        product.setName(name);
        product.setPrice(price);
    }

    public Product getProductById(String id) {
        if (!products.isEmpty()) {
            for (Product product : products) {
                System.out.println(product.getId());
                if (product.getId().equalsIgnoreCase(id)) {
                    return product;
                }
            }
        }
        return null;
    }

    public void showProducts() {
        for (Product product : products) {
            System.out.println("Product: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Category: " + product.getCategory());
            System.out.println("Price: " + product.getPrice());
        }
    }
}
