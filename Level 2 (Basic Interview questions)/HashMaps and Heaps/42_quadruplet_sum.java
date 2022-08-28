/*
 * 1. You are given an array(arr) of N integers and an integer X.
2. You have to find all unique quadruplets(a,b,c,d) which satisfies this condition - 
   a+b+c+d = X.
Input Format
A number N
arr1
arr2.. N numbers
A number X
Output Format
Every line of output contains four integers which represent a quadruplet having sum X.
Question Video

  COMMENTConstraints
1 <= N <= 200
-10^3 <= arr[i] <= 10^3
-10^9 <= X <= 10^9
Sample Input
6
1 0 -1 0 -2 2
0
Sample Output
-2 -1 1 2 
-2 0 0 2 
-1 0 0 1 
 */

import java.util.*;

class quadruplet_sum {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target, int n) {
		// write your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>(); 
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                for(int k = j+1;k<nums.length;k++){
                    int val =  target- (nums[i]+nums[j]+nums[k]);
                    // System.out.println(val+" "+nums[i]+" " + nums[j]+" " +nums[k]);
                    if(map.containsKey(val)){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(val);
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        ans.add(temp);
                    }
                }
            }
            map.put(nums[i], i);
        }
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		ArrayList<ArrayList<Integer>> ans = fourSum(arr, target, n);
		Collections.sort(ans,(a,b)->{
            int i = 0;
            int j = 0;
            
            while(i < a.size()){
                if(a.get(i) == b.get(j)){
                    i++;
                    j++;
                }else{
                    return a.get(i) - b.get(j);
                }
            }
            
            return 0;
        }); 
		for (ArrayList<Integer> a : ans) {
			for (int element : a) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

}
