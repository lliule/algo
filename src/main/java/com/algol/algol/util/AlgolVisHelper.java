package com.algol.algol.util;

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

	public static final Color Red = new Color(0xF44336);
	public static final Color Pink = new Color(0xE91E63);
	public static final Color Purple = new Color(0x9C27B0);
	public static final Color DeepPurple = new Color(0x673AB7);
	public static final Color Indigo = new Color(0x3F51B5);
	public static final Color Blue = new Color(0x2196F3);
	public static final Color LightBlue = new Color(0x03A9F4);
	public static final Color Cyan = new Color(0x00BCD4);
	public static final Color Teal = new Color(0x009688);
	public static final Color Green = new Color(0x4CAF50);
	public static final Color LightGreen = new Color(0x8BC34A);
	public static final Color Lime = new Color(0xCDDC39);
	public static final Color Yellow = new Color(0xFFEB3B);
	public static final Color Amber = new Color(0xFFC107);
	public static final Color Orange = new Color(0xFF9800);
	public static final Color DeepOrange = new Color(0xFF5722);
	public static final Color Brown = new Color(0x795548);
	public static final Color Grey = new Color(0x9E9E9E);
	public static final Color BlueGrey = new Color(0x607D8B);
	public static final Color Black = new Color(0x000000);
	public static final Color White = new Color(0xFFFFFF);

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
		g2d.fill(rectangle);
	}
}
