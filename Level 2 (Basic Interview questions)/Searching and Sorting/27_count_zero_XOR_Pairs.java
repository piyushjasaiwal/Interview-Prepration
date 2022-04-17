/*abstract
1. Given an array A[] of size N. 
2. Find the number of pairs (i, j) such that A[i] XOR A[j] = 0, and 1 <= i < j <= N.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
2 <= N <= 10^5
1 <= A[i] <= 10^5
Sample Input
6
1 3 1 3 1 1
Sample Output
7
*/

import java.util.*;
import java.io.*;

class count_zero_XOR_Pairs {
    public static int countPairs(int[]arr) {
        //write your code here

        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val:arr){
            map.put(val, map.getOrDefault(val, 0)+1);
        }

        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        for(int key:keys){
            int val = map.get(key);
            int k1 = val;
            int k2 = val-1;
            if(k1%2 == 0){
                k1 = k1/2;
            }
            if(k2%2 == 0){
                k2 = k2/2;
            }

            ans = ans + (k1*k2);
        }
        return ans;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println(countPairs(arr));
    }
}