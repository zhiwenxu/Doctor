package com.uestcpg.doctor.activitys.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.uestcpg.doctor.R;
import com.uestcpg.doctor.app.BaseActivity;
import com.uestcpg.doctor.network.APPUrl;
import com.uestcpg.doctor.network.OkHttpManager;

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
//        OkHttpManager.getInstance()._postAsyn(APPUrl);
    }

    @Override
    public void onClick(View v) {
        if(v == mLeftIm){
            finish();
        }
    }
}
