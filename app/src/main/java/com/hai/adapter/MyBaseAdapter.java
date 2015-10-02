package com.hai.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class MyBaseAdapter<T> extends BaseAdapter {
    private List<T> list_data;
    public Context context;

    public MyBaseAdapter(List<T> list_data, Context context) {
        super();
        this.list_data = list_data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_data.size();
    }

    @Override
    public T getItem(int position) {
        return list_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return convertView;
    }

}
