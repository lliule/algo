package com.algol.algol.cartoon;

import com.algol.algol.image.Circle;
import com.algol.algol.swing.AlgolFrame;
import com.algol.algol.util.Util;
import lombok.Getter;
import lombok.Setter;

/**
 * 小球运动动画逻辑
 * @author dana
 */
@Setter
@Getter
public class BallSport implements Runnable {
    private AlgolFrame algolFrame;
    private Circle[] circles;
    private int sceneWidth;
    private int sceneHeight;
    public static boolean isAnimated = true;

    public BallSport(AlgolFrame algolFrame, Circle[] circles, int sceneWidth, int sceneHeight) {
        this.algolFrame = algolFrame;
        this.circles = circles;
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    public void run() {
        while (true){
            algolFrame.render(circles);
            Util.stop(20);
            if(isAnimated){
                for (Circle circle : circles) {
                    circle.move(0 ,0, sceneWidth, sceneHeight );
                }
            }
        }
    }
}
