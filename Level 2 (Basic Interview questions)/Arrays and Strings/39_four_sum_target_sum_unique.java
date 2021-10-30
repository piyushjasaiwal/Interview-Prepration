/*abstract
1. Given an array nums of 'n' integers.
2. You have to return an array of all the unique quadruple [nums[a], nums[b], nums[c], nums[d]] such that: 
    2.1 a, b, c, and d are less than 'n' and greater than 0
    2.2 a,. b, c, and d are Unique.
    2.3 nums[a] + nums[b] + nums[c] + nums[d] == target.
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
Sample Input
6
1 0 -1 0 -2 2
0
Sample Output
-1 0 0 1 
-2 -1 1 2 
-2 0 0 2 
*/

import java.util.*;

class four_sum_target_sum_unique {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-3;i++){
            if(i == 0 || nums[i] != nums[i-1]){
                for(int j = i+1;j<nums.length-2;j++){
                    if(j == i+1 || nums[j] != nums[j-1]){
                        int k = j+1;
                        int l = nums.length-1;
                        while(k < l){
                            if(nums[i] + nums[j] + nums[k] + nums[l] == target){
                                List<Integer> temp = new ArrayList<>();
                                temp.add(nums[i]);
                                temp.add(nums[j]);
                                temp.add(nums[k]);
                                temp.add(nums[l]);
                                ans.add(temp);

                                while(k<nums.length && nums[k] == nums[k-1]){
                                    k++;
                                }

                                l--;
                                while(l>0 && nums[l] == nums[l+1]){
                                    l--;
                                }
                            }else if(nums[i] + nums[j] + nums[k] + nums[l] < target){
                                k++;
                            }else{
                                l--;
                            }
                        }
                    }
                }
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
        List<List<Integer>> res = fourSum(arr, target);
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