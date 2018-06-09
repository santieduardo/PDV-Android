package eduardosanti.com.br.pdv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import eduardosanti.com.br.pdv.model.Sell;

public class DetailSellActivity extends AppCompatActivity {

    private Sell sell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sell);
    }
}
