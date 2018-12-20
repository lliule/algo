package com.algol.algol.fenqian;

import com.algol.algol.util.Util;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by dana on 2018/12/20.
 *
 * @author dana
 */
public class DevideMoneyController {
    private DevideMonenyFrame frame;
    private int[] money;

    public DevideMoneyController(int sceneWidth, int sceneHeight) {

        money  = new int[100];
        // 100个人每人手里100块
        for (int i = 0; i < money.length; i++) {
            money[i] = 100;
        }

        EventQueue.invokeLater(()->{
            frame = new DevideMonenyFrame("分钱", sceneWidth,sceneHeight);
            new Thread(this::run,"start-render-thread").start(); ;
        });
    }

    private void run() {
        while (true){
            Arrays.sort(money);
            frame.render(money);
            Util.stop(40);
            for (int i = 0; i < 100; i++) {
                for (int k = 0; k < money.length; k++) {
//                    if(money[k] > 0){
                        int j  = (int) (Math.random() * money.length);
                        money[k] -= 1;
                        money[j] += 1;
//                    }
                }
            }

        }
    }
}
