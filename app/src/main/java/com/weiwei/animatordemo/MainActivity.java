package com.weiwei.animatordemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.weiwei.animatordemo.BouncingBalls.BouncingBall;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String[] datas = {"BouncingBans"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_contents);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        RecyclerViewAdap adp = new RecyclerViewAdap(MainActivity.this, datas);
        recyclerView.setAdapter(adp);
        adp.setOnClicksListener(new RecyclerViewAdap.OnClicksListener() {
            @Override
            public void onClickListener(String content) {
                if (content.equals(datas[0])) {
                    startActivity(new Intent(MainActivity.this, BouncingBall.class));
                }

            }
        });


    }
}
