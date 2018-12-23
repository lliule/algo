package com.algol.algol.mengtekaluo.fenqian;

import com.algol.algol.jui.swing.AlgolVisHelper;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

/**
 * @author leliu
 * @version V1.0
 *  自定义jframe窗口
 * -------------ChangeLog-----------------
 * @date 2018/12/12 20:09
 */
@Getter
@Setter
public class DevideMonenyFrame extends JFrame {

	private int canvasWidth;
	private int canvasHeight;


	public DevideMonenyFrame(String title, int canvasWidth, int canvasHeight) throws HeadlessException {
		super(title);
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		setSize(canvasWidth,canvasHeight);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(new AlgoCanvas());
	}

	private int[] money;
	public void render(int[] money){
		this.money = money;
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
			// 具体绘制

			int w = canvasWidth / money.length;
			for (int i = 0; i < money.length; i++) {
				if(money[i] > 0){
					AlgolVisHelper.setColor(g2d,Color.BLUE);
					AlgolVisHelper.fillRectangle(g2d, i * w + 1, canvasHeight / 2 - money[i],w-1, money[i]);
				}else if(money[i] < 0){
					AlgolVisHelper.setColor(g2d,Color.RED);
					AlgolVisHelper.fillRectangle(g2d, i * w + 1, canvasHeight/2, w-1 , -money[i]);
				}
			}
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth,canvasHeight);
		}
	}


}
