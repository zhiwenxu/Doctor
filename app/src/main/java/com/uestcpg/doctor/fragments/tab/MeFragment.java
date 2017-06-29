package com.uestcpg.doctor.fragments.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.facebook.drawee.view.SimpleDraweeView;
import com.uestcpg.doctor.R;

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

}
