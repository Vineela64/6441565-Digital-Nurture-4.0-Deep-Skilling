public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Alchemist", "Paulo Coelho"),
            new Book(2, "Clean Code", "Robert C. Martin"),
            new Book(3, "The Pragmatic Programmer", "Andrew Hunt"),
            new Book(4, "Effective Java", "Joshua Bloch")
        };

        System.out.println("== Linear Search ==");
        Book result1 = LibraryManager.linearSearch(books, "Clean Code");
        System.out.println(result1 != null ? "Found: " + result1 : "Not Found");


        LibraryManager.sortByTitle(books); 
        System.out.println("\n== Binary Search ==");
        Book result2 = LibraryManager.binarySearch(books, "Clean Code");
        System.out.println(result2 != null ? "Found: " + result2 : "Not Found");
    }
}

