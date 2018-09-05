package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        ArrayList<Integer> listOfNumbers = new ArrayList<>();

        listOfNumbers = generateNumbers(25000);
    }

    private ArrayList<Integer> generateNumbers(int amount) {
        ArrayList<Integer> numberList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            int randomNumber = random.nextInt(3);
            numberList.add(randomNumber);
        }

        return numberList;
    }

}
