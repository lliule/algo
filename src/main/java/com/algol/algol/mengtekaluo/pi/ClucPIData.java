package com.algol.algol.mengtekaluo.pi;

import com.algol.algol.jui.image.Circle;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.LinkedList;

/**
 *
 * @author leliu
 * @version V1.0
 *  计算pi值的数据
 */
public class ClucPIData {
	@Setter
	@Getter
	private Circle circle;
	private LinkedList<Point> points ;
	// 在圆中的点的个数
	private int totalInCircle = 0;

	public ClucPIData(Circle circle) {
		this.circle = circle;
		this.points = new LinkedList<>();
	}

	public Point getPoint(int index){
		return points.get(index);
	}

	public int getPointSize(){
		return points.size();
	}

	public void addPoint(Point p){
		points.add(p);
		if(circle.contain(p)){
			totalInCircle ++;
		}
	}

	/**
	 * 求pi 的值
	 * 等于圆内点数* 4 / 总点数
	 * @return
	 */
	public double getPI(){
		return totalInCircle * 4 / points.size();
	}

}
