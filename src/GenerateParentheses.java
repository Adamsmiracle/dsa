import java.util.*;

public class GenerateParentheses {

    // ========================================================================
    // SOLUTION 1: PURE RECURSION (Building from scratch)
    // ========================================================================

    /**
     * Generate parentheses using pure recursion.
     * Builds valid combinations by tracking open and close counts.
     */
    public static List<String> generateParenthesisRecursion(int n) {
        List<String> result = new ArrayList<>();
        generateRecursive(result, "", 0, 0, n);
        return result;
    }

    private static void generateRecursive(List<String> result, String current, int open, int close, int max) {
        // Base case: string is complete
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Add opening parenthesis if we haven't used all
        if (open < max) {
            generateRecursive(result, current + "(", open + 1, close, max);
        }

        // Add closing parenthesis if valid
        if (close < open) {
            generateRecursive(result, current + ")", open, close + 1, max);
        }
    }


    // ========================================================================
    // SOLUTION 2: BACKTRACKING (Using StringBuilder for efficiency)
    // ========================================================================

    /**
     * Generate parentheses using backtracking with StringBuilder.
     * More efficient as it modifies the string in-place and backtracks.
     */
    public static List<String> generateParenthesisBacktracking(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder current,
                                  int open, int close, int max) {
        // Base case: we've built a complete valid combination
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // Choice 1: Add opening parenthesis
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // BACKTRACK
        }

        // Choice 2: Add closing parenthesis
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // BACKTRACK
        }
    }


    // ========================================================================
    // SOLUTION 3: BACKTRACKING with Character Array (Most efficient)
    // ========================================================================

    /**
     * Generate parentheses using backtracking with character array.
     * Most memory efficient approach.
     */
    public static List<String> generateParenthesisOptimized(int n) {
        List<String> result = new ArrayList<>();
        char[] current = new char[n * 2];
        backtrackArray(result, current, 0, 0, 0, n);
        return result;
    }

    private static void backtrackArray(List<String> result, char[] current,
                                       int pos, int open, int close, int max) {
        // Base case: filled the array
        if (pos == current.length) {
            result.add(new String(current));
            return;
        }

        // Add opening parenthesis
        if (open < max) {
            current[pos] = '(';
            backtrackArray(result, current, pos + 1, open + 1, close, max);
        }

        // Add closing parenthesis
        if (close < open) {
            current[pos] = ')';
            backtrackArray(result, current, pos + 1, open, close + 1, max);
        }
    }


    // ========================================================================
    // HELPER METHODS FOR TESTING
    // ========================================================================

    private static void printResults(String method, List<String> results) {
        System.out.println(method + ":");
        System.out.println(results);
        System.out.println("Count: " + results.size());
        System.out.println();
    }

    private static void visualizeRecursionTree() {
        System.out.println("=".repeat(60));
        System.out.println("RECURSION TREE FOR n=2");
        System.out.println("=".repeat(60));
        System.out.println("""
                               start: ""
                               open=0, close=0
                                      |
                           add '(' (open < max)
                                      |
                                  current: "("
                                open=1, close=0
                                   /        \\
                        add '('   /          \\   add ')' 
                        (open<max)            \\  (close<open)
                             /                 \\
                        "(("                    "()"
                    open=2,close=0          open=1,close=1
                         |                      /        \\
                   add ')' only          add '('        add ')'
                  (close<open)          (open<max)   (close<open)
                         |                  |              |
                      "(()"              "()("          "())"
                  open=2,close=1      open=2,close=1  [COMPLETE]
                         |                  |
                    add ')' only        add ')' only
                         |                  |
                     "(())"              "()()"
                    [COMPLETE]          [COMPLETE]
        """);
        System.out.println("=".repeat(60));
        System.out.println();
    }

    private static void demonstrateBacktracking() {
        System.out.println("=".repeat(60));
        System.out.println("BACKTRACKING DEMONSTRATION");
        System.out.println("=".repeat(60));
        System.out.println("""
        Backtracking with StringBuilder for n=2:
        
        Step 1: current = ""       -> append '(' -> current = "("
        Step 2: current = "("      -> append '(' -> current = "(("
        Step 3: current = "(("     -> append ')' -> current = "(()"
        Step 4: current = "(()"    -> append ')' -> current = "(())" ✓
                Store "(())" in result
                BACKTRACK: delete ')' -> current = "(()"
                BACKTRACK: delete ')' -> current = "(("
                BACKTRACK: delete '(' -> current = "("
        Step 5: current = "("      -> append ')' -> current = "()"
        Step 6: current = "()"     -> append '(' -> current = "()("
        Step 7: current = "()("    -> append ')' -> current = "()()" ✓
                Store "()()" in result
                BACKTRACK: delete ')' -> current = "()("
                BACKTRACK: delete '(' -> current = "()"
        
        The key difference: StringBuilder is modified in-place and restored
        after each recursive call using deleteCharAt().
        """);
        System.out.println("=".repeat(60));
        System.out.println();
    }


    // ========================================================================
    // MAIN METHOD - TEST ALL SOLUTIONS
    // ========================================================================

    public static void main(String[] args) {
        System.out.println("GENERATE PARENTHESES - JAVA SOLUTIONS\n");

        // Test with n = 3
        int n = 3;
        System.out.println("Testing with n = " + n);
        System.out.println("=".repeat(60));

        List<String> result1 = generateParenthesisRecursion(n);
        printResults("Solution 1 - Pure Recursion", result1);

        List<String> result2 = generateParenthesisBacktracking(n);
        printResults("Solution 2 - Backtracking (StringBuilder)", result2);

        List<String> result3 = generateParenthesisOptimized(n);
        printResults("Solution 3 - Backtracking (char array)", result3);

        // Verify all solutions produce same results
        System.out.println("All solutions match: " +
                (result1.equals(result2) && result2.equals(result3)));
        System.out.println();

        // Visualizations
        visualizeRecursionTree();
        demonstrateBacktracking();

        // Performance comparison
        System.out.println("=".repeat(60));
        System.out.println("COMPLEXITY COMPARISON");
        System.out.println("=".repeat(60));
        System.out.println("""
        Solution 1 - Pure Recursion:
          Time: O(4^n / √n)  Space: O(n) recursion + O(n) per string
          Creates new string objects at each step
        
        Solution 2 - Backtracking (StringBuilder):
          Time: O(4^n / √n)  Space: O(n) recursion + O(n) shared buffer
          Reuses single StringBuilder, more memory efficient
        
        Solution 3 - Backtracking (char array):
          Time: O(4^n / √n)  Space: O(n) recursion + O(n) shared array
          Most efficient, minimal object creation
        
        All have same time complexity (Catalan number growth)
        Backtracking solutions are more memory efficient
        """);
        System.out.println("=".repeat(60));
    }
}