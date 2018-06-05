package eduardosanti.com.br.pdv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import eduardosanti.com.br.pdv.model.User;

public class SellsActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sells);

        this.setupView();
    }

    private void setupView() {
        Intent intent = getIntent();
        this.user = (User) intent.getSerializableExtra("LoggedUser");
    }
}
