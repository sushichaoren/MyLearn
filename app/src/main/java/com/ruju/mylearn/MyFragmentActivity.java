package com.ruju.mylearn;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MyFragmentActivity extends FragmentActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        //setContentView(R.layout.item_phonebook_frienf);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        MyFragment myFragment = new MyFragment();
        fragmentTransaction.add(R.id.frag_lay,myFragment).commit();
        //fragmentTransaction.remove(myFragment);

    }
}
