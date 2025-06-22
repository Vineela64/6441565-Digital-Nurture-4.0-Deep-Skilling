import java.util.*;
public class BinarySearchExample {
    static class Product {
        int productId;
        String name;

        Product(int productId, String name) {
            this.productId = productId;
            this.name = name;
        }

        public String toString() {
            return productId + " - " + name;
        }
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop"),
            new Product(102, "Mouse"),
            new Product(103, "Keyboard"),
            new Product(104, "Monitor"),
            new Product(105, "Printer")
        };

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product ID to search: ");
        int targetId = sc.nextInt();

        int low = 0, high = products.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].productId == targetId) {
                System.out.println("Product found: " + products[mid]);
                found = true;
                break;
            } else if (products[mid].productId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }

        sc.close();
    }
}
