package com.algol.algol.image;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by dana on 2018/12/18.
 * 圆
 * @author dana
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Circle {

    /**
     * 圆心坐标
     */
    private int x ,y;
    /**
     * 半径
     */
    private int r;

    /**
     * 速度
     */
    private int vx ,vy;

    /**
     * 移动
     */
    public void move(int minx, int miny, int maxx ,int maxy){
        x += vx;
        y += vy;
        checkCollision(minx, miny,maxx ,maxy);
    }

    /**
     * 检查碰撞
     * @param minx x轴最小大小
     * @param miny y轴最小大小
     * @param maxx x轴最大大小
     * @param maxy y轴最大大小
     */
    public void checkCollision(int minx, int miny, int maxx ,int maxy){
        if(x - r < minx){
            x= r;
            vx = -vx;
        }
        if(x + r > maxx){
            x = maxx - r;
            vx = -vx;
        }
        if(y - r < miny){
            y = r;
            vy = -vy;
        }
        if(y + r > maxy){
            y = maxy - r;
            vy = -vy;
        }
    }

}
