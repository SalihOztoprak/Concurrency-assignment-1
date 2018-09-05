package com.company;

import java.util.ArrayList;

public class Main {
    private long timeTaken = 0;

    public static void main(String[] args) {
        new Main().run();

    }

    public void run() {
        NumberGenerator ng = new NumberGenerator();

        ArrayList<Integer> randomList;
        randomList = ng.generateNumbers(25000);
        randomList = ng.selectionSort(randomList);
        System.out.println(randomList);

        System.out.println("Size of list is: " + randomList.size());
        System.out.println("Is the list sorted: " + ng.isSorted(randomList));
        System.out.println("Time taken in ms: " + ng.getTimeTaken());
    }

}
