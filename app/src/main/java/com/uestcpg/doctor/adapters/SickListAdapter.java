package com.uestcpg.doctor.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.uestcpg.doctor.Class.Sick;
import com.uestcpg.doctor.R;
import com.uestcpg.doctor.app.AppStatus;

import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.RongIM;


/**
 * Created by poplx on 2017/6/21.
 *
 */

public class SickListAdapter extends BaseAdapter{

    private Context mContext;
    private List<Sick> sicks;

    public SickListAdapter(Context context, List<Sick> datas) {
        this.mContext = context;
        this.sicks = datas;
    }
    //添加所有数据
    public void addDatas(List<Sick> datas){
        sicks.addAll(datas);
        notifyDataSetChanged();
    }
    //添加单一数据
    public void addData(Sick sick){
        sicks.add(sick);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return sicks.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        final Sick sick = sicks.get(i);
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.sick_list_item,null);
            holder = new ViewHolder();
            holder.iconImage = (SimpleDraweeView)convertView.findViewById(R.id.sick_icon);
            holder.nameTv = (TextView)convertView.findViewById(R.id.sick_name);
            holder.detailTv = (TextView)convertView.findViewById(R.id.sick_detail);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.iconImage.setImageURI(sick.getIconurl());
        holder.nameTv.setText(sick.getName());
        holder.detailTv.setText(sick.getDescription());
        return convertView;
    }
    private class ViewHolder{
        SimpleDraweeView iconImage;
        TextView nameTv;
        TextView detailTv;
    }
}
