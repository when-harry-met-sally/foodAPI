package unigroup.qtp.repository;
import lombok.Data;
import unigroup.qtp.model.Order;
import unigroup.qtp.model.Product;

import java.util.*;
import java.util.stream.Collectors;


@Data
public class OrderRepository {
    private Map<String, Order> orders = new HashMap();

    public List<Order> addOrder(){
        String id =  UUID.randomUUID().toString();
        this.orders.put(id, new Order(id));
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
