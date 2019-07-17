package unigroup.qtp.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Order {
    private Map<String, Product> cart;
    private float price;

    public Order (){
        this.cart = new HashMap<>();
        this.price = 0;
    }
}
