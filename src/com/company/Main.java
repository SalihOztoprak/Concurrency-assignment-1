package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    private long timeTaken = 0;

    public static void main(String[] args) {
        new Main().run();

    }

    public void run() {
        ArrayList<Integer> randomList;
        randomList = generateNumbers(25000);
        randomList = selectionSort(randomList);

        System.out.println(randomList);
        System.out.println("Size of list is: " + randomList.size());
        System.out.println("Is the list sorted: " + isSorted(randomList));
        System.out.println("Time taken in ms: " + timeTaken);
    }


    private ArrayList<Integer> generateNumbers(int amount) {
        ArrayList<Integer> numberList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < amount; i++) {
            int randomNumber = rand.nextInt(Integer.MAX_VALUE);
            numberList.add(randomNumber);
        }

        return numberList;
    }


    public ArrayList<Integer> selectionSort(ArrayList<Integer> list) {
        final long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
        final long endTime = System.currentTimeMillis();
        timeTaken = endTime - startTime;
        return list;
    }

    private boolean isSorted(ArrayList<Integer> list) {
        boolean sorted = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0) sorted = false;
        }
        return sorted;
    }
}
