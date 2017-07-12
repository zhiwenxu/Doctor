package com.uestcpg.doctor.activitys.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
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

/**
 * Created by dmsoft on 2017/6/29.
 */

public class SickInfoActivity extends BaseActivity implements View.OnClickListener{

    @InjectView(R.id.sick_icon)
    SimpleDraweeView mSimpleDraweeView;
    @InjectView(R.id.sick_name)
    TextView mSickNameTv;
    @InjectView(R.id.sick_detail)
    TextView mSickDetailTv;
    private String sickPhone;

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
        sickPhone = getIntent().getStringExtra("sickPhone");
        ParamUtil.put("token", AppStatus.getToken());
        ParamUtil.put("phone",sickPhone);
//        OkHttpManager.getInstance()._postAsyn(APPUrl);
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
    }
}
