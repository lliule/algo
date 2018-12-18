package com.algol.algol.util;

/**
 * Created by dana on 2018/12/18.
 *
 * @author dana
 */
public class Util {

    public static void stop(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
