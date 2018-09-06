package com.company;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        new Main().run();

    }

    public void run() {
        Number number = new Number();

        ArrayList<Integer> randomList;
        randomList = number.generateNumbers(25000);

        ArrayList<Integer> list1 = new ArrayList<>(randomList.subList(0, randomList.size() / 2));
        ArrayList<Integer> list2 = new ArrayList<>(randomList.subList(randomList.size() / 2, randomList.size()));

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
        System.out.println("Size of list is: " + randomList.size());
        System.out.println("Is the list sorted: " + number.isSorted(randomList));
        System.out.println("Time taken in ms: " + number.getTimeTaken());
    }

    private ArrayList<Integer>mergeShort(ArrayList<Integer> list1, ArrayList<Integer>list2){
        ArrayList<Integer> mergedList = new ArrayList<>();
       
        return mergedList;
    }

}
