package SortAlgos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CountSmallerNumbers {

    // Helper class to store value + original index
    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, n - 1, counts);

        List<Integer> result = new ArrayList<>();
        for (int c : counts) {
            result.add(c);
        }
        return result;
    }

    private static void mergeSort(Pair[] arr, int left, int right, int[] counts) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid, counts);
        mergeSort(arr, mid + 1, right, counts);
        merge(arr, left, mid, right, counts);
    }

    private static void merge(Pair[] arr, int left, int mid, int right, int[] counts) {
        List<Pair> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;
        int rightCounter = 0;

        while (i <= mid && j <= right) {
            if (arr[j].value < arr[i].value) {
                // Right element is smaller → inversion
                temp.add(arr[j]);
                rightCounter++;
                j++;
            } else {
                // All previous right elements are smaller
                counts[arr[i].index] += rightCounter;
                temp.add(arr[i]);
                i++;
            }
        }

        while (i <= mid) {
            counts[arr[i].index] += rightCounter;
            temp.add(arr[i]);
            i++;
        }

        while (j <= right) {
            temp.add(arr[j]);
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            arr[left + k] = temp.get(k);
        }
    }
}