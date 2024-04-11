package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        PyramidSort pyramidSort = new PyramidSort();

        int len = 500; //*

        List<Integer> list = new ArrayList<>();
        int[] arr = new int[len];
        int[] arr2 = new int[len];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
            arr2[i] = arr[i];
            list.add(arr[i]);
        }

        long start = System.currentTimeMillis();
        pyramidSort.sort(arr);
        System.out.println("Pyramid Sort : " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        sortArr(arr2);
        System.out.println("Shell Array Sort : " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        sort(list);
        System.out.println("Shell List Sort : " +  (System.currentTimeMillis() - start));
    }

    public static void sort(List<Integer> list){
        for (int s = list.size() / 2; s > 0; s /= 2)
            for (int i = s; i < list.size(); ++i)
                for (int j = i - s; (j >= 0) && (list.get(j) > list.get(j + s)); j -= s) Collections.swap(list, j, j + s);
    }

    public static void sortArr(int[] list){
        for (int s = list.length / 2; s > 0; s /= 2)
            for (int i = s; i < list.length; ++i)
                for (int j = i - s; (j >= 0) && (list[j] > list[j + s]); j -= s) {
                    int temp = list[j];
                    list[j] = list[j + s];
                    list[j + s] = temp;
                }
    }

}