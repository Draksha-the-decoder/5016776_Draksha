import java.util.*;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: $" + totalPrice;
    }
}

public class OrderSorter {

    public static void bubbleSort(Order[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].totalPrice > arr[j + 1].totalPrice) {
                    Order temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // no of orders
        int n = 5;
       
        Order[] orders = new Order[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for order #" + (i + 1) + ":");
            System.out.print("Order ID: ");
            int orderId = scanner.nextInt();

            System.out.print("Customer Name: ");
            String customerName = scanner.nextLine();

            System.out.print("Total Price: ");
            double totalPrice = scanner.nextDouble();

            orders[i] = new Order(orderId, customerName, totalPrice);
        }

        System.out.println("\nOrders before sorting:");
        for (Order order : orders) {
            System.out.println(order);
        }

        bubbleSort(orders);
        System.out.println("\nOrders after Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Resetting orders for Quick Sort demonstration
        for (int i = 0; i < n; i++) {
            System.out.println("Re-enter details for order #" + (i + 1) + ":");
            System.out.print("Order ID: ");
            int orderId = scanner.nextInt();

            System.out.print("Customer Name: ");
            String customerName = scanner.nextLine();

            System.out.print("Total Price: ");
            double totalPrice = scanner.nextDouble();

            orders[i] = new Order(orderId, customerName, totalPrice);
        }

        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nOrders after Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        scanner.close();
    }
}