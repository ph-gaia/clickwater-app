package br.com.clickwater.mvp.signin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import br.com.clickwater.R;
import br.com.clickwater.mvp.home.HomeActivity;

public class SigninActivity extends AppCompatActivity implements SigninMVP.View {

    private static SigninMVP.Presenter presenter;
    private CoordinatorLayout coordinatorLayout;
    TextInputLayout textInputEmail, textInputPassword;
    EditText editLoginEmail, editLoginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new SigninPresenter();
        presenter.setView( this );
        bindView();
    }

    private void bindView() {
        coordinatorLayout = findViewById(R.id.layoutLogin);
        textInputEmail = findViewById(R.id.text_login_email);
        editLoginEmail = findViewById(R.id.edit_login_email);
        textInputPassword = findViewById(R.id.text_password);
        editLoginPassword = findViewById(R.id.edit_password);
    }

    @Override
    public void showSnackbar(String mensagem) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, mensagem, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public void showTextError( String mensagem ) {
        textInputEmail.setError(mensagem);
    }

    @Override
    public void startIntent() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override
    public void showProgressBar(int visibilidade) {
        findViewById(R.id.progressBar).setVisibility( visibilidade );
    }

    @Override
    public void showButtonLogin(int visibilidade) {
        findViewById(R.id.btnLogin).setVisibility( visibilidade );
    }

    public void requestLogin(View view) {
        presenter.singupLogin(editLoginEmail.getText().toString().trim(), editLoginPassword.getText().toString().trim());
    }

}
