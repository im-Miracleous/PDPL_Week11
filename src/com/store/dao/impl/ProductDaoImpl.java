package com.store.dao.impl;

import com.store.dao.ProductDao;
import com.store.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    // This List acts as our temporary database
    private List<Product> database;

    public ProductDaoImpl() {
        database = new ArrayList<>();
        // Seed initial data into the "database"
        database.add(new Product(1, "Laptop ASUS ROG", 1500.00));
        database.add(new Product(2, "Mechanical Keyboard", 100.00));
        database.add(new Product(3, "Wireless Mouse", 50.00));
    }

    @Override
    public List<Product> getAllProducts() {
        return database; // Return all records
    }

    @Override
    public Product getProductById(int id) {
        for (Product product : database) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null; // Return null if not found (Print teks not found dihapus agar tidak muncul saat proses validasi)
    }

    @Override
    public void addProduct(Product product) {
        // --- VALIDASI ID GANDA ---
        if (getProductById(product.getId()) != null) {
            System.out.println("Error: Cannot add! Product with ID " + product.getId() + " already exists.");
            return; // Batalkan proses penambahan
        }
        // -------------------------

        database.add(product);
        System.out.println("Product: [" + product.getName() + "] has been added to the database.");
    }

    @Override
    public void updateProduct(Product product) {
        Product existingProduct = getProductById(product.getId());
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            System.out.println("Product ID " + product.getId() + " has been successfully updated.");
        }
    }

    @Override
    public void deleteProduct(int id) {
        Product product = getProductById(id);
        if (product != null) {
            database.remove(product);
            System.out.println("Product ID " + id + " has been deleted from the database.");
        }
    }
}
