package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code
    }
    private ArrayList<Integer> generateNumbers(int amount){
        ArrayList<Integer> numberList = new ArrayList<>();

        for (int i = 0; i <amount ; i++) {
            Random rand = new Random();
            int randomNumber = rand.nextInt(Integer.MAX_VALUE);
            numberList.add(randomNumber);
        }

        return numberList;
    }
}
