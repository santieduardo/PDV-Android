package eduardosanti.com.br.pdv.model;

import java.io.Serializable;
import java.util.List;

public class Sell implements Serializable {

    private User user;
    private List<Product> products;

    public Sell(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getAmount() {
        double amount = 0;

        for(Product product: this.products) {
            amount += product.getPrice() * product.getQuantity();
        }

        return amount;
    }

}
