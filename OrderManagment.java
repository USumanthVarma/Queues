package demo;

import java.util.*;
import java.util.stream.Collectors;
class Order {
    private final String product;
    private final String category;
    private final double amount;
    public Order(String product, String category, double amount) {
        this.product = product;
        this.category = category;
        this.amount = amount;
    }
    public String getProduct()  { return product; }
    public String getCategory() { return category; }
    public double getAmount()   { return amount; }
}
public class OrderManagment {
    public static double totalRevenue(List<Order> orders) {
        return orders.stream()
                .mapToDouble(Order::getAmount)
                .sum();
    }
    public static Map<String, Double> revenueByCategory(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCategory,
                        TreeMap::new,
                        Collectors.summingDouble(Order::getAmount)
                ));
    }
    public static Order highestOrder(List<Order> orders) {
        return orders.stream()
                .max(Comparator.comparingDouble(Order::getAmount))
                .orElse(null);
    }
    public static List<String> ordersAbove(List<Order> orders, double threshold) {
        return orders.stream()
                .filter(o -> o.getAmount() > threshold)
                .sorted(Comparator.comparingDouble(Order::getAmount).reversed())
                .map(Order::getProduct)
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("Laptop", "Electronics", 1200.0),
            new Order("Phone", "Electronics", 800.0),
            new Order("Desk", "Furniture", 300.0),
            new Order("Chair", "Furniture", 150.0),
            new Order("Monitor", "Electronics", 400.0),
            new Order("Notebook", "Stationery", 50.0)
        );
        double threshold = 300.0;
        System.out.println("Total revenue: " + totalRevenue(orders));
        System.out.println("Revenue by category:");
        for (Map.Entry<String, Double> e : revenueByCategory(orders).entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
        Order top = highestOrder(orders);
        System.out.println("Highest order: " + top.getProduct() + " (" + top.getAmount() + ")");
        System.out.println("Orders above " + threshold + ": "
                + String.join(", ", ordersAbove(orders, threshold)));
    }
}