package org.riwi.delivery.service;

import org.riwi.delivery.model.entity.DeliveryMan;
import org.riwi.delivery.model.entity.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
    private final ArrayList<Product> products = new ArrayList<>();
    Scanner objScanner = new Scanner(System.in);

    public void createProductStatic() {
        Product product1 = new Product("1", "CocaCola", "Bebidas", 2000);
        products.add(product1);
        Product product2 = new Product("2", "Pepsi", "Bebidas", 1800);
        products.add(product2);
        Product product3 = new Product("3", "Fanta", "Bebidas", 1700);
        products.add(product3);
        Product product4 = new Product("4", "Sprite", "Bebidas", 1900);
        products.add(product4);
        Product product5 = new Product("5", "Agua Mineral", "Bebidas", 1500);
        products.add(product5);
        Product product6 = new Product("6", "Cerveza Heineken", "Bebidas Alcohólicas", 3000);
        products.add(product6);
        Product product7 = new Product("7", "Vino Tinto", "Bebidas Alcohólicas", 5000);
        products.add(product7);
        Product product8 = new Product("8", "Whisky Jack Daniels", "Bebidas Alcohólicas", 7000);
        products.add(product8);
        Product product9 = new Product("9", "Leche", "Lácteos", 2500);
        products.add(product9);
        Product product10 = new Product("10", "Yogur Natural", "Lácteos", 1200);
        products.add(product10);
        Product product11 = new Product("11", "Queso Gouda", "Lácteos", 3500);
        products.add(product11);
        Product product12 = new Product("12", "Huevos", "Lácteos", 1800);
        products.add(product12);
        Product product13 = new Product("13", "Pan Integral", "Panadería", 1800);
        products.add(product13);
        Product product14 = new Product("14", "Croissant", "Panadería", 2000);
        products.add(product14);
        Product product15 = new Product("15", "Torta de Chocolate", "Repostería", 4000);
        products.add(product15);
    }
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
            System.out.println("======================");
        }
    }
}
