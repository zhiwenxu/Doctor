package com.uestcpg.doctor.fragments.tab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.okhttp.Request;
import com.uestcpg.doctor.R;
import com.uestcpg.doctor.activitys.main.OrderActivity;
import com.uestcpg.doctor.activitys.main.SickRecordActivity;
import com.uestcpg.doctor.app.AppStatus;
import com.uestcpg.doctor.beans.DoctorInfoBean;
import com.uestcpg.doctor.network.APPUrl;
import com.uestcpg.doctor.network.GsonHelper;
import com.uestcpg.doctor.network.OkHttpCallBack;
import com.uestcpg.doctor.network.OkHttpManager;
import com.uestcpg.doctor.utils.ParamUtil;
import com.uestcpg.doctor.utils.StringUtil;
import com.uestcpg.doctor.utils.T;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dmsoft on 2017/6/14.
 *
 */

public class MeFragment extends Fragment implements View.OnClickListener{

    @InjectView(R.id.me_icon)
    SimpleDraweeView mSimpleDraweeView;
    @InjectView(R.id.me_name)
    TextView me_Name;
    @InjectView(R.id.me_appellation)
    TextView me_Appellation;
    @InjectView(R.id.me_major)
    TextView me_Major;
    @InjectView(R.id.doctor_info_layout)
    RelativeLayout mDoctorInfoLayout;
    @InjectView(R.id.order_layout)
    RelativeLayout mOrderLayout;
    @InjectView(R.id.my_sick_record_layout)
    RelativeLayout mSickRecordLayout;

    public static MeFragment getInstance(){
        return new MeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_me,null);
        ButterKnife.inject(this,contentView);
        init();
        return contentView;
    }


    @Override
    public void onStart() {
        super.onStart();
        GetDoctorInfo();
    }

    private void GetDoctorInfo(){
        String token = AppStatus.getToken();
        String phone = AppStatus.getUserId();
        if(StringUtil.isEmpty(token)){
            T.show(getActivity(),getString(R.string.account_null_tip));
            return;
        }
        if(StringUtil.isEmpty(phone)){
            T.show(getActivity(),getString(R.string.phone_null_tip));
            return;
        }
        ParamUtil.put("token",token);
        ParamUtil.put("phone",phone);
        OkHttpManager.getInstance()._postAsyn(APPUrl.DOCTORINFO_URL, ParamUtil.getParams(), new OkHttpCallBack() {
            @Override
            public void onRespone(String result) {
                DoctorInfoBean bean = GsonHelper.getGson().fromJson(result,DoctorInfoBean.class);

                if(StringUtil.isTrue(bean.getSuccess())){
                    bean.getIconUrl();
                    AppStatus.setUsername(bean.getName());
                    mSimpleDraweeView.setImageURI(bean.getIconUrl());
                    me_Name.setText(bean.getName());
                    me_Major.setText(bean.getMajor());
                    me_Appellation.setText(bean.getAppellation());
                }
                else{
                    T.show(getActivity(),bean.getMessage());
                }

            }
            @Override
            public void onError(Request request, Exception e) {

            }
        });
    }

    private void init(){
        mSickRecordLayout.setOnClickListener(this);
        mDoctorInfoLayout.setOnClickListener(this);
        mOrderLayout.setOnClickListener(this);
    }

    private void ChangeInfomation(){
        Intent intent = new Intent(getActivity(), MeFragmentChange.class);
        intent.putExtra("name",me_Name.getText().toString());
        intent.putExtra("appellation",me_Appellation.getText().toString());
        intent.putExtra("major",me_Major.getText().toString());
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if(v == mDoctorInfoLayout){
            ChangeInfomation();
        }
        if(v == mOrderLayout){
            Intent intent = new Intent(getActivity(), OrderActivity.class);
            startActivity(intent);
        }
        if(v == mSickRecordLayout){
            Intent intent = new Intent(getActivity(), SickRecordActivity.class);
            startActivity(intent);
        }
    }

}
