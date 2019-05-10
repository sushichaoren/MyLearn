package com.ruju.mylearn;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TITLE = "title";
    public static final String USER = "user";
    public static final int RESULT_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttontop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "按钮不一定是按钮", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.textmid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "中间不一定不能点", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Spalsh.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.textbot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "文本框不一定是文本框", Toast.LENGTH_SHORT).show();
            }
        });
        //跳转到页面一
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Page1.class);
                startActivity(intent);
                //setResult(RESULT_CODE);
                //finish();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyFragmentActivity.class);
                startActivity(intent);
                //setResult(RESULT_CODE);
                //finish();
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Page3.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Page4.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Page5.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Page6.class);
                startActivity(intent);
            }
        });


//        Intent intent = getIntent();
//        if (intent != null){
//            String text=intent.getStringExtra(TITLE);
//            Userinfo user =(Userinfo) intent.getSerializableExtra(USER);
//            setTitle(user.getName());
//        }
    }

}
