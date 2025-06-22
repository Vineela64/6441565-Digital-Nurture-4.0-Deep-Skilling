public class Main {
    public static void main(String[] args) {
        Order[] orders1 = {
            new Order(1, "Vineela", 250.50),
            new Order(2, "Ram", 99.99),
            new Order(3, "Saina", 300.00),
            new Order(4, "Priya", 150.75)
        };

        Order[] orders2 = orders1.clone();
        System.out.println("== Orders Sorted by Bubble Sort ==");
        OrderSorter.bubbleSort(orders1);
        OrderSorter.printOrders(orders1);

        
        System.out.println("\n== Orders Sorted by Quick Sort ==");
        OrderSorter.quickSort(orders2, 0, orders2.length - 1);
        OrderSorter.printOrders(orders2);
    }
}

