public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Mobile", "Electronics"),
            new Product(104, "T-shirt", "Fashion")
        };
        System.out.println("== Linear Search ==");
        Product result1 = SearchAlgorithms.linearSearch(products, "Mobile");
        System.out.println(result1 != null ? "Found: " + result1 : "Not Found");
        SearchAlgorithms.sortByName(products);

        System.out.println("\n== Binary Search ==");
        Product result2 = SearchAlgorithms.binarySearch(products, "Mobile");
        System.out.println(result2 != null ? "Found: " + result2 : "Not Found");
    }
}

