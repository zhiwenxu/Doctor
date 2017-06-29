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


import com.uestcpg.doctor.Class.Sick;
import com.uestcpg.doctor.R;
import com.uestcpg.doctor.activitys.main.SickInfoActivity;
import com.uestcpg.doctor.adapters.SickListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dmsoft on 2017/6/14.
 *
 */

public class FriendsListFragment extends Fragment implements View.OnClickListener,AdapterView.OnItemClickListener{

    @InjectView(R.id.sick_list)
    ListView mSickList;

    private SickListAdapter mSickAdapter;
    private List<Sick> sicks = new ArrayList<>();
    public static FriendsListFragment getInstance(){
        return new FriendsListFragment();
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
        Sick sick1 = new Sick();
        sick1.setName("刘雯");
        sick1.setDetail("近视一期有待观察患者");
        Sick sick2 = new Sick();
        sick2.setName("张将");
        sick2.setDetail("胃炎一期有待观察患者");
        sicks.add(sick1);
        sicks.add(sick2);
        mSickAdapter = new SickListAdapter(getActivity(),sicks);
        mSickList.setAdapter(mSickAdapter);
        mSickList.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
//            RongIM.getInstance().startPrivateChat(getActivity(),AppStatus.getTagetId(),AppStatus.getUsername());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), SickInfoActivity.class);
        startActivity(intent);
    }
}
