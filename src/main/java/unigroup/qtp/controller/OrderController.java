package unigroup.qtp.controller;

import org.springframework.web.bind.annotation.*;
import unigroup.qtp.model.Order;
import unigroup.qtp.model.Product;
import unigroup.qtp.repository.OrderRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {
    OrderRepository repository = new OrderRepository();
    @GetMapping("/orders")
    public List<Order> getOrders(@RequestParam(value="id", defaultValue = "all") String id){
        List<Order> orders =
                id.equals("all") ?
                        repository.getOrders().values().stream().collect(Collectors.toList()):
                        Arrays.asList(repository.getOrders().get(id));
        return orders;
    }

    @PostMapping("/orders")
    public List<Order> addOrder(){
        return repository.addOrder();
    }


    @PutMapping("/orders/{id}")
    public List<Order> editOrder(@PathVariable String id, @RequestBody Order order){
        return repository.editOrder(id, order);
    }


    @DeleteMapping("/orders/{id}")
    public List<Order> deleteOrder(@PathVariable String id){
        return repository.deleteOrder(id);
    }

}
