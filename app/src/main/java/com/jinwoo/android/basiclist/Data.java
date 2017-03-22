package com.jinwoo.android.basiclist;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by JINWOO on 2017-01-31.
 */

public class Data {
    private ArrayList<User> datas;

    public Data(){
        datas = new ArrayList<>();
        load();
    }

    public ArrayList<User> get(){
        return datas;
    }

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
