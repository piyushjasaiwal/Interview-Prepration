/*abstract
1. Given an array of integers. Find the Inversion Count in the array. 
2. For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
3. Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
Input Format
A number n, denoting number of elements
n number of integers, denoting elements of array
Output Format
Print the count of total inversions
Question Video

  COMMENTConstraints
1 <= N <= 10^5
1 <= arr[i] <= 10^6
Sample Input
5
2 4 1 3 5
Sample Output
3
*/

import java.util.*;
import java.io.*;

class countInversion {

    public static void main(String[]args) throws IOException{
        //write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] ar = new int[n];
        String [] tokens = br.readLine().split(" ");
        for(int i = 0;i<n;i++){
            ar[i] = Integer.parseInt(tokens[i]);
        }

        System.out.println(count_inversion(ar));
    }

    static int count = 0;

    public static int count_inversion(int [] arr){
        arr = count_inversion_helper(arr, 0, arr.length-1);
        return count;
    }

    public static int [] count_inversion_helper(int [] ar, int lo, int hi){
        if(lo > hi){
            return new int[0];
        }

        if(lo == hi){
            int [] base = new int[1];
            base[0] = ar[lo];
            return base;
        }

        int mid = lo + (hi-lo)/2;
        int [] left = count_inversion_helper(ar, lo, mid);
        int [] right = count_inversion_helper(ar, mid+1, hi);

        int [] ans = merge_arrays(left, right);
        return ans;
    }

    private static int[] merge_arrays(int[] left, int[] right) {
        int [] merged = new int[left.length+right.length];
        int k = 0;
        int i = 0;
        int j = 0;
        // System.out.println("------------------------------------------------------");
        // display(left);
        // display(right);
        while(i<left.length && j<right.length){
            if(left[i] <= right[j]){
                merged[k] = left[i];
                i++;
                k++;
            }else{
                merged[k] = right[j];
                count += (left.length-i);
                j++;
                k++;
            }
        }

        while(i<left.length){
            merged[k] = left[i];
            i++;
            k++;
        }

        while(j<right.length){
            merged[k] = right[j];
            j++;
            k++;
        }
        // display(merged);    
        // System.out.println("------------------------------------------------------");
        return merged;
    }

    public static void display(int [] ar){
        for(int a:ar){
            System.out.print(a+" ");
        }
        System.out.println();
    }
}