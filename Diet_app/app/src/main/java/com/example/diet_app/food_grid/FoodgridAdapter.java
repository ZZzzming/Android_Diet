package com.example.diet_app.food_grid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diet_app.R;
import com.example.diet_app.bean.FoodBean;

import java.util.List;

public class FoodgridAdapter extends BaseAdapter {
    Context context;
    List<FoodBean> mData;
    public FoodgridAdapter(Context context,List<FoodBean> mData){
        this.context = context;
        this.mData = mData;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_foodgrid,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }
        FoodBean foodBean = mData.get(position);
        holder.iv.setImageResource(foodBean.getPicId());
        holder.tv.setText(foodBean.getTitle());
        return convertView;
    }
    class  ViewHolder{
        ImageView iv;
        TextView tv;
        public  ViewHolder(View view){
            iv = view.findViewById(R.id.item_grid_iv);
            tv = view.findViewById(R.id.item_grid_tv);
        }
    }
}
