package com.jinwoo.android.basiclist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    ArrayList<User> datas = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Data data = new Data();
        datas = data.get();

        // 1. RecyclerView 뷰 가져오기
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        // 2. 어뎁터 생성하기
        RecyclerCustomAdapter rca = new RecyclerCustomAdapter(datas, R.layout.list_holder_item);
        // 3. Recycler 뷰에 Adapter 세팅하기
        rv.setAdapter(rca);
        // 4. Recycler 뷰 매니저 등룍하기.....(뷰의 모양을 결정 : 그리드, 일반 리스트, 비대칭 그리드)
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
