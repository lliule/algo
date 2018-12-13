package com.algol.algol.swing;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author leliu
 * @version V1.0
 * 绘图辅助类
 * -------------ChangeLog-----------------
 * @date 2018/12/12 21:07
 */
public class AlgolVisHelper {
	private AlgolVisHelper() {
	}

	public static void setWidth(Graphics2D g2d,int width){
		g2d.setStroke(new BasicStroke(width,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
	}

	public static void setColor(Graphics2D g2d,Color color){
		g2d.setColor(color);
	}

	/**
	 * 画圆
	 * @param g2d 画板
	 * @param x 圆心横坐标
	 * @param y 圆心纵坐标
	 * @param r 半径
	 */
	public static void setStrockCircle(Graphics2D g2d,int x,int y,int r){
		Ellipse2D.Double circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
		g2d.draw(circle);
	}

	public static void fillCircle(Graphics2D g2d,int x,int y,int r){
		Ellipse2D.Double circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
		g2d.fill(circle);
	}
}
