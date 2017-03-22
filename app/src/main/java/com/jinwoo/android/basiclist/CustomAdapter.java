package com.jinwoo.android.basiclist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by JINWOO on 2017-01-31.
 */

public class CustomAdapter extends BaseAdapter{
    LayoutInflater inflater;
    String[] datas;

    public CustomAdapter(String datas[], Context context){
        this.datas = datas;
        // getView 함수에서 사용할 xml 레이아웃을 객체로 변환해 주는 inflater를 가져온다.
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 사용하는 데이터의 총개수
     * @return
     */
    @Override
    public int getCount() {
        return datas.length;
    }

    /**
     * 선택된 리스트 아이템
     * @param i
     * @return
     */
    @Override
    public Object getItem(int i) {
        return datas[i];
    }

    /**
     *  아이템의 인덱스 값
     * @param i
     * @return
     */
    @Override
    public long getItemId(int i) {
        return i;
    }

    // 리스트 어답터에서 뷰는 한 행(Row) 단위이다.
    // 한 행 단위를 개발자가 직접 만들어서 시스템에 넘겨줘야 한다.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. 한 행에 해당하는 레이아웃 xml을 뷰 객체로 만들어준다.(xml file, null_상위그룹 넣어줄떄 사용)을 넣어준다.
        View view = inflater.inflate(R.layout.list_item, null);


//       뷰를 돌려막기 한다.(한 화면에 나타나지 않는 뷰들을 재사용해서 메모리 오버플로우를 방지한다.)
//        if(convertView == null){    // 한번 화면에 세팅됬던 행은 convertView에 담겨져서 돌아온다.
//            convertView = inflater.inflate((R.layout.list_item,null));
//        }
//        TextView txtNo = (TextView) convertView.findViewById(R.id.txtNo);
//        TextView txtDay = (TextView) convertView.findViewById(R.id.txtDay);


        // 2. inflate된 뷰를 통해서 findViewById 함수를 사용한다.
        TextView txtNo = (TextView) view.findViewById(R.id.txtNo);
        TextView txtDay = (TextView) view.findViewById(R.id.txtDay);

        // 3. inflate된 뷰의 위젯에 값을 세팅한다.
        txtNo.setText(position + 1 + "");
        txtDay.setText(datas[position]);

        // 4. 완성된 한행의 뷰를 시스템에 넘겨준다.
        return view;
    }
}
