package unigroup.qtp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@AllArgsConstructor
@Data
public class Order {
    private String id;
    private List<Product> cart;
    private float price;
    private String status;
    private Boolean favorite;
    private Integer rating;

    public Order (){
        this.id = UUID.randomUUID().toString();
        this.cart = new ArrayList<>();
        this.price = 0;
        this.status = "INCOMPLETE";
        this.favorite = false;
        this.rating = null;
    }

}
