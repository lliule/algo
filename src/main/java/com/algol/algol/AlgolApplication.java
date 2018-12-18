package com.algol.algol;

import com.algol.algol.controller.AlgoVisualize;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgolApplication {

	public static void main(String[] args) {
//		SpringApplication.run(AlgolApplication.class, args);
		int sceneWidth = 800;
		int sceneHeight = 800;
		int n = 10;

		new AlgoVisualize(sceneWidth,sceneHeight,n);

	}
}
