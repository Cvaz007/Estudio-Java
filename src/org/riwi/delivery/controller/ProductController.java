package org.riwi.delivery.controller;

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
}
