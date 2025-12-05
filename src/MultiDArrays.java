public class MultiDArrays {
    public static void main(String[] args){

        MutiDarrays();

    }


   public static void MutiDarrays (){
       int[][][] nums = new int[3][3][3];

       int n = nums[2][1].length;
       System.out.println("ArrayLength "+ n);

       int value = 1;
       for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                for (int k = 0; k < 3; k++) {
                    nums[i][j][k] = value;
                    value++;
                }

            }
       }

//       Printing the arrays
       for (int i = 0; i < 3; i++){
           for (int j = 0; j < 3; j++){
               for (int k = 0; k < 3; k++){
                   System.out.print(nums[i][j][k] + "   ");

               }
               System.out.println("\n");

           }
           System.out.println("-".repeat(13));
       }
   }

}
