package br.com.clickwater.mvp.signup;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.snackbar.Snackbar;

import br.com.clickwater.R;
import br.com.clickwater.data.model.RequestUser;

public class SignupActivity extends AppCompatActivity implements SignupMVP.View {

    private static SignupMVP.Presenter presenter;
    private EditText et_name, et_phone, et_email, et_username, et_password;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Toolbar actionbar = findViewById(R.id.toolbar);
        if (null != actionbar) {
            actionbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

            actionbar.setTitle(R.string.sign_up);
            actionbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

        presenter = new SignupPresenter();
        presenter.setView(this);
        bindView();
    }

    private void bindView() {
        coordinatorLayout = findViewById(R.id.layoutSignup);
        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
    }

    @Override
    public void showSnackbar(String mensagem) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, mensagem, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    public void requestSignup(View view) {
        RequestUser user = new RequestUser();
        user.setName(et_name.getText().toString().trim());
        user.setPhone(et_phone.getText().toString().trim());
        user.setEmail(et_email.getText().toString().trim());
        user.setUsername(et_username.getText().toString().trim());
        user.setPassword(et_password.getText().toString().trim());

        presenter.requestCreateUsers(user);
    }

    public void callLoginActivity(View view) {
        finish();
    }
}
