/*
1. Given an Array of size 'n' have may or may not be repeated elements.
2. A 'target' is provided.
3. Return Pair of target sum in which all pairs are unique, for example : [1, 2], [2, 1] are consider as same pair.
4. If array have repeated element then return only unique pair, for example : if array is arr = [2, 2, 4, 4], and target = 6 then res have only one pair, i.e. [2, 4]
Input Format
Input is managed for you.
Output Format
Output is managed for you.
Question Video

  COMMENTConstraints
1. 2 <= n < 10000
2. -10^9 < arr[i] < 10^9
3. pair[0] + pair[1] < 10^9
Sample Input
6
10 10 30 40 50 20
60
Sample Output
10 50 
20 40 
*/

import java.util.*;

class two_sum_target_sum_unique_pairs {

  // ~~~~~~~~~~~~User Section~~~~~~~~~~~~
    public static List<List<Integer>> twoSum(int[] arr, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length-1;

        while(i < j){
            while(i != 0  && i < arr.length && arr[i] == arr[i-1]){
                i++;
            }

            while(j != arr.length - 1 && j >= 0 && arr[j] == arr[j+1] && j >= 0){
                j--;
            }

            if(arr[i] + arr[j] == target){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[j]);
                ans.add(temp);
                i++;
                j--;
            }else if(arr[i] + arr[j] < target){
                i++;
            }else{
                j--;
            }
        }

        return ans;
    }

  // ~~~~~~~~~~Input Management~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        List<List<Integer>> res = twoSum(arr, target);
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