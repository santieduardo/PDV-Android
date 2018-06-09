package eduardosanti.com.br.pdv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import eduardosanti.com.br.pdv.adapter.DetailSellAdapter;
import eduardosanti.com.br.pdv.adapter.SellAdapter;
import eduardosanti.com.br.pdv.intentidentifier.IntentIdentifier;
import eduardosanti.com.br.pdv.model.Sell;

public class DetailSellActivity extends AppCompatActivity {

    private Sell sell;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter detailSellAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sell);

        this.bindView();
        this.setupView();
    }

    private void bindView() {
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    private void setupView() {
        this.getExtra(IntentIdentifier.SELECTED_SELL);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        detailSellAdapter = new DetailSellAdapter(this.sell.getProducts());
        recyclerView.setAdapter(detailSellAdapter);
    }

    private void getExtra(String identifier) {
        Intent intent = getIntent();
        this.sell = (Sell) intent.getSerializableExtra(identifier);
    }
}
