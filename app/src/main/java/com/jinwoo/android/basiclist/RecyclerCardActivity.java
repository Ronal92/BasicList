package com.jinwoo.android.basiclist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import static com.jinwoo.android.basiclist.R.id.cardView;

public class RecyclerCardActivity extends AppCompatActivity {

    ArrayList<User> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_card);

        Data data = new Data();
        datas = data.get();

        // 1. RecyclerView 뷰 가져오기

        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        // 2. 어뎁터 생성하기
        CardAdapter ca = new CardAdapter(datas, this);
        // 3. 리스트 뷰에 Adapter 세팅하기
        rv.setAdapter(ca);
        // 4. Recycler 뷰 매니저 등룍하기.....(뷰의 모양을 결정 : 그리드, 일반 리스트, 비대칭 그리드)
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
