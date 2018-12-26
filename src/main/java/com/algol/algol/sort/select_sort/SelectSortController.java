package com.algol.algol.sort.select_sort;

import com.algol.algol.util.AlgolVisHelper;
import com.algol.algol.util.Util;

import java.awt.*;


/**
 * Created by dana on 2018/12/26.
 *
 * @author dana
 */
public class SelectSortController {

    private SelectionSortData data;
    private SelectSortFrame frame;

    public SelectSortController(int sceneWidth,int sceneHeight, int n) {
        this.data = new SelectionSortData(n, sceneHeight);

        EventQueue.invokeLater(()->{
            frame = new SelectSortFrame("select sort", sceneWidth, sceneHeight);
            new Thread(()->{
                run();
            }).start();
        });
    }

    private void run() {
        setData(0, -1, -1);
        for (int i = 0; i < data.N(); i++) {
            // 寻找[i,n)区间里的最小值的索引
            int minIndex= i;
            setData(i, -1, minIndex);
            for (int j = i+1; j < data.N(); j++) {
                setData(i, j, minIndex);
                data.currentCampareIndex = j;
                if(data.get(j) < data.get(minIndex)){
                    minIndex = j;
                    setData(i, j, minIndex);
                }
            }
            data.swap(i, minIndex);
            setData(i+1, -1, -1);
        }
        setData(data.N(), -1, -1);
    }

    private void setData(int i, int currentCampareIndex, int minIndex) {
        data.orderedIndex = i;
        data.currentCampareIndex = currentCampareIndex;
        data.currentMinIndex = minIndex;
        frame.render(data);
        Util.stop(20);
    }
}
