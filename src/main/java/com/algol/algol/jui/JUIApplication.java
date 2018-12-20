package com.algol.algol.jui;

import com.algol.algol.jui.controller.AlgoVisualize;

/**
 * Created by dana on 2018/12/20.
 *
 * @author dana
 */
public class JUIApplication {
    public static void main(String[] args) {
        int sceneWidth = 800;
        int sceneHeight = 800;
        int n = 10;
        new AlgoVisualize(sceneWidth,sceneHeight,n);

    }
}
