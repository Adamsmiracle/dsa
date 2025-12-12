import java.util.Scanner;

public class BinarySearch {

    // Binary Search Implementation
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int guesses = 0;

        System.out.println("\nSearching for: " + target);
        System.out.println("Array size: " + arr.length + " elements\n");

        while (low <= high) {
            guesses++;
            int mid = low + (high - low) / 2;

            System.out.println("Guess #" + guesses + ":");
            System.out.println("  Range: [" + low + " to " + high + "]");
            System.out.println("  Checking middle index: " + mid + " (value: " + arr[mid] + ")");

            if (arr[mid] == target) {
                System.out.println("  FOUND IT! Target " + target + " is at index " + mid);
                System.out.println("  Total comparisons: " + guesses + "\n");
                return mid;
            } else if (arr[mid] < target) {
                System.out.println("  Target greater than the middle value");
                System.out.println("  Low  = " + (mid + 1));
                low = mid + 1;
            } else {
                System.out.println("  Target is less than middle value");
                System.out.println("  High = " + (mid - 1));
                high = mid - 1;
            }
            System.out.println();
        }

        System.out.println("  Not found after " + guesses + " comparisons\n");
        return -1;
    }

    public static void playHighLowGame() {
        System.out.println(" HIGH-LOW GAME SIMULATION ");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter secret Number for binarySearch to guess (1-100):> ");
        int secretNumber = scanner.nextInt();

        // Create an array from 1 to 100
        int[] numbersArray = new int[100];
        for (int i = 0; i < 100; i++) {
            numbersArray[i] = i + 1;
        }
        int result = binarySearch(numbersArray, secretNumber);

        System.out.println("=".repeat(50));

        if (result != -1) {
            System.out.println("\nSuccess! Your number " + secretNumber + " was found at index " + result);
            System.out.println("   (Remember: array index " + result + " = value " + numbersArray[result] + ")");
        } else {
            System.out.println("\nNumber not found!");
        }

        System.out.println("\nWith 100 numbers, binary search needs at most " +
                (int)Math.ceil(Math.log(100) / Math.log(2)) + " guesses!");

        scanner.close();
    }

    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   BINARY SEARCH: THE HIGH-LOW GAME     ║");
        System.out.println("╔════════════════════════════════════════╗\n");

        playHighLowGame();
    }
}