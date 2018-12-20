package com.algol.algol.jui.swing;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * @author leliu
 * @version V1.0
 * 绘图辅助类
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
	 * 画空心圆
	 * @param g2d 画板
	 * @param x 圆心横坐标
	 * @param y 圆心纵坐标
	 * @param r 半径
	 */
	public static void strockCircle(Graphics2D g2d,int x,int y,int r){
		Ellipse2D.Double circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
		g2d.draw(circle);
	}

	/**
	 * 画实心圆
	 * @param g2d 画板
 	 * @param x x轴坐标
	 * @param y y坐标
	 * @param r 半径
	 */
	public static void fillCircle(Graphics2D g2d,int x,int y,int r){
		Ellipse2D.Double circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
		g2d.fill(circle);
	}

	public static void fillRectangle(Graphics2D g2d, int x, int y, int width, int height) {
		Rectangle2D.Double rectangle = new Rectangle.Double(x, y, width, height);
		g2d.draw(rectangle);
	}
}