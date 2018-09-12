package com.company;

import java.util.ArrayList;
import java.util.Random;

public class NumberGenerator {

    public NumberGenerator() {

    }

    public ArrayList<Integer> generateNumbers(int amount) {
        ArrayList<Integer> numberList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < amount; i++) {
            int randomNumber = rand.nextInt(Integer.MAX_VALUE);
            numberList.add(randomNumber);
        }

        return numberList;
    }
}
