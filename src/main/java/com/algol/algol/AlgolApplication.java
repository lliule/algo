package com.algol.algol;

import com.algol.algol.mengtekaluo.fenqian.DevideMoneyController;
import com.algol.algol.mengtekaluo.pi.PIController;
import com.algol.algol.mengtekaluo.pi.PIFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dana
 */
@SpringBootApplication
public class AlgolApplication {

	public static void main(String[] args) {
		int sceneWidth = 600,sceneHeight = 600;
		// 多少个点
		int n = 10000;
		new PIController( sceneWidth, sceneHeight,n);
	}
}
