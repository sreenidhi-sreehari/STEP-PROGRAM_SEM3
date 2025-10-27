import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void showDetails() {
        System.out.println("Product: " + name + ", Price: ₹" + price);
    }

    public String getName() {
        return name;
    }
}

class Order {
    private String orderId;
    private List<Product> products;

    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Added product '" + product.getName() + "' to Order " + orderId);
    }

    public void showOrderDetails() {
        System.out.println("Order " + orderId + " contains:");
        for (Product p : products) {
            p.showDetails();
        }
    }

    public String getOrderId() {
        return orderId;
    }
}

class Customer {
    private String name;
    private String email;
    private List<Order> orders;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order " + order.getOrderId());
    }

    public void showCustomerOrders() {
        System.out.println("Orders placed by " + name + ":");
        for (Order o : orders) {
            o.showOrderDetails();
        }
    }
}

public class ShoppingSystem {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Amit", "amit@gmail.com");
        Product laptop = new Product("Laptop", 55000);
        Product mobile = new Product("Mobile", 25000);
        Product mouse = new Product("Mouse", 800);
        Order order1 = new Order("O-101");
        order1.addProduct(laptop);
        order1.addProduct(mouse);
        Order order2 = new Order("O-102");
        order2.addProduct(mobile);
        customer1.placeOrder(order1);
        customer1.placeOrder(order2);
        customer1.showCustomerOrders();
    }
}
