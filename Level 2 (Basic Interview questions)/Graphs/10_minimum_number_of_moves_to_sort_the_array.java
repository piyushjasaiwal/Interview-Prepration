/*abstract
Given an array of n distinct elements, find the minimum number of swaps required to sort the array.

Constraints
1 <= n <= 1000000
1 <= arr[i] <= 1000000000

Format
Input
First line contains an integer N . 
Second line has 2 space separated integers ai and bi.

Output
Print in one line the minimum number of swaps required to sort the given array.

Example
Sample Input

5
10 19 6 3 5

Sample Output
2

*/

import java.io.*;
import java.util.*;

class minimum_number_of_moves_to_sort_the_array {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] st = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        System.out.println(minSwaps(arr));
    }

    public static int minSwaps(int[] arr) {
        Pair [] ar = new Pair[arr.length];
        for(int i = 0;i<arr.length;i++){
            ar[i] = new Pair(arr[i], i);
        }

        Arrays.sort(ar);
        boolean [] visited = new boolean[ar.length];

        int cnt = 0;

        for(int i = 0;i<arr.length;i++){
            if(visited[i] || ar[i].idx == i){
                continue;
            }
            
            int clen = 0;
            int j = i;
            while(!visited[j]){
                visited[j] = true;
                clen++;
                j = ar[j].idx;
            }

            cnt+=(clen-1);
        }

        return cnt;
    }

    private static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
}
