package com.jinwoo.android.basiclist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class ListHolderActivity extends AppCompatActivity {

    ArrayList<User> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_holder);

        load();

        // 1. 리스트 뷰 가져오기
        ListView listView2 = (ListView)findViewById(R.id.listView2);
        // 2. 어답터 생성
        CustomHolderAdapter adapter = new CustomHolderAdapter(datas, this);
        // 3. 리스트 뷰에 어답터 세팅
        listView2.setAdapter(adapter);

    }



    class CustomHolderAdapter extends BaseAdapter{

        LayoutInflater inflater;
        ArrayList<User> datas;

       public CustomHolderAdapter(ArrayList<User> datas, Context context) {
           this.datas = datas;
           inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int i) {
            return datas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            Holder holder;

            // 뷰 행이 화면에 보여줘서 생선된 적이 있다면 재사용
            if(convertView==null){
                convertView = inflater.inflate(R.layout.list_holder_item,null);
                holder = new Holder();


                holder.txtId = (TextView) convertView.findViewById(R.id.txtId);
                holder.txtName = (TextView) convertView.findViewById(R.id.txtName);
                holder.txtAge = (TextView) convertView.findViewById(R.id.txtAge);

                convertView.setTag(holder);
            }else{
                holder = (Holder)convertView.getTag();
            }

            // 사용할 데이터 instance를 ArrayList에서 꺼낸다.
            User user = datas.get(position);

            holder.txtId.setText(user.id + "");
            holder.txtName.setText(user.name);
            holder.txtAge.setText(user.age + "");

            return convertView;
        }


    }
    /**
     * 각 행에서 사용되는 위젯을 재사용하기 위한 Holder 클래스
     */
    class Holder{
        public TextView txtId;
        public TextView txtName;
        public TextView txtAge;
    }


    /**
     *  사람 데이터 생성.
     */
    private void load(){
        // 특정 범위의 무작위 난수를 생성해준다.
        Random random = new Random();
        // datas 에 100명의 User를 생성해서 담는다.
        for(int i= 0; i<100; i++){
            User user = new User();
            user.id = i+1;
            user.name = "홍길동"+i;
            user.age = random.nextInt(80);
            datas.add(user);
        }
    }
}
