package com.uestcpg.doctor.fragments.tab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.squareup.okhttp.Request;
import com.uestcpg.doctor.Class.Sick;
import com.uestcpg.doctor.R;
import com.uestcpg.doctor.activitys.main.SickInfoActivity;
import com.uestcpg.doctor.adapters.SickListAdapter;
import com.uestcpg.doctor.app.AppStatus;
import com.uestcpg.doctor.beans.GetSickListBean;
import com.uestcpg.doctor.network.APPUrl;
import com.uestcpg.doctor.network.GsonHelper;
import com.uestcpg.doctor.network.OkHttpCallBack;
import com.uestcpg.doctor.network.OkHttpManager;
import com.uestcpg.doctor.network.SPUtil;
import com.uestcpg.doctor.utils.ParamUtil;
import com.uestcpg.doctor.utils.StringUtil;
import com.uestcpg.doctor.utils.T;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dmsoft on 2017/6/14.
 *
 */

public class SickListFragment extends Fragment implements View.OnClickListener,AdapterView.OnItemClickListener{

    @InjectView(R.id.sick_list)
    ListView mSickList;

    private SickListAdapter mSickAdapter;
    private List<Sick> sicks = new ArrayList<>();
    public static SickListFragment getInstance(){
        return new SickListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_friends,null);
        ButterKnife.inject(this,contentView);
        init();
        return contentView;
    }
    private void init(){
        mSickAdapter = new SickListAdapter(getActivity(),sicks);
        mSickList.setAdapter(mSickAdapter);
        mSickList.setOnItemClickListener(this);
        ParamUtil.put("token",AppStatus.getToken());
        ParamUtil.put("phone", SPUtil.getUsername(getActivity()));
        OkHttpManager.getInstance()._postAsyn(APPUrl.GET_SICK_LIST_URL,ParamUtil.getParams(), new OkHttpCallBack() {
            @Override
            public void onRespone(String result) {
                GetSickListBean bean = GsonHelper.getGson().fromJson(result,GetSickListBean.class);
                if(StringUtil.isTrue(bean.getSuccess())){
                    mSickAdapter.addDatas(bean.getSicks());
                }else{
                    T.show(getActivity(),bean.getMessage());
                }
            }

            @Override
            public void onError(Request request, Exception e) {

            }
        });
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), SickInfoActivity.class);
        intent.putExtra("sickPhone",sicks.get(position).getPhone());
        startActivity(intent);
    }
}
