package unigroup.qtp.repository;
import lombok.Data;
import unigroup.qtp.model.Product;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderRepository {
    private List<Product> products = new ArrayList<>();

    public List<Product> addProduct(Product newProduct){
        this.products.add(newProduct);
        return this.products;
    }

    public List<Product> clearProducts(){
        this.products = new ArrayList<>();
        return this.products;
    }
}
