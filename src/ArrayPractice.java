import java.util.Arrays;
import java.util.Objects;

import static java.util.Collections.reverse;

public class ArrayPractice {



    public static void main(String[] args) {
//        System.out.println(3%5);
        int[] arrayMax = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arrayRotate = {1, 2, 3, 4, 5, 6, 7};
//        System.out.println(maxSubArray(arrayMax));
            System.out.println(Arrays.toString(rotateArray(arrayRotate, 3)));
//            System.out.println(Arrays.toString(arrayRotate));



//        CHECK PALINDROME
        int[] nums = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        System.out.println("Is the array a palindrome: " + isPalindrome(nums));
    }

/*
This the implementation of the Kadanes algorithm to find the
subArrays with the largest sum.
 */
        public static int maxSubArray(int[] array){
            int maxSum = array[0];
            int currentSum = array[0];
            for (int i = 1; i< array.length; i++){
                currentSum = Math.max((currentSum + array[i]), array[i]);
                maxSum = Math.max(currentSum, maxSum);
            }
            return maxSum;
        }

//        rotates first k elements of the array
        public static int[] rotateArray(int[] array, int k){
            int n = array.length;
            int[] newArray = new int[n];
            for (int i = 0; i < array.length; i++){
                newArray[(i + k) % n] = array[i];
            }
            array = newArray;
            return array;
    }


// rotates first kth elements of the array in place
        public static void rotateInPlace(int[] array, int k){
           int n = array.length;

//           handle the situation when K > n
            k = k % n;

//            First reverse the entire array.
            reverse(array, 0, n-1);

//            secondly reverse the first k elements
            reverse(array, 0, k-1);

//            Reverse the remaining n-k elements
            reverse(array, k, n-1);


    }

        private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // Swap elements
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }










        public static int[] moveZeros(int[] array){
            int nextNonZero = 0;

            for (int i = 0; i < array.length; i++) {
                if (array[i] != 0){
                    array[nextNonZero] = array[i];
                    nextNonZero++;
                }
            }

            for (int i = nextNonZero; i < array.length; i++){
                array[i] = 0;
            }
            return  array;
    }





















    public  static void moveZerosSwap(int[] array){
            int nextNonZero = 0;
            for (int i = 0; i < array.length; i++){
                if (array[i] != 0) {
                    if (i != nextNonZero) {
                        int tem = array[nextNonZero];
                        array[nextNonZero] = array[i];
                        array[i] = array[nextNonZero];

                    }
                    nextNonZero++;
                }
            }

        }


    public static boolean isPalindrome(int[] array){
            int left = 0;
            int right = array.length-1;

            while (left < right){
                if(!Objects.equals(array[left], array[right]))
                    return false;
                left++;
                right--;
            }
            return true;
    }











}
