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
        if (list.size() > Main.THRESHOLD) {
            ArrayList<Integer> list1 = new ArrayList<>(list.subList(0, list.size() / 2));
            ArrayList<Integer> list2 = new ArrayList<>(list.subList(list.size() / 2, list.size()));

            Sorter s1 = new Sorter(number, list1);
            Sorter s2 = new Sorter(number, list2);

            Thread t1 = new Thread(s1);
            Thread t2 = new Thread(s2);

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1 = s1.getList();
            list2 = s2.getList();

            this.list = number.merge(list1, list2);
        } else {
            list = number.selectionSort(list);
        }

    }

    public ArrayList<Integer> getList() {
        return list;
    }
}
