/*
1. Given an array arr of integers (not necessarily distinct).
2. We split the array into some number of "chunks" (partitions), and individually sort each chunk.  
3. After concatenating them, the result equals the sorted array.
4. What is the most number of chunks we could have made?
Input Format
arr = [2,1,3,4,4]
Output Format
4
Explanation:
We can split into two chunks, such as [2, 1], [3, 4, 4].
However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
Question Video

  COMMENTConstraints
1. arr will have length in range [1, 2000].
2. arr[i] will be an integer in range [0, 10^8].
Sample Input
8
4 3 6 5 7 12 11 10
Sample Output
4
*/

import java.util.*;

class max_chunks_to_make_sorted_two {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted2(int[] arr) {
        // write your code here
        int [] ar = new int[arr.length];
        int idx = 0;
        for(int val:arr)
        {
            ar[idx++] = val;
        }

        Arrays.sort(ar);
        int right = 0;
        int cnt = 0;
        for(idx = 0;idx<arr.length;idx++){
            int find_idx = b_search(ar, arr[idx]);
            right = Math.max(find_idx, right);
            if(right == idx){
                cnt+=1;
            }
        }
        
        return cnt;

    }

    private static int b_search(int[] ar, int ele) {
        int lo = 0;
        int hi = ar.length-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(ar[mid] == ele){
                return mid;
            }else if(ar[mid] > ele){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return -1;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}