package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static final int THRESHOLD = 4375;
    private ArrayList<Long> gem;

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        gem = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            opdrachtDrie(400000);
        }

        double sum = 0;

        for (long d : gem) sum += d;

        double avg = sum / gem.size();

        System.out.println(avg);
    }

    private void opdrachtDrie(int amount) {
        Number number = new Number();
        ArrayList<Integer> randomList;
        randomList = number.generateNumbers(amount);

        final long startTime = System.currentTimeMillis();

        Sorter sorter = new Sorter(number,randomList);
        Thread thread = new Thread(sorter);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        randomList = sorter.getList();

        final long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        System.out.println();
        System.out.println("Size of list is: " + randomList.size());
        System.out.println("Is the list sorted: " + number.isSorted(randomList));
        System.out.println("Time taken in ms: " + timeTaken);
        gem.add(timeTaken);
    }

}
