package com.company;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        for (int i = 1; i < 11; i++) {
            createNewRound(i, 25000);
        }
        for (int i = 1; i < 11; i++) {
            createNewRound(i, 50000);
        }
        for (int i = 1; i < 11; i++) {
            createNewRound(i, 100000);
        }
        for (int i = 1; i < 11; i++) {
            createNewRound(i, 200000);
        }
        for (int i = 1; i < 11; i++) {
            createNewRound(i, 400000);
        }
        for (int i = 1; i < 11; i++) {
            createNewRound(i, 800000);
        }
    }

    private void createNewRound(int round, int amount) {
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
            randomList = mergeShort(list1, list2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("[Round " + round + "] Size of list is: " + randomList.size());
        System.out.println("Is the list sorted: " + number.isSorted(randomList));
        System.out.println("Time taken in ms: " + number.getTimeTaken());
    }

    private ArrayList<Integer> mergeShort(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> mergedList = new ArrayList<>();

        while (!list1.isEmpty() && !list2.isEmpty()) {
            if (!list1.isEmpty() && list1.get(0) <= list2.get(0)) {
                mergedList.add(list1.get(0));
                list1.remove(0);
            } else if (!list2.isEmpty() && list1.get(0) > list2.get(0)) {
                mergedList.add(list2.get(0));
                list2.remove(0);
            }
        }
        if (list1.isEmpty()) {
            mergedList.addAll(list2);
        } else {
            mergedList.addAll(list1);
        }

        return mergedList;
    }

}
