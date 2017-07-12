package com.uestcpg.doctor.adapters;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.okhttp.Request;
import com.uestcpg.doctor.Class.Order;
import com.uestcpg.doctor.R;
import com.uestcpg.doctor.app.AppStatus;
import com.uestcpg.doctor.network.APPUrl;
import com.uestcpg.doctor.network.OkHttpCallBack;
import com.uestcpg.doctor.network.OkHttpManager;
import com.uestcpg.doctor.utils.ParamUtil;
import com.uestcpg.doctor.utils.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by dmsoft on 2017/7/5.
 */

public class OrderListAdapter extends BaseAdapter{

    private Context mContext;
    private List<Order> orders;

    public OrderListAdapter(Context context, List<Order> orders){
        this.mContext = context;
        this.orders = orders;

    }
    //添加所有数据
    public void addDatas(List<Order> datas){
        orders.addAll(datas);
        notifyDataSetChanged();
    }
    //添加单一数据
    public void addData(Order doctor){
        orders.add(doctor);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int p = position;
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.order_list_item,null);
            viewHolder.iconImage = (SimpleDraweeView)convertView.findViewById(R.id.order_icon);
            viewHolder.acceptTv = (TextView)convertView.findViewById(R.id.order_accept);
            viewHolder.dateTimeTv = (TextView)convertView.findViewById(R.id.order_datetime);
            viewHolder.nameTv = (TextView)convertView.findViewById(R.id.order_name);
            viewHolder.tagImage = (ImageView) convertView.findViewById(R.id.order_accept_icon);
            viewHolder.acceptBtn = (TextView) convertView.findViewById(R.id.order_accept_btn);
            viewHolder.rejectBtn = (TextView) convertView.findViewById(R.id.order_reject_btn);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        Date date = null;
        try {
            date = format.parse(orders.get(position).getDateTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        final Order order = orders.get(position);

        viewHolder.iconImage.setImageURI(order.getIconUrl());
        viewHolder.nameTv.setText(order.getName());
        viewHolder.dateTimeTv.setText(f.format(date));
        String accept = order.getIsAccept();

        if(StringUtil.isEmpty(accept)){
            viewHolder.acceptTv.setText(R.string.order_wait);
            viewHolder.tagImage.setBackgroundResource(R.drawable.order_wait);
            viewHolder.acceptBtn.setVisibility(View.VISIBLE);
            viewHolder.rejectBtn.setVisibility(View.VISIBLE);
            viewHolder.tagImage.setVisibility(View.GONE);
        }else if(StringUtil.isTrue(accept)){
            viewHolder.acceptTv.setText(R.string.order_accept);
            viewHolder.tagImage.setBackgroundResource(R.drawable.order_accept);
            viewHolder.acceptBtn.setVisibility(View.GONE);
            viewHolder.rejectBtn.setVisibility(View.GONE);
            viewHolder.tagImage.setVisibility(View.VISIBLE);
        }else if(!StringUtil.isTrue(accept)){
            viewHolder.acceptTv.setText(R.string.order_reject);
            viewHolder.tagImage.setBackgroundResource(R.drawable.order_reject);
            viewHolder.acceptBtn.setVisibility(View.GONE);
            viewHolder.rejectBtn.setVisibility(View.GONE);
            viewHolder.tagImage.setVisibility(View.VISIBLE);
        }

        //点击接受
        viewHolder.acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParamUtil.put("id",order.getId());
                ParamUtil.put("token", AppStatus.getToken());
                ParamUtil.put("isAccept","true");
                ParamUtil.put("doctorPhone",AppStatus.getUserId());
                ParamUtil.put("sickPhone",order.getSickPhone());
                ParamUtil.put("doctorName",AppStatus.getUsername());
                OkHttpManager.getInstance()._postAsyn(APPUrl.DOCTOR_SET_ORDER_URL,ParamUtil.getParams(), new OkHttpCallBack() {
                    @Override
                    public void onRespone(String result) {
                        orders.get(p).setIsAccept("true");
                        notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Request request, Exception e) {

                    }
                });
            }
        });
        //点击拒绝
        viewHolder.rejectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                View view = LayoutInflater.from(mContext).inflate(R.layout.order_reject_dialog,null);
                final EditText reasonEdit = (EditText)view.findViewById(R.id.reason_edit);
                Button commitBtn = (Button)view.findViewById(R.id.commit_btn);
                Button cancelBtn = (Button)view.findViewById(R.id.cancel_btn);
                builder.setView(view);
                final AlertDialog dialog = builder.create();
                commitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ParamUtil.put("id",order.getId());
                        ParamUtil.put("token", AppStatus.getToken());
                        ParamUtil.put("isAccept","false");
                        ParamUtil.put("doctorPhone",AppStatus.getUserId());
                        ParamUtil.put("sickPhone",order.getSickPhone());
                        ParamUtil.put("doctorName",AppStatus.getUsername());
                        ParamUtil.put("reason",reasonEdit.getText().toString());
                        OkHttpManager.getInstance()._postAsyn(APPUrl.DOCTOR_SET_ORDER_URL, ParamUtil.getParams(), new OkHttpCallBack() {
                            @Override
                            public void onRespone(String result) {
                                orders.get(p).setIsAccept("false");
                                orders.get(p).setReason(reasonEdit.getText().toString());
                                notifyDataSetChanged();
                            }
                            @Override
                            public void onError(Request request, Exception e) {

                            }
                        });
                        dialog.dismiss();
                    }
                });
                cancelBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        return convertView;
    }

    class ViewHolder{
        SimpleDraweeView iconImage;
        TextView nameTv;
        TextView acceptTv;
        TextView dateTimeTv;
        ImageView tagImage;
        TextView acceptBtn;
        TextView rejectBtn;
    }
}
