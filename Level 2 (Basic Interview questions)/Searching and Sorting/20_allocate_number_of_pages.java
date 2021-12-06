/*abstract
1. You are given N number of books. Every ith book has Ai number of pages. 
2. You have to allocate books to M number of students. There can be many ways or permutations to do so. In each permutation, one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations and print this minimum value. 
3. Each book will be allocated to exactly one student. Each student has to be allocated at least one book.
4. Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
 1 <= N <= 10^5
1 <= A [ i ] <= 10^6
1 <= M <= 10^5
Sample Input
4
12 30 48 10
2
Sample Output
58
*/

import java.util.*;
import java.io.*;

class allocate_number_of_pages {

    public static int minPages(int[]arr, int m) {
        //write your code here
        int lo = 0;
        int hi = 0;
        int ans = -1;

        for(int val:arr){
            hi += val;
        }
        while(lo <= hi){
            int mid = (lo+hi)/2;
            // System.out.println(mid);
            if(is_possible(arr, m, mid)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
            // System.out.println(ans);
        }

        return ans;
    }

    private static boolean is_possible(int[] arr, int m, int mid) {
        int cnt = 1;
        int i = 0;
        int sum = 0;
        while(i<arr.length){
            if(arr[i] > mid){
                return false;
            }
            if(sum+arr[i] <= mid){
                sum += arr[i];
            }else{
                sum = arr[i];
                cnt+=1;
            }
            i++;
        }

        return cnt <= m;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
        }

        int m = scn.nextInt();

        int ans = minPages(arr, m);
        System.out.println(ans);
    }
}