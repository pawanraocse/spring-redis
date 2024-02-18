package org.example.springredis.service;

import org.example.springredis.model.Product;

public interface ProductService {

    void save(Product product);
    void saveProduct(String key, Product product);
    Product getProductById(String id);
    void deleteProduct(String id);
}
