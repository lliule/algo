package com.algol.algol.controller;

import com.algol.algol.image.Circle;
import com.algol.algol.listener.MyKeyListener;
import com.algol.algol.listener.MyMouseListener;
import com.algol.algol.swing.AlgolFrame;
import com.algol.algol.cartoon.BallSport;

import java.awt.*;

/**
 * Created by dana on 2018/12/18.
 *
 * @author dana
 */
public class AlgoVisualize {

    private AlgolFrame algolFrame;
    private Circle[] circles;

    public AlgoVisualize(int sceneWidth ,int sceneHeight, int n) {
        // 半径
        int r = 30;
       circles = new Circle[n];
        for (int i = 0; i < n; i++) {
            int x = (int)(Math.random() * (sceneWidth - 2* r)) + r;
            int y = (int) (Math.random() * (sceneHeight - 2 * r)) + r;
            // 速度在 +-5之间
            int vx  = (int) (Math.random() * 11 ) -5;
            int vy  = (int) (Math.random() * 11 ) -5;
            Circle circle = new Circle(x, y, r, vx, vy);
            circles[i] = circle;
        }

        /**
         * 事件队列中的事件必须是很快能结束。否则事件将无法完成
         */
        EventQueue.invokeLater(()->{
            algolFrame = new AlgolFrame("welcome", sceneWidth, sceneHeight);
            algolFrame.addKeyListener(new MyKeyListener());
            algolFrame.addMouseListener(new MyMouseListener(algolFrame));
			/*
			 * 将循环放在其他线程中，让事件队列不被阻塞
			 */
            new Thread(new BallSport(algolFrame,circles,sceneWidth,sceneHeight)).start();
        });

    }
}
