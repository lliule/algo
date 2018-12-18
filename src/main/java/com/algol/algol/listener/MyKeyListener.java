package com.algol.algol.listener;

import com.algol.algol.cartoon.BallSport;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 键盘事件监听器
 * @author dana
 */
public class MyKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == ' '){
            BallSport.isAnimated = !BallSport.isAnimated;
        }
    }
}
