public class Arrays {



    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(array));
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


}
