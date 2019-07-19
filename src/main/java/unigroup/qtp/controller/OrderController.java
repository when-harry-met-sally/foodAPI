package unigroup.qtp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import unigroup.qtp.model.Order;
import unigroup.qtp.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class OrderController {
    OrderRepository repository = new OrderRepository();
    @GetMapping("/orders")
    public List<Order> getOrders(@RequestParam(value="favorite", required = false) Boolean favoriteQuery,
                                 @RequestParam(value="rating", required = false) Integer ratingQuery) {
        log.info("Get All Orders Request Received");

        List<Order> orders = repository.ordersMapToList();
        if (favoriteQuery != null) {
            orders = orders.stream().filter(order -> order.getFavorite() == favoriteQuery).collect(Collectors.toList());
        }

        if (ratingQuery != null) {
            orders =
                    orders.stream().filter(order -> order.getRating().equals(ratingQuery)).collect(Collectors.toList());
        }

        return orders;
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@RequestParam(value="id") String id) {
        log.info("Get Orders By ID Request Received: ID {}", id);
        return repository.getOrders().get(id);
    }

    @PostMapping("/orders")
    public List<Order> addOrder(){
        log.info("Add New Order Request Received");
        return repository.addOrder();
    }


    @PutMapping("/orders/{id}")
    public List<Order> editOrder(@PathVariable String id, @RequestBody Order order) {
        log.info("Edit Order Request Received: ID {}", id);
        return repository.editOrder(id, order);
    }

    @DeleteMapping("/orders/{id}")
    public List<Order> deleteOrder(@PathVariable String id) {
        log.info("Delete Order Request Received: ID {}", id);
        return repository.deleteOrder(id);
    }

    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String IllegalArgumentException(IllegalArgumentException iae) {
        return iae.getMessage();
    }
}
