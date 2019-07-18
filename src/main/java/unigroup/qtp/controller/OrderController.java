package unigroup.qtp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import unigroup.qtp.model.Order;
import unigroup.qtp.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {
    OrderRepository repository = new OrderRepository();
    @GetMapping("/orders")
    public List<Order> getOrders(@RequestParam(value="favorite", required = false) Boolean favoriteQuery, @RequestParam(value="rating", required = false) Integer ratingQuery){
        List<Order> orders = repository.getOrders().values().stream().collect(Collectors.toList());
        if (favoriteQuery != null){
            orders = orders.stream().filter(order -> order.getFavorite() == favoriteQuery).collect(Collectors.toList());
        }
        if (ratingQuery != null){
            orders = orders.stream().filter(order -> order.getRating() == ratingQuery).collect(Collectors.toList());
        }
        return orders;
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@RequestParam(value="id") String id){
        return repository.getOrders().get(id);
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

    //EXCEPTION HANDLING

//    @ResponseBody
//    @ExceptionHandler(IllegalArgumentException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String IllegalArgumentException(IllegalArgumentException ex) {
//        return "Illegal Argument";
//    }

//    @ResponseBody
//    @ExceptionHandler(GameNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String GameNotFoundException(GameNotFoundException ex) {
//        log.warn("Game not found",ex);
//        return "Game not found";
//    }




}
