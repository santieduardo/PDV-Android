package eduardosanti.com.br.pdv;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import eduardosanti.com.br.pdv.adapter.DetailSellAdapter;
import eduardosanti.com.br.pdv.intentidentifier.IntentIdentifier;
import eduardosanti.com.br.pdv.model.Product;
import eduardosanti.com.br.pdv.model.Sell;
import eduardosanti.com.br.pdv.model.User;
import eduardosanti.com.br.pdv.util.Util;


public class CreateSellActivity extends AppCompatActivity implements TextWatcher {

    private EditText editTextProduct;
    private EditText editTextQuantity;
    private EditText editTextPrice;
    private Button buttonAddProduct;
    private Button buttonCheckout;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter detailSellAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private Sell sell = new Sell();
    private User user;
    private ArrayList<Product> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_sell);

        this.bindView();
        this.setupView();
    }

    private void bindView() {
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.editTextProduct = (EditText) findViewById(R.id.editTextProduct);
        this.editTextQuantity = (EditText) findViewById(R.id.editTextQuantity);
        this.editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        this.buttonAddProduct = (Button) findViewById(R.id.buttonAddProduct);
        this.buttonCheckout = (Button) findViewById(R.id.buttonCheckout);
    }

    private void setupView() {
        this.buttonAddProduct.setEnabled(false);
        this.buttonCheckout.setEnabled(false);
        this.editTextProduct.addTextChangedListener(this);
        this.editTextQuantity.addTextChangedListener(this);
        this.editTextPrice.addTextChangedListener(this);

        this.getExtra(IntentIdentifier.CURRENT_USER);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        detailSellAdapter = new DetailSellAdapter(this.arrayList);
        recyclerView.setAdapter(detailSellAdapter);
    }

    private void getExtra(String identifier) {
        Intent intent = getIntent();
        this.user = (User) intent.getSerializableExtra(identifier);

        this.sell.setUser(this.user);
    }

    public void onAddProduct(View view) {
        this.arrayList.add(new Product(
                this.editTextProduct.getText().toString(),
                Integer.valueOf(this.editTextQuantity.getText().toString()),
                Double.valueOf(this.editTextPrice.getText().toString())));

        this.sell.setProducts(this.arrayList);

        this.clearFields();

        this.dismissKeyboard();

        this.detailSellAdapter.notifyDataSetChanged();

        this.buttonCheckout.setEnabled(true);
        this.buttonCheckout.setText("Checkout (" + Util.currencyFormat(this.sell.getAmount()) + ")");
    }

    public void onCheckout(View view) {
        Intent intent = new Intent();
        intent.putExtra(IntentIdentifier.NEW_SELL, this.sell);
        setResult(RESULT_OK, intent);

        finish();
    }

    private void clearFields() {
        this.editTextProduct.setText("");
        this.editTextQuantity.setText("");
        this.editTextPrice.setText("");

        this.editTextProduct.requestFocus();
    }

    private void dismissKeyboard() {
        View view = this.getCurrentFocus();

        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /*
     *
     * TextWatcher
     *
     **/

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (
                this.editTextProduct.getText().toString().isEmpty() ||
                this.editTextProduct.getText().toString().length() < 3 ||
                this.editTextQuantity.getText().toString().isEmpty() ||
                Integer.valueOf(this.editTextQuantity.getText().toString()) < 1 ||
                this.editTextPrice.getText().toString().isEmpty() ||
                Double.valueOf(this.editTextPrice.getText().toString()) <= 0
            ) {
            this.buttonAddProduct.setEnabled(false);
        } else {
            this.buttonAddProduct.setEnabled(true);
        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
