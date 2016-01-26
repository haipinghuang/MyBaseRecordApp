package com.hai.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                String str = tv.getText().toString();
                Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
                ContentFragment fragment = (ContentFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.f_content);
                Bundle bundle = new Bundle();
                bundle.putString("str", str);
//                fragment.setArguments(bundle);
                fragment.refresh(str);
                mMenuItemSelectedListener.menuItemSelected(str);
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    //选择回调的接口
    public interface OnMenuItemSelectedListener {
        void menuItemSelected(String title);
    }

    /**
     * 设置回调接口，和管理他的activity交互
     *
     * @param menuItemSelectedListener
     */
    public void setOnMenuItemSelectedListener(OnMenuItemSelectedListener menuItemSelectedListener) {
        this.mMenuItemSelectedListener = menuItemSelectedListener;
    }

    private OnMenuItemSelectedListener mMenuItemSelectedListener;
}
