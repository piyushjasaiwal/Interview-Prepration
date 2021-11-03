/*abstract
1. Given an array, you have to find the max sum of i*A[i] where A[i] is the element at index i in the array. 
2. The only operation allowed is to rotate(clock-wise or counter clock-wise) the array any number of times.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= N <= 10^6
1 <= arr[i] <= 10^5
Sample Input
4
8 3 1 2
Sample Output
29
*/

import java.util.*;

class max_sum_in_configuration {

    public static long maximise(int[]ar) {
        //write your code here
        int min_idx = 0;
        int max_idx = 0;
        for(int i = 0;i<ar.length;i++){
            if(ar[min_idx] > ar[i]){
                min_idx = i;
            }

            if(ar[max_idx] < ar[i]){
                max_idx = i;
            }
        }

        long max = Long.MIN_VALUE;
        int cnt = 0;
        int i =min_idx;
        long sum = 0;
        while(true){
            sum += (cnt*ar[i]);
            i = (i+1)%ar.length;
            cnt++;
            if(i == min_idx){
                break;
            }
        }

        max = Math.max(max, sum);

        cnt = ar.length-1;
        i =max_idx;
        sum = 0;
        while(true){
            sum += (cnt*ar[i]);
            i = (i+1)%ar.length;
            cnt = (cnt+1)%ar.length;
            if(i == max_idx){
                break;
            }
        }

        max = Math.max(max, sum);
        return max;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        long ans = maximise(arr);
        System.out.println(ans);
    }
}