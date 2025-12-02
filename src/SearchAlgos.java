public class SearchAlgos {


    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(binarySearch(nums, 5));
    }

    public static int learSearch(int[] arr, int target){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            if (arr[i] == target)
                return i;
        }
        return -1;
    }




    public static int binarySearch(int[] arr, int target) {
        int n = arr.length;
        int high = arr.length - 1;
        int low = 0;

        while (low < high){
            int mid = low + (high - low) /2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
            }
        return -1;

        }

    }

