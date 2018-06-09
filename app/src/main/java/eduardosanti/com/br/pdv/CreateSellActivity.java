package eduardosanti.com.br.pdv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateSellActivity extends AppCompatActivity implements TextWatcher {

    private EditText editTextProduct;
    private EditText editTextQuantity;
    private EditText editTextPrice;
    private Button buttonAddProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_sell);

        this.bindView();
        this.setupView();
    }

    private void bindView() {
        this.editTextProduct = (EditText) findViewById(R.id.editTextProduct);
        this.editTextQuantity = (EditText) findViewById(R.id.editTextQuantity);
        this.editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        this.buttonAddProduct = (Button) findViewById(R.id.buttonAddProduct);
    }

    private void setupView() {
        this.buttonAddProduct.setEnabled(false);
        this.editTextProduct.addTextChangedListener(this);
        this.editTextQuantity.addTextChangedListener(this);
        this.editTextPrice.addTextChangedListener(this);

    }

    public void onAddProduct(View view) {

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
