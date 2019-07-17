package unigroup.qtp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class Order {
    private String id;
    private Map<Product, Integer> cart;
    private float price;

    public Order (String id){
        this.id = id;
        this.cart = new HashMap<>();
        this.price = 0;
    }

}
