package unigroup.qtp.model;

import lombok.Data;

@Data

public class Product {
    private String id;
    private String name;
    private float price;

    public Product(String id, String name, Integer price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
