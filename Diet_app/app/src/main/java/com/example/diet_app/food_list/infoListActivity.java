package com.example.diet_app.food_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.diet_app.R;
import com.example.diet_app.bean.FoodBean;
import com.example.diet_app.bean.FoodUtils;
import com.example.diet_app.food_grid.FooddescActivity;
import com.example.diet_app.home.infolistAdapter;

import java.util.ArrayList;
import java.util.List;

public class infoListActivity extends AppCompatActivity implements View.OnClickListener{  //信息界面
    EditText searchEt;
    ImageView searchIv,flushIv;
    ListView showLv;
    List<FoodBean> mDatas;
    List<FoodBean> allFood;
    private infolistAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list);
        initView();
        mDatas = new ArrayList<>();
        allFood = FoodUtils.getAllFoodList();
        mDatas.addAll(allFood);
        adapter = new infolistAdapter(this, mDatas);
        showLv.setAdapter(adapter);
        setListener();
    }

    private void setListener() {
        showLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FoodBean foodBean = mDatas.get(position);
                Intent intent = new Intent(infoListActivity.this, FooddescActivity.class);
                intent.putExtra("food",foodBean);
                startActivity(intent);
            }
        });
    }

    private void initView(){
        searchEt = findViewById(R.id.info_et_search);
        searchIv = findViewById(R.id.info_iv_search);
        flushIv = findViewById(R.id.info_iv_flush);
        showLv = findViewById(R.id.infolist);
        searchIv.setOnClickListener(this);
        flushIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.info_iv_flush:
                searchEt.setText("");
                mDatas.clear();
                mDatas.addAll(allFood);
                adapter.notifyDataSetChanged();
                break;
            case R.id.info_iv_search:
                String msg = searchEt.getText().toString().trim();
                if(TextUtils.isEmpty(msg)){
                    Toast.makeText(this,"输入内容为空...",Toast.LENGTH_SHORT).show();
                    return;
                }
                List<FoodBean>list = new ArrayList<>();
                for(int i = 0;i < allFood.size();i++){
                    String title = allFood.get(i).getTitle();
                    if (title.contains(msg)) {
                        list.add(allFood.get(i));
                    }
                }
                mDatas.clear();
                mDatas.addAll(list);
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
