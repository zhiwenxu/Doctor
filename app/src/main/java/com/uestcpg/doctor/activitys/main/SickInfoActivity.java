package com.uestcpg.doctor.activitys.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.okhttp.Request;
import com.uestcpg.doctor.R;
import com.uestcpg.doctor.app.AppStatus;
import com.uestcpg.doctor.app.BaseActivity;
import com.uestcpg.doctor.beans.SickInfoBean;
import com.uestcpg.doctor.network.APPUrl;
import com.uestcpg.doctor.network.GsonHelper;
import com.uestcpg.doctor.network.OkHttpCallBack;
import com.uestcpg.doctor.network.OkHttpManager;
import com.uestcpg.doctor.utils.ParamUtil;
import com.uestcpg.doctor.utils.StringUtil;
import com.uestcpg.doctor.utils.T;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.rong.imkit.RongIM;

/**
 * Created by dmsoft on 2017/6/29.
 *
 */

public class SickInfoActivity extends BaseActivity implements View.OnClickListener{

    @InjectView(R.id.sick_icon)
    SimpleDraweeView mSimpleDraweeView;
    @InjectView(R.id.sick_name)
    TextView mSickNameTv;
    @InjectView(R.id.sick_detail)
    TextView mSickDetailTv;
    private String sickPhone;
    @InjectView(R.id.sick_record_layout)
    RelativeLayout mSickRecordLayout;
    @InjectView(R.id.doctor_send_btn)
    Button mDoctorSendBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sick_info);
        ButterKnife.inject(this);
        initTitle();
        init();
    }

    private void init(){
        setLeftIm(R.drawable.left_arrow);
        setCenterTv("病人资料");
        mLeftIm.setOnClickListener(this);
        mSickRecordLayout.setOnClickListener(this);
        mDoctorSendBtn.setOnClickListener(this);
        sickPhone = getIntent().getStringExtra("sickPhone");
        ParamUtil.put("token", AppStatus.getToken());
        ParamUtil.put("phone",sickPhone);
        OkHttpManager.getInstance()._postAsyn(APPUrl.SICK_INFO_URL, ParamUtil.getParams(), new OkHttpCallBack() {
            @Override
            public void onRespone(String result) {
                SickInfoBean bean = GsonHelper.getGson().fromJson(result,SickInfoBean.class);

                if(StringUtil.isTrue(bean.getSuccess())){
                    mSickNameTv.setText(bean.getName());
                    mSickDetailTv.setText(bean.getDesception());
                    mSimpleDraweeView.setImageURI(bean.getIconUrl());
                }
                else{
                    T.show(SickInfoActivity.this,bean.getMessage());
                }
            }

            @Override
            public void onError(Request request, Exception e) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == mLeftIm){
            finish();
        }
        if(v == mSickRecordLayout){
            Intent intent = new Intent(SickInfoActivity.this, SickRecordActivity.class);
            startActivity(intent);
        }
        if(v == mDoctorSendBtn){
            RongIM.getInstance().startPrivateChat(this,sickPhone,"病人");
        }
    }
}
