package com.company;


import java.util.ArrayList;


public class NumberThread implements Runnable {

    private SortingAlgorithms sortingAlgorithms;
    private ArrayList<Integer> list;

    public NumberThread(SortingAlgorithms sortingAlgorithms, ArrayList<Integer> list) {
        this.sortingAlgorithms = sortingAlgorithms;
        this.list = list;
    }


    @Override
    public void run() {
        sortingAlgorithms.selectionSort(list);
    }

}
