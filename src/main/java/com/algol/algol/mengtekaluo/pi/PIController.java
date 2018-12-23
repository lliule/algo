package com.algol.algol.mengtekaluo.pi;


import com.algol.algol.jui.image.Circle;
import com.algol.algol.util.Util;

import java.awt.*;

/**
 * @author leliu
 * @version V1.0
 */
public class PIController {

	private ClucPIData clucPIData;
	private PIFrame frame;
	private int N;

	public PIController(int sceneWidth, int sceneHeight, int n) {
		Circle circle = new Circle(sceneWidth / 2, sceneHeight / 2, sceneWidth /2);
		clucPIData = new ClucPIData(circle);
		N = n;

		EventQueue.invokeLater(()->{
			frame = new PIFrame("pi求值", sceneWidth, sceneHeight );
			new Thread(()->{
				run();
			}).start();

		});
	}

	private void run() {
		for (int i = 0; i < N; i++) {
			if(i != 0 && i % 100 == 0) {
				frame.render(clucPIData);
				Util.stop(40);
				System.out.println(clucPIData.getPI());
			}
			int x = (int) (Math.random() * frame.getCanvasWidth());
			int y =(int) (Math.random() * frame.getCanvasHeight());
			clucPIData.addPoint(new Point(x,y));
		}
	}
}
