package SortAlgos;

import java.util.Arrays;
import java.util.Random;

import  SortAlgos.*;


public class Main {
    public static void main(String[] args){

//        Test merge sort

        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++){
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before: ");
        for(int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        SortAlgos.bubbleSort(numbers);

        System.out.println("\nAfter bubble sort");
        for(int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

    }
}
