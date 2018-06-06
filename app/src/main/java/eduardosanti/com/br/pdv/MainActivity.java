package eduardosanti.com.br.pdv;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import eduardosanti.com.br.pdv.model.User;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;

    private ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.bindView();
        this.setUpUsers();

        this.emailEditText.setText("admin@gmail.com");
        this.passwordEditText.setText("admin");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        this.clearFields();
        this.emailEditText.requestFocus();
    }

    private void bindView() {
        this.emailEditText = (EditText) findViewById(R.id.emailEditTextId);
        this.passwordEditText = (EditText) findViewById(R.id.passwordEditTextId);
    }

    private void setUpUsers() {
        if (this.users != null) {
            this.users.add(new User("admin@gmail.com", "admin"));
        }
    }

    public void loginPressed(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (!email.isEmpty() && !password.isEmpty()) {
            User user = new User(email, password);

            this.tryLogin(user);
        } else {
            this.displayToast("Preencha todos os campos");
        }
    }

    private void tryLogin(User user) {
        if (this.users.contains(user)) {
            this.goToSellsActivity(user);
        } else {
            this.displayToast("Usuário não encontrado");
        }

        this.dismissKeyboard();
    }

    private void goToSellsActivity(User user) {
        Intent intent = new Intent(this, SellsActivity.class);
        intent.putExtra("LoggedUser", user);

        startActivity(intent);
    }


    private void clearFields() {
        this.emailEditText.setText("");
        this.passwordEditText.setText("");
    }

    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void dismissKeyboard() {
        View view = this.getCurrentFocus();

        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
