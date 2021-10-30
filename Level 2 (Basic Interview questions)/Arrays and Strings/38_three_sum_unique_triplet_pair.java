/*abstract
1. Given an integer array 'nums', and a 'target', return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k.
2. Another thing is nums[i] + nums[j] + nums[k] == target.
3. Notice that the solution set must not contain duplicate triplets.
Input Format
Input is managed for you.
Output Format
Output is managed for you.
Question Video

  COMMENTConstraints
1. 0 <= nums.length <= 3000
2. -10^5 <= nums[i] <= 10^5
Sample Input
6
-1 0 1 2 -1 -4
0
Sample Output
-1 -1 2 
-1 0 1 
*/

import java.util.*;

class three_sum_unique_triplet_pair {

    // ~~~~~~~~~~~~User Section~~~~~~~~~~~~
    public static List<List<Integer>> threeSum(int[] nums, int targ) {
        // write your code here
        Arrays.sort(nums);
        // System.out.println("----------------------------------------");
        // for(int val:nums){
        //     System.out.print(val+" ");
        // }
        // System.out.println("----------------------------------------");
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<nums.length-2;i++){
            if(i == 0 || nums[i] != nums[i-1]){
                int j = i+1;
                int k = nums.length-1;
                int tar = targ - (nums[i]);
                while(j<k){
                    if(nums[j] + nums[k] == tar){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        ans.add(temp);
                        while(j < nums.length && nums[j] == nums[j-1]){
                            j++;
                        }
                        k = k-1;
                        while(k>=0 && nums[k] == nums[k+1]){
                            k--;
                        }
                    }else if(nums[j] + nums[k] < tar){
                        j++;
                    }else{
                        k--;
                    }
                }
            }else{
                continue;
            }
        }

        return ans;
    }

    // ~~~~~~~~~~Input Management~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        List<List<Integer>> res = threeSum(arr, target);
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