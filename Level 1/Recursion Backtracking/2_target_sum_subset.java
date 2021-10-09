/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. Complete the body of printTargetSumSubsets function - without changing signature - to calculate and print all subsets of given elements, the contents of which sum to "tar". Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
Input Format
A number n
n1
n2
.. n number of elements
A number tar
Output Format
Comma separated elements of the subset, the contents of which add to "tar"
.. all such subsets, each in a single line (the elements of each subset should be comma separated)
Question Video

  COMMENTConstraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 20
0 <= tar <= 50
Sample Input
5
10
20
30
40
50
60
Sample Output
10, 20, 30, .
10, 50, .
20, 40, .
 */

import java.io.*;
import java.util.*;

class target_sum_subset {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] ar = new int [n];
        for(int i = 0;i<n;i++){
            ar[i] = s.nextInt();
        }
        int tar = s.nextInt();
        boolean [] taken = new boolean[n];
        printTargetSumSubsets(ar, 0, 0, tar, taken);
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, int sos, int tar, boolean[] taken) {
        if(idx >= arr.length){    
            if(sos == tar){
                print(arr, taken);
                return ;
            }

            return ;
        }
        taken[idx] = true;
        printTargetSumSubsets(arr, idx+1, sos+arr[idx], tar, taken);
        taken[idx] = false;
        printTargetSumSubsets(arr, idx+1, sos, tar, taken);
    }

    private static void print(int[] arr, boolean[] taken) {
        for(int i = 0;i<arr.length;i++){
            if(taken[i]){
                System.out.print(arr[i]+", ");
            }
        }
        System.out.println('.');
    }

}