public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobileUser = new MobileApp("Ram");
        Observer webUser = new WebApp("Vineela");

        market.registerObserver(mobileUser);
        market.registerObserver(webUser);

        System.out.println("Updating stock to: AAPL - $150.75");
        market.setStockPrice("AAPL", 150.75);

        System.out.println("\nUpdating stock to: GOOGL - $2800.60");
        market.setStockPrice("GOOGL", 2800.60);

        System.out.println("\nRemoving WebApp observer...");
        market.removeObserver(webUser);

        System.out.println("\nUpdating stock to: TSLA - $720.10");
        market.setStockPrice("TSLA", 720.10);
    }
}

