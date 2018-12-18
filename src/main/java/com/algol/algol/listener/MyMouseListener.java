package com.algol.algol.listener;

import com.algol.algol.swing.AlgolFrame;
import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 鼠标事件
 * @author dana
 */
@Setter
@AllArgsConstructor
public class MyMouseListener implements MouseListener{
    private AlgolFrame jFrame;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 将画布的左上角坐标置位 （0,0）
        int y = -(jFrame.getBounds().height - jFrame.getCanvasHeight());
        e.translatePoint(0, y);
        System.out.println(e.getX() + " : " + e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
