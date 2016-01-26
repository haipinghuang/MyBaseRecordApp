package com.hai.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hai.R;
import com.hai.utils.MyLog;

/**
 * 内容区域
 * Created by 黄海 on 2016/1/22.
 */
public class ContentFragment extends Fragment {
    TextView t_content;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        t_content = (TextView) view.findViewById(R.id.t_content);
        Bundle bundle = getArguments();
        if (null!=bundle){

            bundle.getString("str");
            MyLog.d( bundle.getString("str"));
        }

    }

    public void refresh(String str) {
        t_content.setText(str);
    }

}
