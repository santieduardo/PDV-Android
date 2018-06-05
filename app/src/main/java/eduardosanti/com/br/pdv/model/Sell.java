package eduardosanti.com.br.pdv.model;

import java.io.Serializable;
import java.util.List;

public class Sell implements Serializable {

    private User user;
    private List<Product> products;
    private double amount;

    public Sell(User user, List<Product> products, double amount) {
        this.user = user;
        this.products = products;
        this.amount = amount;
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
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
