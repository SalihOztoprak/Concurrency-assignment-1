package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        new Main().run();

    }

    public void run(){
        ArrayList<Integer>randomList = new ArrayList<>();
        randomList=generateNumbers(25000);
        selectionSort(randomList);
        System.out.println(randomList.size());
    }


    private ArrayList<Integer> generateNumbers(int amount){
        ArrayList<Integer> numberList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i <amount ; i++) {
            int randomNumber = rand.nextInt(Integer.MAX_VALUE);
            numberList.add(randomNumber);
        }

        return numberList;
    }


    public void selectionSort(ArrayList<Integer> list){

        for (int i = 0; i <list.size() ; i++) {

            for (int j = i; j <list.size() ; j++) {
                if(list.get(i)>list.get(j)){
                    int temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
        System.out.println(list);

    }
}
