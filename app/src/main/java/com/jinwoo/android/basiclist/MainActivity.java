package com.jinwoo.android.basiclist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button listViewHolderbtn;
    Button listViewbtn;
    Button recycleViewbtn;
    Button cardbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewbtn = (Button)findViewById(R.id.listViewbtn);
        listViewHolderbtn = (Button)findViewById(R.id.listViewHolderbtn);
        recycleViewbtn = (Button)findViewById(R.id.recycleViewbtn);
        cardbtn = (Button) findViewById(R.id.cardbtn);

        listViewbtn.setOnClickListener(this);
        listViewHolderbtn.setOnClickListener(this);
        recycleViewbtn.setOnClickListener(this);
        cardbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch(view.getId()){
            case R.id.listViewbtn:
                intent = new Intent(this, ListActivity.class);
                break;
            case R.id.listViewHolderbtn:
                intent = new Intent(this, ListHolderActivity.class);
                break;
            case R.id.recycleViewbtn:
                intent = new Intent(this, RecyclerActivity.class);
                break;
            case R.id.cardbtn:
                intent = new Intent(this,RecyclerCardActivity.class);
                break;
        }
        startActivity(intent);
    }
}
