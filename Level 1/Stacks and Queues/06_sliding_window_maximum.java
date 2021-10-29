/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the elements of array a.
3. You are given a number k, representing the size of window.
4. You are required to find and print the maximum element in every window of size k.

e.g.
for the array [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6] and k = 4, the answer is [9 9 8 12 12 14 14 32 32 32 32 19 19 19]
Input Format
Input is managed for you
Output Format
Maximum of each window in separate line
Question Video

  COMMENTConstraints
0 <= n < 100000
-10^9 <= a[i] <= 10^9
0 < k < n
Sample Input
17
2
9
3
8
1
7
12
6
14
4
32
0
7
19
8
12
6
4
Sample Output
9
9
8
12
12
14
14
32
32
32
32
19
19
19
*/

import java.io.*;
import java.util.*;

class sliding_window_maximum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
    
        // code
        int [] greater = next_greater(a);
        ArrayList<Integer> ans = slidingWindowMaximum(greater, k, a);
        for(int val:ans){
           System.out.println(val);
        }
     }

     public static int [] next_greater(int [] ar){
        int [] ans = new int[ar.length];
        int i = 1;
        Stack<Integer> s = new Stack<>();
        s.push(0);
        while(i < ar.length){
           while(!s.empty() && ar[i] > ar[s.peek()]){
              ans[s.pop()] = i;
           }
           s.push(i);
           i++;
        }

        while(!s.empty()){
           ans[s.pop()] = Integer.MAX_VALUE;
        }

        return ans;
     }

     public static ArrayList<Integer> slidingWindowMaximum(int [] ar, int k, int [] arr){
      ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<ar.length-k+1;i++){
           int max = i;
           while(ar[max] < (i+k) && ar[max] != Integer.MAX_VALUE){
              max = ar[max];
           }
           list.add(arr[max]);
        }
        return list;
     }
}
