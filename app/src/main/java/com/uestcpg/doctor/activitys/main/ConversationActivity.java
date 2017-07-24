package com.uestcpg.doctor.activitys.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.squareup.okhttp.Request;
import com.uestcpg.doctor.R;
import com.uestcpg.doctor.app.AppStatus;
import com.uestcpg.doctor.app.BaseFragmentActivity;
import com.uestcpg.doctor.beans.SickInfoBean;
import com.uestcpg.doctor.network.APPUrl;
import com.uestcpg.doctor.network.GsonHelper;
import com.uestcpg.doctor.network.OkHttpCallBack;
import com.uestcpg.doctor.network.OkHttpManager;
import com.uestcpg.doctor.utils.ParamUtil;
import com.uestcpg.doctor.utils.StringUtil;

/**
 * Created by dmsoft on 2017/6/14.
 */

public class ConversationActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        initViews();
    }
    private void initViews(){
        initTitle();
        String phone = getIntent().getData().getQueryParameter("targetId");
        AppStatus.setTargetId(phone);
        ParamUtil.put("phone",phone);
        OkHttpManager.getInstance()._postAsyn(APPUrl.SICK_INFO_URL, ParamUtil.getParams(), new OkHttpCallBack() {
            @Override
            public void onRespone(String result) {
                SickInfoBean bean = GsonHelper.getGson().fromJson(result,SickInfoBean.class);
                if(StringUtil.isTrue(bean.getSuccess())){
                    setCenterTv(bean.getName());
                }
            }

            @Override
            public void onError(Request request, Exception e) {

            }
        });
    }
}
