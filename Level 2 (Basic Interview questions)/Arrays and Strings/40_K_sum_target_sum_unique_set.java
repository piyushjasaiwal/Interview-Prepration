/*abstract
1. Given an array nums of 'n' integers and a variable 'K'.
2. You have to return an array of all the unique set [nums[a], nums[b], nums[c], nums[d] . . . K Elements] such that: 
    2.1 a, b, c, d . . . K Elements are less than 'n' and greater than 0.
    2.2 a,. b, c, d upto K different indexes are Unique.
    2.3 nums[a] + nums[b] + nums[c] + nums[d] + . . . + nums[K distinct indexes] == target.
3. You can return answer in any order.
Input Format
Input is managed for you.
Output Format
Output is managed for you.
Question Video

  COMMENTConstraints
1. 1 <= nums.length <= 200
2. -10^9 <= nums[i] <= 10^9
3. -10^9 <= target <= 10^9
4. 1 <= K <= nums.length
Sample Input
6
-1 0 1 2 -1 -4
0
3
Sample Output
-1 -1 2 
-1 0 1 
*/

// we will use recursion in this question

import java.util.*;

class K_sum_target_sum_unique_set {

    public static List<List<Integer>> kSum(int[] arr, int target, int k) {
        // write your code here
        return kSumHelper(arr, target, k, 0);
    }

    public static List<List<Integer>> kSumHelper(int [] nums, int target, int k, int si){

        if(k == 2){
            return twoSum(nums, target, si);
        }

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(n-k < 0){
            return ans;
        }

        for(int i = si;i<=n-k;i++){
            if(i == si || nums[i] != nums[i-1]){
                List<List<Integer>> temp = kSumHelper(nums, target-nums[i], k-1, i+1);
                for(List<Integer> list:temp){
                    list.add(0, nums[i]);
                    ans.add(list);
                }
            }
        }

        return ans;
    }

    public static List<List<Integer>> twoSum(int[] nums, int target, int si) {
        
        List<List<Integer>> ans = new ArrayList<>();

        if(nums.length-si < 2){
            return ans;
        }

        int i = si;
        int j = nums.length-1;

        while(i < j){
            if(i != si && nums[i] == nums[i-1]){
                i++;
                continue;
            }

            if(nums[i] + nums[j] == target){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                ans.add(temp);
                i++;
                j--;
            }else if(nums[i] + nums[j] < target){
                i++;  
            }else{
                j--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        int k = scn.nextInt();
        List<List<Integer>> res = kSum(arr, target, k);
        ArrayList<String> finalResult = new ArrayList<>();
        for (List<Integer> list : res) {
        Collections.sort(list);
            String ans = "";
            for (int val : list) {
                ans += val + " ";
            }
            finalResult.add(ans);
        }
        Collections.sort(finalResult);
        for (String str : finalResult) {
            System.out.println(str);
        }
    }

}