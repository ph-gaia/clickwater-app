package br.com.clickwater.mvp.confirmOrders;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import br.com.clickwater.R;

public class ConfirmOrdersActivity extends AppCompatActivity implements ConfirmOrdersMVP.View {

    private static ConfirmOrdersMVP.Presenter presenter;
    private RecyclerView rclViewItems, rclViewAddress, rclViewSchedule;
    private CoordinatorLayout coordinatorLayout;
    Toolbar actionbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        presenter = new ConfirmOrdersPresenter();
        presenter.setView(this);
        bindView();
    }

    private void bindView() {
        actionbar = findViewById(R.id.toolbar);
        coordinatorLayout = findViewById(R.id.layoutConfirmOrders);
        rclViewItems = findViewById(R.id.rcviewItems);
        rclViewAddress = findViewById(R.id.rcviewAddress);
        rclViewSchedule = findViewById(R.id.rcviewSchedule);

        if (null != actionbar) {
            setSupportActionBar(actionbar);
            actionbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
            actionbar.setTitle(R.string.label_confirm);
            actionbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    @Override
    public void showSnackbar(String mensagem) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, mensagem, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }
}
