package com.uestcpg.doctor.fragments.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.facebook.drawee.view.SimpleDraweeView;
import com.uestcpg.doctor.R;
import com.uestcpg.doctor.app.AppStatus;
import com.uestcpg.doctor.network.APPUrl;
import com.uestcpg.doctor.network.OkHttpCallBack;
import com.uestcpg.doctor.network.OkHttpManager;
import com.uestcpg.doctor.utils.ParamUtil;
import com.uestcpg.doctor.utils.StringUtil;
import com.uestcpg.doctor.utils.T;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dmsoft on 2017/6/14.
 *
 */

public class MeFragment extends Fragment {

//    @InjectView(R.id.me_icon)
//    SimpleDraweeView mSimpleDraweeView;

    public static MeFragment getInstance(){
        return new MeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_me,null);
//        ButterKnife.inject(this,contentView);
        init();
        return contentView;
    }
    private void init(){
//        mSimpleDraweeView.setImageURI("");
    }

    private void GetDoctorInfo(){
        String token = AppStatus.getToken();
        String phone = AppStatus.getUserId();
        if(StringUtil.isEmpty(token)){
            T.show(this,getString(R.string.account_null_tip));
            return;
        }
        if(StringUtil.isEmpty(phone)){
            T.show(this,getString(R.string.phone_null_tip));
            return;
        }
        ParamUtil.put("token",token);
        ParamUtil.put("phone",phone);
        OkHttpManager.getInstance()._postAsyn(APPUrl.DOCTORINFO_URL, ParamUtil.getParams(), new OkHttpCallBack() {
            @Override
            public void onRespone(String result) {

                }
                else{

                }
                connect(bean.getRCToken());
            }
            @Override
            public void onError(Request request, Exception e) {

            }
        });
    }

}
