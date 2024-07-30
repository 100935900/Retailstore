// Main.java
// Author: Het Patel
// Date: July 30, 2024
// Description: primary software used in retail stores for product management

import java.util.*;

public class Main {
    private static List<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1) Create Product");
            System.out.println("2) Create Perishable Product");
            System.out.println("3) Edit Product by SKU");
            System.out.println("4) Delete Product by SKU");
            System.out.println("5) Display Product by SKU");
            System.out.println("6) Display all Products");
            System.out.println("7) Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    createPerishableProduct();
                    break;
                case 3:
                    editProductBySku();
                    break;
                case 4:
                    deleteProductBySku();
                    break;
                case 5:
                    displayProductBySku();
                    break;
                case 6:
                    displayAllProducts();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createProduct() {
        try {
            System.out.println("Enter SKU:");
            long sku = Long.parseLong(scanner.nextLine());
            System.out.println("Enter Product Name:");
            String name = scanner.nextLine();
            System.out.println("Enter Unit Cost:");
            double unitCost = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter Sale Price:");
            double salePrice = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter Quantity on hand:");
            int quantityOnHand = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Quantity needed:");
            int quantityNeeded = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Special Instructions:");
            String specialInstructions = scanner.nextLine();

            Product product = new Product(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions);
            products.add(product);
            System.out.println("Product created successfully.");
        } catch (Exception e) {
            System.out.println("Error creating product: " + e.getMessage());
        }
    }

    private static void createPerishableProduct() {
        try {
            System.out.println("Enter SKU:");
            long sku = Long.parseLong(scanner.nextLine());
            System.out.println("Enter Product Name:");
            String name = scanner.nextLine();
            System.out.println("Enter Unit Cost:");
            double unitCost = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter Sale Price:");
            double salePrice = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter Quantity on hand:");
            int quantityOnHand = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Quantity needed:");
            int quantityNeeded = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Special Instructions:");
            String specialInstructions = scanner.nextLine();
            System.out.println("Enter Expiry Date (yyyy-mm-dd):");
            Date expiryDate = new Date(scanner.nextLine());

            PerishableProduct perishableProduct = new PerishableProduct(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions, expiryDate);
            products.add(perishableProduct);
            System.out.println("Perishable Product created successfully.");
        } catch (Exception e) {
            System.out.println("Error creating perishable product: " + e.getMessage());
        }
    }

    private static void editProductBySku() {
        System.out.println("Enter SKU:");
        long sku = Long.parseLong(scanner.nextLine());
        Product product = findProductBySku(sku);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        try {
            System.out.println("Enter new Product Name:");
            String name = scanner.nextLine();
            System.out.println("Enter new Unit Cost:");
            double unitCost = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter new Sale Price:");
            double salePrice = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter new Quantity on hand:");
            int quantityOnHand = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter new Quantity needed:");
            int quantityNeeded = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter new Special Instructions:");
            String specialInstructions = scanner.nextLine();

            product.setName(name);
            product.setUnitCost(unitCost);
            product.setSalePrice(salePrice);
            product.setQuantityOnHand(quantityOnHand);
            product.setQuantityNeeded(quantityNeeded);
            product.setSpecialInstructions(specialInstructions);

            System.out.println("Product updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating product: " + e.getMessage());
        }
    }

    private static void deleteProductBySku() {
        System.out.println("Enter SKU:");
        long sku = Long.parseLong(scanner.nextLine());
        Product product = findProductBySku(sku);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        products.remove(product);
        System.out.println("Product deleted successfully.");
    }

    private static void displayProductBySku() {
        System.out.println("Enter SKU:");
        long sku = Long.parseLong(scanner.nextLine());
        Product product = findProductBySku(sku);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println(product);
    }

    private static void displayAllProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static Product findProductBySku(long sku) {
        for (Product product : products) {
            if (product.getSku() == sku) {
                return product;
            }
        }
        return null;
    }
}
