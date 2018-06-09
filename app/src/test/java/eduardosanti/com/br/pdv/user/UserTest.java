package eduardosanti.com.br.pdv.user;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import eduardosanti.com.br.pdv.model.Product;
import eduardosanti.com.br.pdv.model.Sell;
import eduardosanti.com.br.pdv.model.User;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private Sell sell;

    @Before
    public void setUp() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Batata", 2, 1.5));
        products.add(new Product("Cenoura", 2, 2.5));
        products.add(new Product("Alface", 2, 3.5));

        this.sell = new Sell(new User("admin@gmail.com", "admin"), products);
    }

    @Test
    public void checkSellAmount() {
        assertEquals(15.0, this.sell.getAmount(), 0);
    }
}
