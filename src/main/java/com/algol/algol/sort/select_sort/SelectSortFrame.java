package com.algol.algol.sort.select_sort;

import com.algol.algol.util.AlgolVisHelper;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dana on 2018/12/26.
 *
 * @author dana
 */
public class SelectSortFrame extends JFrame {

    private int canvasWidth = 1024;
    private int canvasHeight = 768;
    public SelectSortFrame(String title,int canvasWidth, int canvasHeight)  {
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        SelectSortCanvas canvas = new SelectSortCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }



    private SelectionSortData data;
    public void render(SelectionSortData data){
        this.data = data;
        repaint();
    }


    private class SelectSortCanvas extends JPanel{
        public SelectSortCanvas() {
            // 双缓存
            super(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 具体绘制
            int w = canvasWidth/data.N();
            for(int i = 0 ; i < data.N() ; i ++ ) {
                 if(i < data.orderedIndex){
                    AlgolVisHelper.setColor(g2d, AlgolVisHelper.Red);
                }else {
                    AlgolVisHelper.setColor(g2d, AlgolVisHelper.Grey);
                }

                if(i == data.currentCampareIndex){
                    AlgolVisHelper.setColor(g2d,AlgolVisHelper.LightBlue);
                }
                if(i == data.currentMinIndex){
                    AlgolVisHelper.setColor(g2d, AlgolVisHelper.Indigo);
                }
                AlgolVisHelper.fillRectangle(g2d, i * w, canvasHeight - data.get(i), w - 1, data.get(i));
            }
        }
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(canvasWidth, canvasHeight);
    }
}
