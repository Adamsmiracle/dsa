public class Arrays {



    public static void main(String[] args) {
        int[] arrayMax = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arrayRotate = {1, 2, 3, 4, 5, 6, 7};
//        System.out.println(maxSubArray(arrayMax));
        for (int i: rotateArray(arrayRotate, 3)) {
            System.out.println(i);
        }
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

        public static int[] rotateArray(int[] array, int k){
            int n = array.length;
            int[] newArray = new int[n];
            for (int i = 0; i < array.length; i++){
                newArray[(i + k) % n] = array[i];
            }
            array = newArray;
            return 0;
    }

}
