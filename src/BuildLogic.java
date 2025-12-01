import java.util.Arrays;

public class BuildLogic {


    // Checking if the number is even or odd
    //    using the normal approach.
    public static boolean EvenAndOdd(int num) {
        if (num % 2 == 0) {
            return true;
        };
        return false;
    };



//    Using bigwise AND operator;
//    if the number & 1 gives zero, them the number is
    public static boolean EvenOrOddBitwise(int num) {
        if ((num & 1) == 0)
            return true;
        return false;
    }


//    printing the multiplication table iteratively
    public static void printMultiplication(int num) {
        for (int i = 1; i <= 10; i++){
            System.out.printf(num + " x " + i + " = "+ (num * i) + "\n");
        }
    }


//    multiplication with recursion
    public static void PrintMultiplicationRecursive(int num, Integer... val){
        int i = 1;

        if (val.length != 0)
            i = val[0];
        if (i == 11)
            return;
        System.out.println("Recursive: "+ num + " x " + i + " = " + (num * i));
        i++;
        PrintMultiplicationRecursive(num, i);
    }



// SUM OF NATURAL NUMBERS
//    1. Native approach - O(n) for time and O(1) for space;
    public static int sumNaturalNumbs(int num) {
        int sum = 0;
        num = Math.abs(num);
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }


//    2. Recursive approach - O(n) for time and O(n) for space;
    public static int sumNaturalNumbersRecursive(int num) {
        num = Math.abs(num);
        int sum = 0;
        if (num == 1)
            return 1;
        return num + sumNaturalNumbersRecursive(num - 1);
    }



//    3. Using the mathetics formular;
    public static int sumNaturalNumbersRecursiveFormular(int num) {
        return num * (num + 1) / 2;
    }


    //SWAP TWO NUMBERS;
    public static int[] swapNumber(int num1, int num2) {
        int temp = num1;

        int[] originalOrder = {num1, num2};
        System.out.println("The original order: " + Arrays.toString(originalOrder));
        num1 = num2;
        num2 = temp;


        int[] numbs = {num1, num2};
        return numbs;
    }



//    Given two integers n and m (m != 0). Find the number closest to n and divisible by m.
//    If there is more than one such number, then output the one having maximum absolute value.
    public static int findNearAndDivisible(int near, int divisible){
//        divide the near by the quotient and find the quotient
        int quotient = near / divisible;
        System.out.println("quotient: " + quotient);
        if (quotient == 0)
            return -1;
        int nears2 = near * divisible > 0? (quotient + 1) * divisible: (quotient - 1) * divisible;
        int nears = quotient * divisible;


//        check how far they are from the "near";
        int d1 = Math.abs( (near - nears));
        int d2 = Math.abs( (near - nears2));
        if (d1 < d2) {
            return nears;
        }else if (d2 < d1) return nears2;
        if (d1 == d2 && Math.abs(near) > Math.abs(nears2)){
            return nears;
        }else return nears2;


    }


//    You are given a cubic dice with 6 faces.
//    All the individual faces have a number printed on them.
//    The numbers are in the range of 1 to 6, like any ordinary dice.
//    You will be provided with a face of this cube,
//    your task is to guess the number on the opposite face of the cube.

//    Using the ANSI standard colors to color the texts
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


    public static int diceOpposite(int num) {
        System.out.println("You entered: "+ num);
        if (num > 6){
            System.out.println(ANSI_RED + "Number cannot be greater than 6" + ANSI_RESET);
            return 0;
        }
        return 7 - Math.abs(num);

    }



//    Given two integers a1 and a2, the first and second
//    terms of an Arithmetic Series respectively, the problem
//    is to find the nth term of the series.

    public static int findNthTermAP(int num1, int num2, int nth){
        if (nth == 0)
            return -1;

//       find the difference
        int d = Math.abs(num2 - num1);

        int nthTerm = num1 + (nth - 1) * d;
        return nthTerm;
    }



//    Check if the array is sorted or not;
    public static boolean isSorted(int[] arr){
    int n = arr.length;
    for (int i = 1; i < n; i++){
        if (arr[i - 1] > arr[1]) {
            return false;
        }
    }
        return true;
    }

}
