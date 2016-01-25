package com.hai.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hai.R;

import java.util.Arrays;
import java.util.List;

/**
 * 左侧滑菜单
 * Created by 黄海 on 2016/1/22.
 */
public class MenuLeft extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_left, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView listView = (ListView) view.findViewById(R.id.listView);
        String[] strings = getResources().getStringArray(R.array.menu);
        List list = Arrays.asList(strings);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.item_menu, R.id.tv, strings);
        listView.setAdapter(adapter);
        super.onViewCreated(view, savedInstanceState);
    }
}
