// PerishableProduct.java
// Author: Het Patel
// Date: July 30, 2024
// Description: represents a perishable item in a retail setting; it is derived from Product.

import java.util.Date;

public class PerishableProduct extends Product {
    private Date expiryDate;

    // Default constructor
    public PerishableProduct() {
        super();
        this.expiryDate = new Date();
    }

    // Parametrized constructor
    public PerishableProduct(long sku, String name, double unitCost, double salePrice, int quantityOnHand, int quantityNeeded, String specialInstructions, Date expiryDate) {
        super(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions);
        this.expiryDate = expiryDate;
    }

    // Getter and Setter for expiryDate
    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Override display method
    @Override
    public String toString() {
        return super.toString() + String.format("Expiry Date: %s\n", expiryDate.toString());
    }
}
