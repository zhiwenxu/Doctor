package com.uestcpg.doctor.activitys.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.uestcpg.doctor.R;
import com.uestcpg.doctor.app.AppStatus;
import com.uestcpg.doctor.app.BaseFragmentActivity;

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
        setCenterTv(AppStatus.getTagetId());
    }
}
