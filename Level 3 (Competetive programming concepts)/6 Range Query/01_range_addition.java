/*abstract
1. You are given a number N.
 2. Assume you have an array of length N initialised with all 0's.
 3. You are also given K update operations.
 4. Each operation contain 3 numbers: startIndex, endIndex and inc and updates each element of the subarray arr[startIndex, endIndex](both inclusive) with inc.
 5. You have to find the resultant array when all K operations are executed.
 6. display is a utility function, feel free to use it for debugging purposes.
 7. main takes input from the users.
 8. This is a functional problem. 
 9. You have to complete the getModifiedArray function. It takes as input a length and a 2D array of update operations. It should return the modified array.
 10. Don't change the code of main and display.

Expected Complexity : O(n+k)
Input Format
First line takes input N, the length of the array.
 Second line takes input K, the number of update operations.
 Next K lines take input 3 space separated integers representing the startIndex, endIndex and inc.
 Input is handled for you.
Output Format
The resultant array.
 Output is handled for you.
Question Video

  COMMENTConstraints
1 <= N <= 30000
Sample Input
4 
3
0 2 -1
2 2 2
1 3 1
Sample Output
-1 0 2 1
*/

import java.util.*;
 
 class range_addition {
 
     // This is a functional problem. You have to complete this function.
     // It takes as input a length and a 2D array of update operations.
     // It should return the modified array.
     public static int[] Range(int length, int[][] updates) {
         // write your code here. 
         int [] ans = new int[length];
         for(int [] update:updates){
            ans[update[0]] += update[2];
            if(update[1]+1<length){
                ans[update[1]+1] += (-update[2]);
            }
        }

        int sum = 0;
        for(int i = 0;i<ans.length;i++){
            sum+=ans[i];
            ans[i] = sum;
        }

        return ans;
     }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
 
         // Input for length of first array.
         int length = sc.nextInt();
 
         int K = sc.nextInt();
 
         int[][] updates = new int[K][3];
 
         for (int i = 0; i < updates.length; i++) {
             for (int j = 0; j < updates[0].length; j++) {
                 updates[i][j] = sc.nextInt();
             }
         }
 
         int[] result = Range(length, updates);
         display(result);
     }
 
     // function to display an array.
     public static void display(int[] arr) {
 
         for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i] + " ");
         }
 
         System.out.println();
     }
 
 }