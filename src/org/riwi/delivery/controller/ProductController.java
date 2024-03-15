package org.riwi.delivery.controller;

import org.riwi.delivery.model.entity.Product;
import org.riwi.delivery.service.ProductService;

public class ProductController {
    private final ProductService productService = new ProductService();
    public void create(){
        productService.createProduct();
    }
    public void delete(String id){
        productService.deleteProduct(id);
    }
    public void update(String id){
        productService.updateProduct(id);
    }
    public void showProducts(){
        productService.showProducts();
    }
    public Product getProductById(String id) {
        return productService.getProductById(id);
    }
    public void createProductStatic(){
        productService.createProductStatic();
    }
}
