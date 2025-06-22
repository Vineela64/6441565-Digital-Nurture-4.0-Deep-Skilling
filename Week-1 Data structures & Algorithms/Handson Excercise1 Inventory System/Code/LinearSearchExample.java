import java.util.Scanner;
public class LinearSearchExample {
    static class Product {
        int productId;
        String productName;
        String category;

        Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public String toString() {
            return "Product{" +
                    "productId=" + productId +
                    ", productName='" + productName + '\'' +
                    ", category='" + category + '\'' +
                    '}';
        }
    }
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product[] products = {
            new Product(105, "Mouse", "Electronics"),
            new Product(101, "Laptop", "Electronics"),
            new Product(103, "Notebook", "Stationery"),
            new Product(104, "Pen", "Stationery"),
            new Product(102, "Headphones", "Electronics")
        };

        System.out.print("Enter the product ID to search (Linear Search): ");
        int searchId = scanner.nextInt();

        Product result = linearSearch(products, searchId);

        System.out.println("\n Linear Search Result:");
        if (result != null) {
            System.out.println("Found: " + result);
        } else {
            System.out.println("Product not found.");
        }

        scanner.close();
    }
}
