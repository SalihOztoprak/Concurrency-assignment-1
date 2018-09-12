package com.company;


import java.util.ArrayList;

public class SortingAlgorithms {
    private long timeTaken = 0;

    public SortingAlgorithms() {

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

    public boolean isSorted(ArrayList<Integer> list) {
        boolean sorted = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0) sorted = false;
        }
        return sorted;
    }

    public ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> mergedList = new ArrayList<>();

        while (!list1.isEmpty() && !list2.isEmpty()) {
            if (!list1.isEmpty() && list1.get(0) <= list2.get(0)) {
                mergedList.add(list1.get(0));
                list1.remove(0);
            } else if (!list2.isEmpty() && list1.get(0) > list2.get(0)) {
                mergedList.add(list2.get(0));
                list2.remove(0);
            }
        }
        if (list1.isEmpty()) {
            mergedList.addAll(list2);
        } else {
            mergedList.addAll(list1);
        }

        return mergedList;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

}
