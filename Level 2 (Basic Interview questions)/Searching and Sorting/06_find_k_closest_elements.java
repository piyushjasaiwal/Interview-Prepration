/*abstract
1. Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
2. An integer a is closer to x than an integer b if:
        |a - x| < |b - x|, or
        |a - x| == |b - x| and a < b
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= k <= arr.length
1 <= arr.length <= 10^4
arr is sorted in ascending order.
-10^4 <= arr[i], x <= 10^4
Sample Input
6
10 20 30 40 50 60
3 
45
Sample Output
30 40 50
*/

import java.util.*;
import java.io.*;

class find_k_closest_elements {

    /*find 'k' closest element to 'x' and return answer list*/
    /*elements in answer list should be in ascending order*/
    public static ArrayList<Integer> findClosest(int[]arr,int k,int x) {
        //write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0;i<arr.length;i++){
            pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
            if(pq.size() > k){
                pq.poll();
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            ans.add(curr.val);
        }
        Collections.sort(ans);
        return ans;
    }

    
    private static ArrayList<Integer> findClosest_optimized(int[] arr, int k, int x) {

        ArrayList<Integer> ans = new ArrayList<>();
        int lo = 0;
        int hi = arr.length-1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] < x){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }

        int left = hi;
        int right = lo;
        while(k > 0 && (left>=0 || right>= arr.length)){
            if(left < 0){
                ans.add(arr[right]);
                k--;
                right++;
            }else if(right >= arr.length){
                ans.add(arr[left]);
                k--;
                left--;
            }else{
                 if(Math.abs(arr[left] - x) > Math.abs(arr[right] - x)){
                    ans.add(arr[right]);
                    k--;
                    right++;
                }else{
                    ans.add(arr[left]);
                    k--;
                    left--;
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[]args) {

        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        int x = scn.nextInt();

        ArrayList<Integer>ans = findClosest_optimized(arr,k,x);

        for(int val : ans) {
            System.out.print(val + " ");
        }

    }

    static class Pair implements Comparable<Pair>{
        int val;
        int gap;
        Pair(int v, int g){
            val = v;
            gap = g;
        }
        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            if(o.gap != gap){
                return o.gap - gap;
            }else{
                return o.val - val;
            }
        }


    }
}