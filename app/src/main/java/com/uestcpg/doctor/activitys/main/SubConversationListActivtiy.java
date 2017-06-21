package com.uestcpg.doctor.activitys.main;

import android.os.Bundle;

import com.uestcpg.doctor.R;
import com.uestcpg.doctor.app.BaseFragmentActivity;


/**
 * Created by dmsoft on 2017/6/14.
 */

public class SubConversationListActivtiy extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subconversationlist);
        initTitle();
        setCenterTv("我的私人会话");
    }
}
