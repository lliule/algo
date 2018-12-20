package com.algol.algol.jui.controller;

import com.algol.algol.jui.cartoon.BallSport;
import com.algol.algol.jui.image.Circle;
import com.algol.algol.jui.listener.MyKeyListener;
import com.algol.algol.jui.swing.AlgolFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
            algolFrame.addMouseListener(new PointMouseKeyListener());
			/*
			 * 将循环放在其他线程中，让事件队列不被阻塞
			 */
            new Thread(new BallSport(algolFrame,circles,sceneWidth,sceneHeight)).start();
        });

    }

    /**
     * 鼠标点击事件
     */
    private class PointMouseKeyListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            // 设置除了菜单栏以外的页面的坐标
            int height = algolFrame.getCanvasHeight() - algolFrame.getContentPane().getHeight();
            e.translatePoint(0, -height);
            for (Circle circle : circles) {
                if(circle.contain(e.getPoint())){
                    circle.setFilled(!circle.isFilled());
                }
            }
        }
    }
}
