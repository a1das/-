package com.example.download.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.download.R;



public class ListViewAdapter extends BaseAdapter {
    public int viewlist;
    LayoutInflater layoutInflater;

    public ListViewAdapter(int viewListView, Context context){
        this.viewlist=viewListView;
        this.layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        if(convertView==null) {
            convertView = layoutInflater.inflate(R.layout.download_item, null);
        }
        return convertView;
    }
    @Override
    public int getCount() {
        return viewlist;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }
    public void additem(){
        viewlist++;
        this.notifyDataSetChanged();
    }
}
