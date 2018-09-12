package com.company;

import java.util.ArrayList;

public class Main {

    public static int THRESHOLD = 4000;

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        for (int i = 1; i < 11; i++) {
            opdrachtEen(i, 25000);
        }
        for (int i = 1; i < 11; i++) {
            opdrachtEen(i, 50000);
        }
        for (int i = 1; i < 11; i++) {
            opdrachtEen(i, 100000);
        }
        for (int i = 1; i < 11; i++) {
            opdrachtEen(i, 200000);
        }
        for (int i = 1; i < 11; i++) {
            opdrachtEen(i, 400000);
        }
        for (int i = 1; i < 11; i++) {
            opdrachtEen(i, 800000);
        }
    }

    private void opdrachtEen(int round, int amount) {
        Number number = new Number();
        ArrayList<Integer> randomList = number.generateNumbers(amount);
        randomList = number.selectionSort(randomList);

        System.out.println();
        System.out.println("[Round " + round + "] Size of list is: " + randomList.size());
        System.out.println("Is the list sorted: " + number.isSorted(randomList));
        System.out.println("Time taken in ms: " + number.getTimeTaken());

    }

    private void opdrachtTwee(int round, int amount) {

        Number number = new Number();

        ArrayList<Integer> randomList;
        randomList = number.generateNumbers(amount);

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
            randomList = number.merge(list1, list2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("[Round " + round + "] Size of list is: " + randomList.size());
        System.out.println("Is the list sorted: " + number.isSorted(randomList));
        System.out.println("Time taken in ms: " + number.getTimeTaken());
    }


}
