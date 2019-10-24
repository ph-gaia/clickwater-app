package br.com.clickwater.mvp;

import android.os.Bundle;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.com.clickwater.R;
import br.com.clickwater.adapter.FoodOrderAdapter;
import br.com.clickwater.data.model.Food;


public class FoodOrderListActivity extends AppCompatActivity {

    private ArrayList<Food> foodOrderListModelClasses;
    private RecyclerView recyclerView;
    private FoodOrderAdapter bAdapter;

    private String txt[] = {"1.Splash Screen", "2.HomeActivity", "3.BookOrderActivity", "4.RestaurantFilterActivity", "5.FoodFilterActivity", "6.ReviewActivity", "7.LocationActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_order_list);

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FoodOrderListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        foodOrderListModelClasses = new ArrayList<>();

        for (int i = 0; i < txt.length; i++) {
            Food beanClassForRecyclerView_contacts = new Food(txt[i]);
            foodOrderListModelClasses.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new FoodOrderAdapter(FoodOrderListActivity.this, foodOrderListModelClasses);
        recyclerView.setAdapter(bAdapter);
    }
}
