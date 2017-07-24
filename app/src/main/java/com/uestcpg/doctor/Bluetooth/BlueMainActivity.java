package com.uestcpg.doctor.Bluetooth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.uestcpg.doctor.R;
import com.uestcpg.doctor.activitys.main.TreatmentActivity;
import com.uestcpg.doctor.app.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by poplx on 2017/7/20.
 */

public class BlueMainActivity extends BaseActivity implements View.OnClickListener{
    @InjectView(R.id.treatment_btn)
    Button TreatmentBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        ButterKnife.inject(this);
        TreatmentBtn.setOnClickListener(this);
    }


    private void end(){
        Intent intent = new Intent(BlueMainActivity.this, TreatmentActivity.class);
        startActivity(intent);
    }
    @Override
    public void onClick(View v) {
        if(v == TreatmentBtn){
            end();
        }
    }
}
