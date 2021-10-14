/*
You have an array with n elements. you have to create all subsequences of this array with length K. For each subsequence, you have to write down the product of k-2 integers, all elements of this sequence except the minimum and maximum element.
your work will be considered done if you will be able to write down all these numbers and tell PepBoss their product mod 10^9+7.
Input Format
The first line contains integer N (length of array) and K.
The second line contains N space separated integers.
Output Format
Print a single line containing one integer - the product of all numbers written down by you modulo 10^9+7.
Question Video

  COMMENTConstraints
1<= N <= 5000
3 <= K <= N
1 <= arr[i] <= 10000
Sample Input
4 3 
1 2 3 4
Sample Output
36
*/

import java.util.*;

class no_max_no_min {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    
        int n = scn.nextInt();
        int k = scn.nextInt();
    
        long[] arr = new long[n];
        for (int z = 0; z < n; z++) {
            arr[z] = scn.nextInt();
        }

        
    }  
}
