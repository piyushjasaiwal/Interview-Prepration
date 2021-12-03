/*abstract
1: You are given two integer arrays query and nums containing unique elements.
2: Here query is a subset of nums that means all elements of query are also present in nums.
3: Find all the next greater numbers for query's elements in the corresponding places of nums. If it does not exist -1 is answer for this number.
4: You are required to complete the body of the function nextGreaterI(int nums[], int query[]) which returns the answer array containing next greater element's.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1: 1 <= query.length <= nums.length <= 1000
2: 0 <= query[i], nums[i] <= 10^9
3: All integers in query and nums are unique.
4: All the integers of query also appear in nums
Sample Input
4 1 2
1 3 4 2
Sample Output
3
-1
3
-1
*/

import java.io.*;
import java.util.*;

class next_greater_element_one {
    public static int[] nextGreaterElement(int[] nums, int[] query) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        s.add(0);
        int i = 1;
        while(i<nums.length){
            while(!s.empty() && nums[s.peek()]<nums[i]){
                map.put(nums[s.pop()], nums[i]);
            }
            s.push(i);
            i+=1;
        }

        while(!s.empty()){
            map.put(nums[s.pop()], -1);
        }
        
        int [] q_ans = new int[query.length];

        for(i = 0;i<q_ans.length;i++){
            q_ans[i] = map.getOrDefault(query[i], -1);
        }

        return q_ans;
    }

    public static int[] getArr(String s){
        String nums[] = s.split(" ");
        int n = nums.length;
        int ar[] = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = Integer.parseInt(nums[i]);
        }
        return ar;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int query[] = getArr(read.readLine());
        int nums[] = getArr(read.readLine());
        
        int ans[] = nextGreaterElement(nums, query);

        int n = ans.length;

        System.out.println(n);
        for(int e: ans){
            System.out.println(e);
        }
        
    }
}
