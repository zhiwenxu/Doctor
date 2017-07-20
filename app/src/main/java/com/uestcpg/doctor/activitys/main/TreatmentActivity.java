package com.uestcpg.doctor.activitys.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.squareup.okhttp.Request;
import com.uestcpg.doctor.R;
import com.uestcpg.doctor.activitys.start.RegisterActivity;
import com.uestcpg.doctor.app.AppStatus;
import com.uestcpg.doctor.app.BaseActivity;
import com.uestcpg.doctor.beans.RegisterBean;
import com.uestcpg.doctor.network.APPUrl;
import com.uestcpg.doctor.network.GsonHelper;
import com.uestcpg.doctor.network.OkHttpCallBack;
import com.uestcpg.doctor.network.OkHttpManager;
import com.uestcpg.doctor.network.SPUtil;
import com.uestcpg.doctor.utils.MD5Util;
import com.uestcpg.doctor.utils.ParamUtil;
import com.uestcpg.doctor.utils.StringUtil;
import com.uestcpg.doctor.utils.T;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by poplx on 2017/7/19.
 */

public class TreatmentActivity extends BaseActivity implements View.OnClickListener {
    @InjectView(R.id.treatment_btn)
    Button Treatment_Btn;
    @InjectView(R.id.treatment)
    EditText Treatment;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment);
        init();
    }
    private void init(){
        ButterKnife.inject(this);
        Treatment_Btn.setOnClickListener(this);
    }

    private void Treatment(){

        final String treatment = Treatment.getText().toString();


        if(StringUtil.isEmpty(treatment)){
            T.show(this,getString(R.string.account_null_tip));
            return;
        }

        ParamUtil.put("doctor","true");
        ParamUtil.put("id",AppStatus.getUserId());
        ParamUtil.put("token", AppStatus.getToken());
        ParamUtil.put("isAccept","true");
        ParamUtil.put("doctorPhone",AppStatus.getUserId());
        ParamUtil.put("sickPhone","15108307486");
        ParamUtil.put("doctorName",AppStatus.getUsername());
        OkHttpManager.getInstance()._postAsyn(APPUrl.DOCTOR_SET_ORDER_URL,ParamUtil.getParams(), new OkHttpCallBack() {
            @Override
            public void onRespone(String result) {
                T.show(TreatmentActivity.this,"true");
                finish();
            }

            @Override
            public void onError(Request request, Exception e) {

            }
        });

    }
    @Override
    public void onClick(View v) {
        if(v == Treatment_Btn){
            Treatment();
        }
    }
}
