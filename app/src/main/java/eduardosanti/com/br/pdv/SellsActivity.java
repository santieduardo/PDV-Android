package eduardosanti.com.br.pdv;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import eduardosanti.com.br.pdv.adapter.SellAdapter;
import eduardosanti.com.br.pdv.intentidentifier.IntentIdentifier;
import eduardosanti.com.br.pdv.model.Product;
import eduardosanti.com.br.pdv.model.Sell;
import eduardosanti.com.br.pdv.model.User;
import eduardosanti.com.br.pdv.requestcodes.RequestCodes;

public class SellsActivity extends AppCompatActivity implements SellAdapter.SellOnClickListener {

    private User user;
    private ArrayList<Sell> sells = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter sellAdapter;
    private RecyclerView.LayoutManager layoutManager;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sells);

        this.bindView();
        this.setupView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RequestCodes.CREATE_SELL) {
            if (resultCode == RESULT_OK) {
                // TODO: Add to the arrayList the created sell

                //Contact newContact = (Contact) data.getSerializableExtra("newContact");

                //this.arrayList.add(newContact);
            }
        }

        this.sellAdapter.notifyDataSetChanged();
    }

    private void bindView() {
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    private void setupView() {
        Intent intent = getIntent();
        this.user = (User) intent.getSerializableExtra("LoggedUser");
        this.showSnackbar("Bem vindo, " + this.user.getEmail());

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Batata", 2, 1.5));
        products.add(new Product("Cenoura", 2, 2.5));
        products.add(new Product("Alface", 2, 3.5));

        this.sells.add(new Sell(this.user, products));

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        sellAdapter = new SellAdapter(this.sells, this);
        recyclerView.setAdapter(sellAdapter);
    }

    public void fabOnClick(View view) {
        Intent intent = new Intent(this, CreateSellActivity.class);
        intent.putExtra(IntentIdentifier.REQUEST_CODE, RequestCodes.CREATE_SELL);
        intent.putExtra(IntentIdentifier.CURRENT_USER, this.user);
        startActivityForResult(intent, RequestCodes.CREATE_SELL);
    }

    private void showSnackbar(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }

    /*
     *
     * SellAdapter.SellOnClickListener
     *
     * */
    @Override
    public void onClick(View view, int position) {
        Intent intent = new Intent(this, DetailSellActivity.class);
        intent.putExtra(IntentIdentifier.SELECTED_SELL, this.sells.get(position));

        startActivity(intent);
    }

}
