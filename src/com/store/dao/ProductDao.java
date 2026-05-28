package com.store.dao;

import com.store.model.Product;
import java.util.List;

public interface ProductDao {
    // Retrieve all products
    List<Product> getAllProducts();

    // Retrieve a single product by its ID
    Product getProductById(int id);

    // Add a new product to the database
    void addProduct(Product product);

    // Update an existing product
    void updateProduct(Product product);

    // Delete a product from the database
    void deleteProduct(int id);
}
