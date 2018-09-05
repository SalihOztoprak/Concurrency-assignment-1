package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        new Main().run();

    }

    public void run() {
        ArrayList<Integer> randomList;
        randomList = generateNumbers(25000);
        randomList = selectionSort(randomList);

        System.out.println(randomList);
        System.out.println("the size of the list ; "+randomList.size());
        System.out.println("is the list sorted: "+ isSorted(randomList));
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


    private ArrayList<Integer> selectionSort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {

            for (int j = i; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }


    private boolean isSorted(ArrayList<Integer> list)
    {
        boolean sorted = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1).compareTo(list.get(i)) > 0) sorted = false;
        }
        return sorted;
    }

}
