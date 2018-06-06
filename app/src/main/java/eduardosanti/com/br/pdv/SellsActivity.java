package eduardosanti.com.br.pdv;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import eduardosanti.com.br.pdv.model.Product;
import eduardosanti.com.br.pdv.model.Sell;
import eduardosanti.com.br.pdv.model.User;

public class SellsActivity extends AppCompatActivity {

    private User user;
    private List<Sell> sells = new ArrayList<>();

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sells);

        this.bindView();
        this.setupView();
    }

    private void bindView() {
        this.fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    private void setupView() {
        Intent intent = getIntent();
        this.user = (User) intent.getSerializableExtra("LoggedUser");
        this.showSnackbar("Bem vindo, " + this.user.getEmail());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Batata", 2, 1.5));
        products.add(new Product("Cenoura", 2, 2.5));
        products.add(new Product("Alface", 2, 3.5));

        this.sells.add(new Sell(this.user, products));
    }

    public void fabOnClick(View view) {

    }

    private void showSnackbar(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }

}
