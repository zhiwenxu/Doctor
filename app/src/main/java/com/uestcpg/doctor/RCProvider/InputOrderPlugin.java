package com.uestcpg.doctor.RCProvider;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;


import com.uestcpg.doctor.Bluetooth.BlueMainActivity;
import com.uestcpg.doctor.R;

import io.rong.imkit.RongExtension;
import io.rong.imkit.plugin.IPluginModule;

/**
 * Created by dmsoft on 2017/6/30.
 */

public class InputOrderPlugin implements IPluginModule {
    private Context context;
    @Override
    public Drawable obtainDrawable(Context context) {
        this.context = context;
        return ContextCompat.getDrawable(context, R.drawable.input_order_bg);
    }

    @Override
    public String obtainTitle(Context context) {
        return "脉搏治疗";
    }

    @Override
    public void onClick(Fragment fragment, RongExtension rongExtension) {
        context.startActivity(new Intent(context,BlueMainActivity.class));
    }

    @Override
    public void onActivityResult(int i, int i1, Intent intent) {

    }
}
