import java.util.Arrays;

class Product implements Comparable<Product> {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int compareTo(Product other) {
        return this.productName.compareToIgnoreCase(other.productName);
    }
    
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class EcommerceSearch {

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);

            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear"),
            new Product(103, "Watch", "Accessories"),
            new Product(104, "Smartphone", "Electronics")
        };

        // Linear Search (no need to sort)
        System.out.println("Linear Search Result:");
        Product result1 = linearSearch(products, "watch");
        System.out.println(result1 != null ? result1 : "Product not found");

        // Binary Search (requires sorted array)
        Arrays.sort(products);
        System.out.println("\nBinary Search Result:");
        Product result2 = binarySearch(products, "watch");
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}