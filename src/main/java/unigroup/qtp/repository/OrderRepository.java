package unigroup.qtp.repository;
import lombok.Data;
import unigroup.qtp.model.Order;
import java.util.*;
import java.util.stream.Collectors;


@Data
public class OrderRepository {
    private Map<String, Order> orders = new HashMap();

    public List<Order> addOrder(){
        Order order = new Order();
        this.orders.put(order.getId(), order);
        return this.orders.values().stream().collect(Collectors.toList());
    }

    public List<Order> editOrder(String id, Order edit){
        orders.put(id, edit);
        return this.orders.values().stream().collect(Collectors.toList());
    }

    public List<Order> deleteOrder(String id){
        orders.remove(id);
        return this.orders.values().stream().collect(Collectors.toList());
    }
}
