package com.uestcpg.doctor.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.uestcpg.doctor.Class.Sick;
import com.uestcpg.doctor.R;

import java.util.List;

/**
 * Created by dmsoft on 2017/7/12.
 * recycleView的适配器
 */

public class SickListAdapter extends RecyclerView.Adapter<SickListAdapter.ViewHolder> {

    private Context context;
    private List<Sick> sicks;
    private OnRecycleViewItemListener mListener;

    public SickListAdapter(Context context, List<Sick> sicks){
        this.context = context;
        this.sicks = sicks;
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

    public void clear(){
        sicks.clear();
    }
    //设置点击事件
    public void setOnItemClickListener(OnRecycleViewItemListener mListener){
        this.mListener = mListener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.sick_list_item,null));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Sick sick = sicks.get(position);
        holder.iconImage.setImageURI(sick.getIconurl());
        holder.nameTv.setText(sick.getName());
        holder.detailTv.setText(sick.getDescription());
        holder.mCardViewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null){
                    mListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return sicks.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout mCardViewLayout;
        SimpleDraweeView iconImage;
        TextView nameTv;
        TextView detailTv;

        public ViewHolder(View convertView) {
            super(convertView);
            mCardViewLayout = (RelativeLayout)convertView.findViewById(R.id.card_view_layout);
            iconImage = (SimpleDraweeView)convertView.findViewById(R.id.sick_icon);
            nameTv = (TextView)convertView.findViewById(R.id.sick_name);
            detailTv = (TextView)convertView.findViewById(R.id.sick_detail);
        }
    }
}
