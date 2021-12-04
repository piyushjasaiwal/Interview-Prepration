/*abstract
1. You are given an array(arr) of integers and a number K.
2. You have to find the count of distinct numbers in all windows of size k.
Input Format
A number N
arr1
arr2.. N numbers
A number K
Output Format
Space separated numbers representing the count of distinct numbers in all windows of size k.
Question Video

  COMMENTConstraints
1 <= N <= 10^5
1 <= arr[i] <= 10^4
1 <= k <= N
Sample Input
7
1 2 1 3 4 2 3        
4
Sample Output
3 4 4 3 
*/

import java.util.*;

class count_distinct_element_in_every_window_of_size_k {

	public static ArrayList<Integer> solution(int[] arr, int k) {
		//write your code here

		ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<k;i++){
            int val = map.getOrDefault(arr[i], 0);
            map.put(arr[i], val+1);
        }

        for(int i = k;i<arr.length;i++){
            ans.add(map.size());
            int val = map.get(arr[i-k]);
            if(val > 1){
                map.put(arr[i-k], val-1);
            }else{
                map.remove(arr[i-k]);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        ans.add(map.size());

        return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}


}
