package com.example.diet_app.food_grid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.diet_app.R;
import com.example.diet_app.bean.FoodBean;
import com.example.diet_app.bean.FoodUtils;
import com.example.diet_app.food_list.infoListActivity;

import java.util.List;

public class FoodGridActivity extends AppCompatActivity {
    GridView gv;
    List<FoodBean> mDatas;
    private FoodgridAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_grid);
        gv = (GridView)findViewById(R.id.food_grid_gv);
        mDatas = FoodUtils.getAllFoodList();
        adapter = new FoodgridAdapter(this,mDatas);
        gv.setAdapter(adapter);
        setListener();
    }

    private void setListener() {
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FoodBean foodBean = mDatas.get(position);
                Intent intent = new Intent(FoodGridActivity.this, FooddescActivity.class);
                intent.putExtra("food",foodBean);
                startActivity(intent);
            }
        });
    }
}
