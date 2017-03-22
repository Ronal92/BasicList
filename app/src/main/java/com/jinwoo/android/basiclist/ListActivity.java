package com.jinwoo.android.basiclist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    String[] array = {"월", "화", "수", "목", "금", "토", "일"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // 1. 리스트뷰를 정의한다.
        listView = (ListView) findViewById(R.id.listView);

        // 2. 어답터를 정의한다.
// >> 방법 2 (클래스 정의해서)
        CustomAdapter adapter = new CustomAdapter(array, this);


// >> 방법 1 (클래스 정의X)
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this, android.R.layout.simple_list_item_1, array
//                //컨텍스트,            리스트뷰에서 사용할 레이아웃(안드로이드에서 정의),        배열데이터
//        );
//          adapter.setText(array);

        // 3. 리스트뷰에 아답터를 세팅한다.
        listView.setAdapter(adapter);


        // 4. 리스트뷰에 리스너를 달아준다.
        listView.setOnItemClickListener(listener);
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            // 1. DetailAcivity로 전환하기 위해 intent 생성
            Intent intent = new Intent(ListActivity.this, DetailActivity.class);
            // 2. 넘길 데이터를 세팅하고
            intent.putExtra("no", position+1);
            intent.putExtra("day", array[position]);

            // 3. 액티비티 호출
            startActivity(intent);
        }
    };

}
