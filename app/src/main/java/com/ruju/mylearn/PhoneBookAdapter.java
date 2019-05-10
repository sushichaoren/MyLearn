package com.ruju.mylearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflacter;
    private List<Userinfo> mUserlist = new ArrayList<>();

    public PhoneBookAdapter(Context context,List<Userinfo> userInfos) {
        mContext = context;
        mLayoutInflacter = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mUserlist=userInfos;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getCount() {
        return mUserlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mUserlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView==null){
            convertView = mLayoutInflacter.inflate(R.layout.item_phonebook_frienf, null);

            viewHolder = new ViewHolder();

            viewHolder.name = convertView.findViewById(R.id.phonebook_name);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(mUserlist.get(position).getName());

        return convertView;
    }

    public void refreshData(List<Userinfo>userinfos){
        mUserlist = userinfos;
        notifyDataSetChanged();
    }
    class ViewHolder{
        TextView name;
    }
}
