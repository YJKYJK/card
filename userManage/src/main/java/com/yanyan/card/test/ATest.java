package com.yanyan.card.test;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/10/13 0013.
 */
public class ATest {
    public static void main(String[] args){
        Date d=new Date();
        String uuid= UUID.randomUUID().toString().substring(0,12);

        System.out.println(d.getTime());
    }
}
