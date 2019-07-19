package unigroup.qtp.repository;
import lombok.Data;
import unigroup.qtp.model.Order;
import unigroup.qtp.model.Product;

import java.util.*;
import java.util.stream.Collectors;


@Data
public class OrderRepository {
    private Map<String, Order> orders = new HashMap();

    private void validateOrderID(String id) {
        Order order = this.orders.get(id);

        if (order == null)
            throw new IllegalArgumentException("Could not find Order with provided ID");
    }

    public List<Order> ordersMapToList() {
        return this.orders.values().stream().collect(Collectors.toList());
    }

    public List<Order> addOrder(){
        Order order = new Order();
        this.orders.put(order.getId(), order);
        return this.ordersMapToList();
    }

    public List<Order> editOrder(String id, Order edit){
        this.validateOrderID(id);

        edit.setPrice(this.calculateTotalPrice(edit));
        this.orders.put(id, edit);

        return this.ordersMapToList();
    }

    public List<Order> deleteOrder(String id){
        this.validateOrderID(id);

        orders.remove(id);
        return this.ordersMapToList();
    }

    private float calculateTotalPrice(Order order){
        float total = 0;
        for (Product product: order.getCart()){
            total += product.getPrice();
        }

        return total;
    }
}
