package com.example.diet_app.about;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.diet_app.R;

import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{
    ViewPager aboutVp;
    TextView shareTv;
    LinearLayout pointLayout;
    List<View>viewList;
    int[]picIds = {R.mipmap.ab1,R.mipmap.ab2,R.mipmap.ab3,R.mipmap.ab4,R.mipmap.ab5};
    private AboutAdapter adapter;
    List<ImageView>pointList;
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                int currentItem = aboutVp.getCurrentItem();
                aboutVp.setCurrentItem(currentItem+1);
                handler.sendEmptyMessageDelayed(1,5000);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        aboutVp = findViewById(R.id.about_vp);
        shareTv = findViewById(R.id.about_tv_share);
        pointLayout = findViewById(R.id.about_layout_point);
        shareTv.setOnClickListener(this);
        viewList = new ArrayList<>();
        pointList = new ArrayList<>();
        for (int i = 0; i < picIds.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_aboutvp,null);
            ImageView iv = view.findViewById(R.id.item_aboutvp_iv);
            iv.setImageResource(picIds[i]);
            viewList.add(view);
            ImageView pointIv = new ImageView(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0,0,20,0);
            pointIv.setLayoutParams(lp);
            pointIv.setImageResource(R.mipmap.a2);
            pointList.add(pointIv);
            pointLayout.addView(pointIv);
        }
        pointList.get(0).setImageResource(R.mipmap.a3);
        adapter = new AboutAdapter(viewList);
        aboutVp.setAdapter(adapter);
        handler.sendEmptyMessageDelayed(1,5000);
        setVPListener();
    }

    private void setVPListener() {
        aboutVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < pointList.size(); i++) {
                    pointList.get(i).setImageResource(R.mipmap.a2);
                }
                pointList.get(position%pointList.size()).setImageResource(R.mipmap.a3);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String msg= "欢迎使用饮食搭配APP！！！下载地址hhtp://www.baidu.com";
        intent.putExtra(Intent.EXTRA_TEXT,msg);
        startActivity(Intent.createChooser(intent,"分享"));
    }
}
