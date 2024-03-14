package org.riwi.delivery.service;

import org.riwi.delivery.model.entity.DeliveryMan;
import org.riwi.delivery.model.entity.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
    private final ArrayList<Product> products = new ArrayList<>();
    Scanner objScanner = new Scanner(System.in);

    public void createProduct() {

    }

    public void deleteProduct(String id) {
        Product currentProduct = getProductById(id);
        products.remove(currentProduct);
    }

    public void updateProduct(String id) {

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
}
