package com.algol.algol.swing;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author leliu
 * @version V1.0
 * @Description: 自定义jframe窗口
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


	private class AlgoCanvas extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			AlgolVisHelper.setColor(g2d,Color.RED);
			AlgolVisHelper.setWidth(g2d,5);
			AlgolVisHelper.setStrockCircle(g2d,canvasWidth/2,canvasHeight/2 ,200);
			g2d.setColor(Color.YELLOW);
			AlgolVisHelper.fillCircle(g2d,canvasWidth/2,canvasHeight/2,200);
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth,canvasHeight);
		}
	}

	public static void main(String[] args) {
		AlgolFrame frame = new AlgolFrame("你好", 500, 500);
	}
}
