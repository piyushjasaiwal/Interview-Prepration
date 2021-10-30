/*abstract
1.Given an integer array.
 2.You have to find the contiguous subarray within an array (containing at least one number) which has the largest product.
 3.You have to complete the function max() that should retuen an Integer
Input Format
First line contains an Integer 'N' denoting the size of the array.
 Second line contains 'N' space separated elements of the array.
Output Format
Return an Integer
Question Video

  COMMENTConstraints
1<=N<=1000
Sample Input
4
2 3 -2 4
Sample Output
6
*/

import java.util.Scanner;
 
class max_product_subarray {
 
 	public static int max(int[] a) {
 	    //Write your code here.	 	 
        int max = Integer.MIN_VALUE;
        int prod = 1;
        for(int i = 0;i<a.length;i++){
            if(a[i] == 0){
                max = Math.max(0, max);
                prod = 1;
            }else{
                prod = prod*a[i];
                max = Math.max(prod, max);
            }
        }

        prod = 1;
        for(int i = a.length-1;i>=0;i--){
            if(a[i] == 0){
                prod = 1;
            }else{
                prod = prod*a[i];
                max = Math.max(prod, max);
            }
        }

        return max;
 	}
 
 	public static void main(String[] args) {
 	 	Scanner s = new Scanner(System.in);
 	 	int n = s.nextInt();
 	 	int[] a = new int[n];
 	 	for (int i = 0; i < a.length; i++) {
 	 	 	a[i] = s.nextInt();
 	 	}
 	 	System.out.println(max(a));
 
 	}
 
}