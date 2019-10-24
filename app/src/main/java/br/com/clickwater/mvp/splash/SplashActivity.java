package br.com.clickwater.mvp.splash;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import br.com.clickwater.R;
import br.com.clickwater.mvp.home.HomeActivity;
import br.com.clickwater.mvp.signin.SigninActivity;
import br.com.clickwater.utils.AppPreference;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(splashTask, 3000);
    }

    Runnable splashTask = new Runnable() {
        @Override
        public void run() {
            navigate();
        }
    };

    private void navigate() {
        if (AppPreference.getLoggedStatus(this)) {
            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
            finish();
        } else {
            AppPreference.logout(this);
            startActivity(new Intent(SplashActivity.this, SigninActivity.class));
            finish();
        }
    }
}
