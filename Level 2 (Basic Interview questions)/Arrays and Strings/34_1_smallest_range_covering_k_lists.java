/*abstract
You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.

 

Example 1:

Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
Example 2:

Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
Output: [1,1]
Example 3:

Input: nums = [[10,10],[11,11]]
Output: [10,11]
Example 4:

Input: nums = [[10],[11]]
Output: [10,11]
Example 5:

Input: nums = [[1],[2],[3],[4],[5],[6],[7]]
Output: [1,7]
 

Constraints:

nums.length == k
1 <= k <= 3500
1 <= nums[i].length <= 50
-105 <= nums[i][j] <= 105
nums[i] is sorted in non-decreasing order.
*/

import java.util.*;

class smallest_range_covering_k_lists{
    public static void main(String[] args) {
        
    }
}

class Solution_smallest_range_k_lists {
    public int[] smallestRange(List<List<Integer>> lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<lists.size();i++){
            max = Math.max(max, lists.get(i).get(0));
            pq.add(new Pair(lists.get(i).get(0), i, 0));
        }

        int [] res = new int[]{0, Integer.MAX_VALUE-1};
        int res_len = Integer.MAX_VALUE;
        while(pq.size() == lists.size()){
            Pair curr = pq.poll();
            
            if(max - curr.num + 1 < res_len){
                res[0] = curr.num;
                res[1] = max;

                res_len = res[1] - res[0] + 1;
            }

            if(curr.idx+1 < lists.get(curr.list).size()){
                pq.add(new Pair(lists.get(curr.list).get(curr.idx+1), curr.list, curr.idx+1));
                max = Math.max(max, lists.get(curr.list).get(curr.idx+1));
            }
        }
        return res;
    }
}

class Pair implements Comparable<Pair>{
    int num, list, idx;
    Pair(int n, int l, int i){
        num = n;
        list = l;
        idx = i;
    }
    @Override
    public int compareTo(Pair o) {
        // TODO Auto-generated method stub
        return this.num - o.num;
    }
}