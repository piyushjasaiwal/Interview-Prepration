/*
1. Given an array arr that is a permutation of [0, 1, ..., arr.length - 1].
2. We split the array into some number of "chunks" (partitions), and individually sort each chunk. 
3. Shuffling of chunk is not allowed.
4. After concatenating them, the result equals the sorted array.
5. What is the most number of chunks we could have made?
Input Format
arr = [4,3,2,1,0]
Output Format
1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
Question Video

  COMMENTConstraints
1. arr will have length in range [1, 10].
2. arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
Sample Input
6
2 0 1 3 5 4
Sample Output
3
*/

import java.util.*;

class max_chunks_to_make_array_sorted {
    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted(int[] arr) {
        // write your code here
        int left = 0;
        int right = 0;
        
        int cnt = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] > right){
                right = arr[i];
            }else if(arr[i] < left){
                left = arr[i];
            }

            if(i == right){
                cnt += 1;
                right = i+1;
                left = i+1;
            }
        }

        return cnt;
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted(arr);
        System.out.println(res);
    }
}
