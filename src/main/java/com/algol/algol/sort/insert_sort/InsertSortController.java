package com.algol.algol.sort.insert_sort;

import com.algol.algol.util.Util;

import java.awt.*;

/**
 * Created by dana on 2018/12/30.
 *
 * @author dana
 */
public class InsertSortController {

    private int sceneWitdh;
    private int sceneHeight;
    private InsertSortFrame frame;

    private InsertSortData data;
    public InsertSortController(int sceneWitdh, int sceneHeight, int n) {
        this.sceneWitdh = sceneWitdh;
        this.sceneHeight = sceneHeight;

        data = new InsertSortData(n,sceneHeight);
        EventQueue.invokeLater(()->{
            frame = new InsertSortFrame("insert sort view",sceneWitdh,sceneHeight);
            new Thread(this::run).start();
        });

    }

    private void run() {
        setData(0, -1);
        for (int i = 0; i < data.size(); i++) {
            setData(i, i);
            for (int j = i ; j > 0 ; j--) {
                if(data.get(j) < data.get(j-1)){
                    data.swap(j, j - 1);
                }
                setData(j+1, j);
            }
        }
        setData(data.size(), -1);
    }

    private void setData(int orderedIndex, int currentIndex){
        data.setOrderedIndex(orderedIndex);
        data.setCurrentIndex(currentIndex);
        frame.render(data);
        Util.stop(20);
    }
}
