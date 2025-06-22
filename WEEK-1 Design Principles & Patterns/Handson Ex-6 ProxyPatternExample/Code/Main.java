public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("forest.jpg");
        Image image2 = new ProxyImage("beach.png");

        System.out.println("Displaying image1 first time:");
        image1.display();

        System.out.println("\nDisplaying image1 second time:");
        image1.display();

        System.out.println("\nDisplaying image2 first time:");
        image2.display();
    }
}

