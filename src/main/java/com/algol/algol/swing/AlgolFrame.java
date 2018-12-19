package com.algol.algol.swing;

import com.algol.algol.image.Circle;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author leliu
 * @version V1.0
 *  自定义jframe窗口
 * -------------ChangeLog-----------------
 * @date 2018/12/12 20:09
 */
@Getter
@Setter
public class AlgolFrame extends JFrame {

	private int canvasWidth;
	private int canvasHeight;


	public AlgolFrame(String title,int canvasWidth,int canvasHeight) throws HeadlessException {
		super(title);
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		setSize(canvasWidth,canvasHeight);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(new AlgoCanvas());
	}

	private Circle[] circles;
	public void render(Circle[] circles){
		this.circles = circles;
		// jframe 提供的，将jframe所有控件重新刷新
		this.repaint();
	}


	private class AlgoCanvas extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			// 抗锯齿
			RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.addRenderingHints(renderingHints);
			AlgolVisHelper.setWidth(g2d,1);
			AlgolVisHelper.setColor(g2d,Color.RED);
			for (Circle circle : circles) {
				if(circle.isFilled()){
					AlgolVisHelper.strockCircle(g2d, circle.getX(),circle.getY(), circle.getR());
				}else{
					AlgolVisHelper.fillCircle(g2d,circle.getX(),circle.getY(), circle.getR());
				}
			}
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth,canvasHeight);
		}
	}


}
