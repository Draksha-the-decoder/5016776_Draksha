import java.util.ArrayList;
import java.util.List;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product [ID=%s, Name=%s, Quantity=%d, Price=%.2f]", 
                             productId, productName, quantity, price);
    }
}

class Inventory {
    private List<Product> products_list;

    public Inventory() {
        products_list = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products_list.add(product);
        System.out.println("\nProduct Added:");
        System.out.printf("ID: %s\nName: %s\n", product.getProductId(), product.getProductName());
    }

    public void updateProduct(Product product) {
        boolean found = false;
        for (int i = 0; i < products_list.size(); i++) {
            if (products_list.get(i).getProductId().equals(product.getProductId())) {
                products_list.set(i, product);
                found = true;
                System.out.println("\nProduct Updated:");
                System.out.printf("ID: %s\nName: %s\n", product.getProductId(), product.getProductName());
                break;
            }
        }
        if (!found) {
            System.out.println("\nProduct unavailable.");
        }
    }

    public void deleteProduct(String productId) {
        boolean found = false;
        for (int i = 0; i < products_list.size(); i++) {
            if (products_list.get(i).getProductId().equals(productId)) {
                Product removedProduct = products_list.remove(i);
                found = true;
                System.out.println("\nProduct Removed:");
                System.out.println(removedProduct);
                break;
            }
        }
        if (!found) {
            System.out.println("\nProduct unavailable");
        }
    }

    public Product getProduct(String productId) {
        for (Product product : products_list) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public void displayAllProducts() {
        System.out.println("\nAll Products:");
        if (products_list.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product product : products_list) {
                System.out.println("###############################################");
                System.out.printf("ID: %s\n", product.getProductId());
                System.out.printf("Name: %s\n", product.getProductName());
                System.out.printf("Quantity: %d\n", product.getQuantity());
                System.out.printf("Price: %.2f\n", product.getPrice());
                System.out.println("##############################################");
            }
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding products
        Product product1 = new Product("P01", "Product 1", 50, 3000.0);
        Product product2 = new Product("P02", "Product 2", 90, 500.0);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        // Displaying all products
        inventory.displayAllProducts();

        // Updating a product
        Product updatedProduct1 = new Product("P01", "new Product 1", 150, 150.0);
        inventory.updateProduct(updatedProduct1);

        // Displaying a single product
        System.out.println("\nDetails of P02:");
        Product singleProduct = inventory.getProduct("P02");
        if (singleProduct != null) {
            System.out.println(singleProduct);
        } else {
            System.out.println("Product not found.");
        }

        // Deleting a product
        inventory.deleteProduct("P02");

        // Displaying all products after deletion
        inventory.displayAllProducts();
    }
}

// OUTPUT

// Product Added:
// ID: P01
// Name: Product 1

// Product Added:
// ID: P02
// Name: Product 2

// All Products:
// ##############################################
// ID: P01
// Name: Product 1
// Quantity: 50
// Price: 3000.00
// ##############################################
// ##############################################
// ID: P02
// Name: Product 2
// Quantity: 90
// Price: 500.00
// ##############################################

// Product Updated:
// ID: P01
// Name: new Product 1

// Details of P02:
// Product [ID=P02, Name=Product 2, Quantity=90, Price=500.00]

// Product Removed:
// Product [ID=P02, Name=Product 2, Quantity=90, Price=500.00]

// All Products:
// ##############################################
// ID: P01
// Name: new Product 1
// Quantity: 150
// Price: 150.00
// ##############################################
