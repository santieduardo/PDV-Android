package eduardosanti.com.br.pdv;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import eduardosanti.com.br.pdv.model.User;

public class SellsActivity extends AppCompatActivity {

    private User user;

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
    }

    public void fabOnClick(View view) {

    }

    private void showSnackbar(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }

}
