package com.uestcpg.doctor.activitys.start;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.squareup.okhttp.Request;
import com.uestcpg.doctor.R;
import com.uestcpg.doctor.app.BaseActivity;
import com.uestcpg.doctor.beans.RegisterBean;
import com.uestcpg.doctor.network.APPUrl;
import com.uestcpg.doctor.network.GsonHelper;
import com.uestcpg.doctor.network.OkHttpCallBack;
import com.uestcpg.doctor.network.OkHttpManager;
import com.uestcpg.doctor.utils.MD5Util;
import com.uestcpg.doctor.utils.ParamUtil;
import com.uestcpg.doctor.utils.StringUtil;
import com.uestcpg.doctor.utils.T;


import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by POPLX on 2017/6/18.
 *
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener{


    @InjectView(R.id.register_btn)
    Button rRegisterBtn;
    @InjectView(R.id.register_name)
    EditText rNameEdit;
    @InjectView(R.id.register_password)
    EditText rPasswordEdit;
    @InjectView(R.id.register_phone)
    EditText rPhoneEdit;
    @InjectView(R.id.register_appelation)
    EditText rAppelationEdit;
    @InjectView(R.id.register_major)
    EditText rMajorEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }
    private void init(){
        ButterKnife.inject(this);
        rRegisterBtn.setOnClickListener(this);
    }

    private void Register(){

        String pwd = rPasswordEdit.getText().toString();
        String phone = rPhoneEdit.getText().toString();
        String name = rNameEdit.getText().toString();
        String appelation = rAppelationEdit.getText().toString();
        String major = rMajorEdit.getText().toString();

        if(StringUtil.isEmpty(phone)){
            T.show(this,getString(R.string.account_null_tip));
            return;
        }
        if(StringUtil.isEmpty(pwd)){
            T.show(this,getString(R.string.pwd_null_tip));
            return;
        }
        if(StringUtil.isEmpty(name)){
            T.show(this,getString(R.string.name_null_tip));
            return;
        }
        if(StringUtil.isEmpty(appelation)){
            T.show(this,getString(R.string.appelation_null_tip));
            return;
        }
        if(StringUtil.isEmpty(major)){
            T.show(this,getString(R.string.major_null_tip));
            return;
        }
        String pwdMD5 = MD5Util.stringMD5(pwd);
        ParamUtil.put("phone",phone);
        ParamUtil.put("password",pwdMD5);
        ParamUtil.put("name",name);
        ParamUtil.put("doctor","true");

        OkHttpManager.getInstance()._postAsyn(APPUrl.REGISTER_URL,ParamUtil.getParams()
                , new OkHttpCallBack() {
            @Override
            public void onRespone(String result) {
                RegisterBean bean = GsonHelper.getGson().fromJson(result,RegisterBean.class);
                T.show(RegisterActivity.this,bean.getMessage());
                finish();
            }
            @Override
            public void onError(Request request, Exception e) {
                e.printStackTrace();
            }
        });

    }
    @Override
    public void onClick(View v) {
        if(v == rRegisterBtn){
            Register();
        }
    }
}
