package com.company;


import java.util.ArrayList;


public class Sorter implements Runnable {

    private Number number;
    private ArrayList<Integer> list;

    public Sorter(Number ng, ArrayList<Integer> list) {
        this.number = ng;
        this.list = list;
    }


    @Override
    public void run() {
        number.selectionSort(list);
    }
}
