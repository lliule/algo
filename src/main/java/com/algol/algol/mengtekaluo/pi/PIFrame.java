package com.algol.algol.mengtekaluo.pi;

import com.algol.algol.jui.image.Circle;
import com.algol.algol.jui.swing.AlgolVisHelper;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author leliu
 * @version V1.0
 */
@Getter
@Setter
public class PIFrame extends JFrame {
	private int canvasWidth;
	private int canvasHeight;


	public PIFrame(String title, int canvasWidth,int canvasHeight) throws HeadlessException {
		super(title);
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		setSize(canvasWidth,canvasHeight);
		setContentPane(new AlgoCanvas());
		pack();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	private ClucPIData clucPIData;
	public void render(ClucPIData clucPIData){
		this.clucPIData = clucPIData;
		this.repaint();
	}

	private class AlgoCanvas extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			// 抗锯齿
			RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.addRenderingHints(renderingHints);
			AlgolVisHelper.setColor(g2d, Color.BLUE);
			Circle circle = clucPIData.getCircle();
			if (null != circle) {
				AlgolVisHelper.strockCircle(g2d,circle.getX(),circle.getY(),circle.getR());
			}
			// 具体绘制
			AlgolVisHelper.setWidth(g2d,3);
				for (int i = 0; i< clucPIData.getPointSize() ; i++) {
					Point p = clucPIData.getPoint(i);
					if(circle.contain(p)){
						AlgolVisHelper.setColor(g2d,Color.BLUE);
					}else{
						AlgolVisHelper.setColor(g2d,Color.RED);
					}
					AlgolVisHelper.fillCircle(g2d,p.x,p.y,3);
				}

		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth,canvasHeight);
		}
	}
}
