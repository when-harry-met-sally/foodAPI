package unigroup.qtp.controller;

import org.springframework.web.bind.annotation.*;
import unigroup.qtp.model.Product;
import unigroup.qtp.repository.OrderRepository;

import java.util.List;

@RestController
public class OrderController {
    OrderRepository repository = new OrderRepository();
    @GetMapping("/order")
    public List<Product> getOrder(){
       return repository.getProducts();
    }

    @PostMapping("/order")
    public List<Product> addOrder(@RequestBody Product newProduct){
        return repository.addProduct(newProduct);
    }

    @PutMapping("/order")
    public List<Product> addOrder(@RequestBody List<Product> products){
        repository.setProducts(products);
        return products;
    }

    @DeleteMapping("/order")
    public List<Product> deleteOrder(){
        return repository.clearProducts();
    }

}
