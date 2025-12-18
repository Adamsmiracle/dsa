package SortAlgos;

public class SortAlgos{

    static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;
        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

//        leftHalf of array
        for (int i =0; i < midIndex; i++){
            leftHalf[i] = inputArray[i];
        }
//        rightHalf of array
        for (int i = midIndex; i < inputLength; i++){
            rightHalf[i - midIndex] = inputArray[i];
        }

//        Recursively divide the array.
        mergeSort(leftHalf);
        mergeSort(rightHalf);

//        Merge
        merge(inputArray, leftHalf, rightHalf );
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalft){
        int leftSize = leftHalf.length;
        int rightSize = rightHalft.length;

        int i = 0, j = 0, k = 0;


        while (i < leftSize && j < rightSize){
            if (leftHalf[i] <= rightHalft[j]){
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalft[j];
                j++;
            }
            k++;
        }

         while (i < leftSize) {
             inputArray[k] = leftHalf[i];
             i++;
             k++;
         }

         while (j < rightSize) {
             inputArray[k] = rightHalft[j];
             k++;
             j++;
         }

    }




    static void bubbleSort(int[] arr) {
        int size = arr.length;
        boolean swapped;
        
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in inner loop, array is sorted
            if (!swapped) {
                break;
            }
        }
    }

}

