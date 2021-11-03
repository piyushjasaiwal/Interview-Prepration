/*abstract
1. Given an array arr of size n, you need to write a program to find if there exists a pair of elements in the array whose difference is equals to target.
2. If there exists such a pair print it, otherwise print -1.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= target <= 10^4
1 <= arr[i], n <= 10^5
Sample Input
6
5 2 3 80 5 20
78
Sample Output
2 80
*/

import java.util.*;
import java.io.*;

class find_pair_with_given_difference {


    public static void findPair(int[]arr,int target) {
        //write your code here
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            int first = arr[i] - target;
            int second = target + arr[i];
            if(set.contains(first)){
                System.out.println(Math.min(first, arr[i]) + " " + Math.max(arr[i], first));
                return ;
            }

            if(set.contains(second)){
                System.out.println(Math.min(second, arr[i]) + " " + Math.max(arr[i], second));
                return ;
            }

            set.add(arr[i]);
        }

        System.out.println(-1);
    }

    public static void main(String[]args) {

        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();
        findPair(arr,target);
    }
}