package com.company;

import java.util.ArrayList;


public class Runner implements Runnable {

    private SortingAlgorithms sortingAlgorithms;
    private ArrayList<Integer> list;

    public Runner(SortingAlgorithms sortingAlgorithms, ArrayList<Integer> list) {
        this.sortingAlgorithms = sortingAlgorithms;
        this.list = list;
    }

    @Override
    public void run() {
        if (list.size() > Main.THRESHOLD) {
            ArrayList<Integer> list1 = new ArrayList<>(list.subList(0, list.size() / 2));
            ArrayList<Integer> list2 = new ArrayList<>(list.subList(list.size() / 2, list.size()));

            Runner r1 = new Runner(sortingAlgorithms, list1);
            Runner r2 = new Runner(sortingAlgorithms, list2);

            Thread t1 = new Thread(r1);
            Thread t2 = new Thread(r2);

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1 = r1.getList();
            list2 = r2.getList();

            this.list = sortingAlgorithms.merge(list1, list2);
        } else {
            list = sortingAlgorithms.selectionSort(list);
        }
    }

    public ArrayList<Integer> getList() {
        return list;
    }
}
