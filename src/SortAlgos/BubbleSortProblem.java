package SortAlgos;

import java.util.Arrays;

public class BubbleSortProblem {
    public static int minFinalLength(int[] nums) {
        int n = nums.length;
        int count = 0;
        boolean swapped;

        for (int i = 0; i < n; i++) {
            swapped = false;
            for (int j = 0; j < n-i-1; j++) {
                if (nums[j] > nums[j +1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;

                }
            }
            if (!swapped) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums = {4, 2, 1, 3};
        minFinalLength(nums);
//        Arrays.stream(nums).forEach(num -> System.out.println(num));// Output: 2
        System.out.println(minFinalLength(new int[]{4, 2, 1, 3}));   // Output: 2
        System.out.println(minFinalLength(new int[]{5, 1, 2, 3, 4}));// Output: 4
    }
}
