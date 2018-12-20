package com.algol.algol;

import com.algol.algol.fenqian.DevideMoneyController;
import com.algol.algol.jui.controller.AlgoVisualize;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dana
 */
@SpringBootApplication
public class AlgolApplication {

	public static void main(String[] args) {
		int sceneWidth = 1000,sceneHeight = 1000;

		new DevideMoneyController(sceneWidth, sceneHeight);
	}
}
