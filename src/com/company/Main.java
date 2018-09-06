package com.company;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        for (int i = 1; i < 11; i++) {
            createNewRound(i,25000);
        }
        for (int i = 1; i < 11; i++) {
            createNewRound(i,50000);
        }
        for (int i = 1; i < 11; i++) {
            createNewRound(i,100000);
        }
        for (int i = 1; i < 11; i++) {
            createNewRound(i,200000);
        }
        for (int i = 1; i < 11; i++) {
            createNewRound(i,400000);
        }
        for (int i = 1; i < 11; i++) {
            createNewRound(i,800000);
        }
    }

    private void createNewRound(int round, int amount){
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
            randomList = mergeShort(list1,list2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("[Round " + round + "] Size of list is: " + randomList.size());
        System.out.println("Is the list sorted: " + number.isSorted(randomList));
        System.out.println("Time taken in ms: " + number.getTimeTaken());
    }

    private ArrayList<Integer>mergeShort(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> mergedList = new ArrayList<>();

        int indexList1 = 0;
        int indexList2 = 0;

        for (int i = 0; i < list1.size()+list2.size(); i++) {
            if (indexList1 != list1.size() && list1.get(indexList1) < list2.get(indexList2)){
                mergedList.add(list1.get(indexList1));
                indexList1++;
            } else {
                mergedList.add(list2.get(indexList2));
                indexList2++;
            }
        }

        return mergedList;
    }

}
