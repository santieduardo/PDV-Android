package eduardosanti.com.br.pdv.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sell implements Serializable {

    private User user;
    private ArrayList<Product> products;

    public Sell(User user, ArrayList<Product> products) {
        this.user = user;
        this.products = products;
    }

    public Sell() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
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
