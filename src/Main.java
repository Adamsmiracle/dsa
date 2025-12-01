//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
////EvenOdd check;
//    System.out.println(BuildLogic.EvenAndOdd(3));

////    EvenAndOddBitwise
//    System.out.println("This is the bitwise result: "+BuildLogic.EvenAndOdd(50));


////    Multiplication table
//    BuildLogic.printMultiplication(5);


//    Printing the numbers recursively
    BuildLogic.PrintMultiplicationRecursive(10, 1);


//    Sum of natural numbers
    int result = BuildLogic.sumNaturalNumbs(10);
    System.out.println("result of natural numbers: "+ result);



//    sum of natural number using recursion
    int result2 = BuildLogic.sumNaturalNumbersRecursive(-10);
    System.out.println("Sum using resursion: "+ result2);


//    sum of natural numbers using formalar
    int return3 = BuildLogic.sumNaturalNumbersRecursiveFormular(-10);
    System.out.println("Sum using formular: " + result);


//    SWAP NUMBERS
    int[] swapResult = BuildLogic.swapNumber(10, 20);
    ;System.out.println("\n\n");
//    System.out.println("swapped number: " + Arrays.toString(swapResult));



//    Check near and divisible
    int findNearResult = BuildLogic.findNearAndDivisible(23, 5);
    System.out.println("findNearAndDivisible of 13 and 4: " + findNearResult);



////    FINDING THE NUMBER OPPOSITE THE DICE
//    Scanner input = new Scanner(System.in);
//    System.out.print("Enter your side of Dice: ");
//    int diceValue = input.nextInt();
//    int diceOpposite = BuildLogic.diceOpposite(diceValue);
//    System.out.println("dice opposite: " + diceOpposite);
//
//



//    Find the nth term in AP
    int answer = BuildLogic.findNthTermAP(1, 3, 10);
    System.out.println(" answer: " + answer);
}




