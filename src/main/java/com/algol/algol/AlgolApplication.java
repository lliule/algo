package com.algol.algol;

import com.algol.algol.fenqian.DevideMoneyController;
import com.algol.algol.jui.controller.AlgoVisualize;
import com.algol.algol.sort.select_sort.SelectSortController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dana
 */
@SpringBootApplication
public class AlgolApplication {

	public static void main(String[] args) {
		int sceneWith = 800;
		int sceneHeight = 800;
		int N = 100;
		new SelectSortController(sceneWith, sceneHeight, N);

	}
}
