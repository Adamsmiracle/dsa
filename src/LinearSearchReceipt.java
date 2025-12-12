 public class LinearSearchReceipt {

        public static int findItem(String[] receipt, String target) {
            for (int i = 0; i < receipt.length; i++) {
                if (receipt[i].equals(target)) {
                    return i;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            String[] groceryItems = {
                    "Milk", "Bread", "Eggs", "Cheese", "Butter", "Yogurt", "Chicken", "Beef",
                    "Salmon", "Rice", "Pasta", "Tomatoes", "Lettuce", "Carrots", "Onions",
                    "Potatoes", "Bananas", "Apples", "Oranges", "Grapes", "Strawberries",
                    "Blueberries", "Coffee", "Tea", "Sugar", "Salt", "Pepper", "Olive Oil",
                    "Cereal", "Cookies", "Chips", "Soda", "Juice", "Water", "Paper Towels",
                    "Toilet Paper", "Dish Soap", "Laundry Detergent", "Shampoo", "Toothpaste",
                    "Frozen Pizza", "Ice Cream", "Chocolate", "Peanut Butter", "Jam", "Honey",
                    "Flour", "Baking Soda", "Vanilla Extract", "Avocados"
            };

            // Test cases
            System.out.println("\n LINEAR SEARCH\n");

            System.out.println("Test 1: Searching for 'Milk' (first item)");
            int index = findItem(groceryItems, "Milk");
            System.out.println("Found at index: " + index);
            System.out.println("Items touched: " + (index + 1) + "\n");

            // Test 2: Item in the middle
            System.out.println("Test 2: Searching for 'Cereal' (middle area)");
            index = findItem(groceryItems, "Cereal");
            System.out.println("Found at index: " + index);
            System.out.println("Items touched: " + (index + 1) + "\n");

            // Test 3: Item at the very end (WORST CASE)
            System.out.println("Test 3: Searching for 'Avocados' (last item - WORST CASE)");
            index = findItem(groceryItems, "Avocados");
            System.out.println("Found at index: " + index);
            System.out.println("Items touched: " + (index + 1));

            // Test 4: Item not in receipt
            System.out.println("Test 4: Searching for 'Caviar' (not in receipt)");
            index = findItem(groceryItems, "Caviar");
            System.out.println("Found at index: " + index + " (not found)");
            System.out.println("Items touched: " + groceryItems.length + " (had to check everything!)\n");

            // Analysis
            System.out.println("=== ANALYSIS ===");
            System.out.println("Total items on receipt: " + groceryItems.length);
            System.out.println("Best case: 1 comparison (item is first)");
            System.out.println("Worst case: " + groceryItems.length + " comparisons (item is last or not present)");
            System.out.println("Average case: ~" + (groceryItems.length / 2) + " comparisons");

        }
    }

