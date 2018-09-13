package com.company;

import java.util.ArrayList;

public class Main {

    public static int THRESHOLD = 4000;
    private NumberGenerator numberGenerator = new NumberGenerator();
    private SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        opdrachtEen(1, 25000);
        opdrachtTwee(1, 25000);
        opdrachtDrie(400000);
    }

    private void opdrachtEen(int round, int amount) {
        ArrayList<Integer> randomList = numberGenerator.generateNumbers(amount);
        randomList = sortingAlgorithms.selectionSort(randomList);

        System.out.println();
        System.out.println("[Round " + round + "] Size of list is: " + randomList.size());
        System.out.println("Is the list sorted: " + sortingAlgorithms.isSorted(randomList));
        System.out.println("Time taken in ms: " + sortingAlgorithms.getTimeTaken());

    }

    private void opdrachtTwee(int round, int amount) {
        ArrayList<Integer> randomList;
        randomList = numberGenerator.generateNumbers(amount);

        ArrayList<Integer> list1 = new ArrayList<>(randomList.subList(0, randomList.size() / 2));
        ArrayList<Integer> list2 = new ArrayList<>(randomList.subList(randomList.size() / 2, randomList.size()));


        NumberThread s1 = new NumberThread(sortingAlgorithms, list1);
        NumberThread s2 = new NumberThread(sortingAlgorithms, list2);

        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            randomList = sortingAlgorithms.merge(list1, list2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("[Round " + round + "] Size of list is: " + randomList.size());
        System.out.println("Is the list sorted: " + sortingAlgorithms.isSorted(randomList));
        System.out.println("Time taken in ms: " + sortingAlgorithms.getTimeTaken());
    }

    private void opdrachtDrie(int amount) {
        ArrayList<Integer> randomList;
        randomList = numberGenerator.generateNumbers(amount);

        final long startTime = System.currentTimeMillis();

        Runner runner = new Runner(sortingAlgorithms, randomList);
        Thread thread = new Thread(runner);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        randomList = runner.getList();

        final long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        System.out.println();
        System.out.println("Size of list is: " + randomList.size());
        System.out.println("Is the list sorted: " + sortingAlgorithms.isSorted(randomList));
        System.out.println("Time taken in ms: " + timeTaken);
    }


}
