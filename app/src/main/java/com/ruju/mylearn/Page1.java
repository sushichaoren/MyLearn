package com.ruju.mylearn;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Page1 extends Activity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);
        mListView = findViewById(R.id.list1);
        final List<Userinfo> userinfoList= new ArrayList<>();
        userinfoList.add(new Userinfo("小江",1926));
        userinfoList.add(new Userinfo("小黄",26));
        userinfoList.add(new Userinfo("小希",12));
        userinfoList.add(new Userinfo("小六",23));
        final List<Userinfo> userinfoList1= new ArrayList<>();
        userinfoList1.add(new Userinfo("小民",1926));
        userinfoList1.add(new Userinfo("小英",26));
        userinfoList1.add(new Userinfo("小宋",12));
        userinfoList1.add(new Userinfo("小王",23));
        final PhoneBookAdapter phoneBookAdapter = new PhoneBookAdapter(Page1.this,userinfoList);
        mListView.setAdapter(phoneBookAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==1){
                    phoneBookAdapter.refreshData(userinfoList);
                }
                if (position==0){
                    phoneBookAdapter.refreshData(userinfoList1);
                }

                //phoneBookAdapter.notifyDataSetChanged();

                //Toast.makeText(Page1.this, userinfoList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
