package com.example.diet_app.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.diet_app.R;
import com.example.diet_app.about.AboutActivity;
import com.example.diet_app.food_grid.FoodGridActivity;
import com.example.diet_app.food_list.infoListActivity;

public class MainActivity extends AppCompatActivity {
    Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void inClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.main_btn1:
                intent.setClass(MainActivity.this, HomeMenuActivity.class);
                break;
            case R.id.main_btn2:
                intent.setClass(MainActivity.this, HomeMenuActivity.class);
                break;
        }
        startActivity(intent);
    }
}
