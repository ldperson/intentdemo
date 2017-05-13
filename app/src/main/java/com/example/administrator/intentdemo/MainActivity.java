package com.example.administrator.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCoolector.addActivity(this);
        Button button= (Button) findViewById(R.id.button1);
        if (savedInstanceState!=null){
            String data=savedInstanceState.getString("key");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);

            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String data="aaa";
        outState.putString("key",data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCoolector.removeActivity(this);
    }
}
