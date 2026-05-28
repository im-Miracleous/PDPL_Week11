package com.store.main;

import com.store.dao.*;
import com.store.dao.impl.*;
import com.store.model.*;

import java.util.Scanner;

public class MainSystem {

    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoImpl();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== PRODUCT INVENTORY MENU ===");
            System.out.println("1. View All Products");
            System.out.println("2. View Product by ID");
            System.out.println("3. Add New Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                continue; // Kembali ke awal loop jika input bukan angka
            }

            switch (choice) {
                case 1:
                    System.out.println("\n--- All Products ---");
                    printAllProducts(productDao);
                    break;
                case 2:
                    System.out.print("Enter Product ID: ");
                    try {
                        int searchId = Integer.parseInt(scanner.nextLine());
                        Product foundProduct = productDao.getProductById(searchId);
                        if (foundProduct != null) {
                            System.out.println("Found: " + foundProduct.toString());
                        } else {
                            System.out.println("Product with ID " + searchId + " not found!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID format!");
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Enter Product ID: ");
                        int newId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Product Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter Product Price: ");
                        double newPrice = Double.parseDouble(scanner.nextLine());

                        Product newProduct = new Product(newId, newName, newPrice);
                        productDao.addProduct(newProduct);
                    } catch (NumberFormatException e) {
                        System.out.println("Failed to add product. Make sure ID and Price are numbers.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Product ID to update: ");
                    try {
                        int updateId = Integer.parseInt(scanner.nextLine());
                        Product productToUpdate = productDao.getProductById(updateId);

                        if (productToUpdate != null) {
                            System.out.print("Enter new Name (current: " + productToUpdate.getName() + "): ");
                            String updatedName = scanner.nextLine();
                            System.out.print("Enter new Price (current: " + productToUpdate.getPrice() + "): ");
                            double updatedPrice = Double.parseDouble(scanner.nextLine());

                            // Set data baru
                            productToUpdate.setName(updatedName);
                            productToUpdate.setPrice(updatedPrice);

                            // Simpan perubahan lewat DAO
                            productDao.updateProduct(productToUpdate);
                        } else {
                            System.out.println("Update failed: Product with ID " + updateId + " not found!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input format!");
                    }
                    break;
                case 5:
                    System.out.print("Enter Product ID to delete: ");
                    try {
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        if (productDao.getProductById(deleteId) != null) {
                            productDao.deleteProduct(deleteId);
                        } else {
                            System.out.println("Delete failed: Product with ID " + deleteId + " not found!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID format!");
                    }
                    break;
                case 6:
                    isRunning = false;
                    System.out.println("Exiting program... Thank you!");
                    break;
                default:
                    System.out.println("Invalid option! Please choose between 1-6.");
            }
        }

        scanner.close();
    }

    // Helper method to print products
    private static void printAllProducts(ProductDao dao) {
        for (Product product : dao.getAllProducts()) {
            System.out.println(product.toString());
        }
    }
}
