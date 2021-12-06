/*abstract
1. You will be given an Array
 2. You need to return width of all its subsequence, where width is defined as difference between its maximum and minimum value
 3. Input and output is handled for you
 4. It is a functional problem ,please do not modify main()
Input Format
Input is handled for you
Output Format
output is handled for you
Question Video

  COMMENTConstraints
1 <= A.length <= 20000
 1 <= A[i] <= 20000
Sample Input
6
7 1 5 2 3 4
Sample Output
232
*/

import java.util.*;
class sum_of_subsequence_widths {
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[] A= new int[n];
        for(int i=0;i<n;i++){
            A[i]=scn.nextInt();
        }
        System.out.print(sumSubseqWidths(A));
 	  }
 	 
 	// -----------------------------------------------------
 	// This is a functional problem. Only this function has to be written.
 	// This function takes as input an array
 	// It should return the required output
 
    public static int sumSubseqWidths(int[] A) {
 	 	  // Write your code here
      long [] pow = new long[A.length];
      long mult = 1;
      int mod = 1000000007;
      for(int i = 0;i<A.length;i++){
        pow[i] = mult%mod;
        mult = (mult*2)%mod;
      }

      long res = 0;
      Arrays.sort(A);

      for(int i = 0;i<A.length;i++){
        res = (res + ((A[i]*((pow[i]-1)-(pow[A.length-i-1]-1)))%mod))%mod;
      }

      return (int)res;
 	  }
}