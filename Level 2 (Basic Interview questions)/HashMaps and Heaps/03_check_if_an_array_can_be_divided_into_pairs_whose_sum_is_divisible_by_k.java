/*abstract
1. You are given an array(arr) of integers and a number K.
2. You have to find if the given array can be divided into pairs such that the sum of every pair is divisible by k.
Input Format
A number N
arr1
arr2.. N numbers
A number K
Output Format
true or false.
Question Video

  COMMENTConstraints
1 <= N <= 10^6
1 <= arr[i] <= 10^4
1 <= K <= 10^4
Sample Input
4
9 7 5 3
6
Sample Output
true
*/

import java.util.*;

class check_if_an_array_can_be_divided_into_pairs_whose_sum_is_divisible_by_k {
	
	public static void solution(int[] arr, int k){
		//write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            int rem = arr[i]%k;
            int req = (k - rem)%k;

            if(map.containsKey(req)){
                int val = map.get(req);
                if(val > 1){
                    map.put(req, val-1);
                }else{
                    map.remove(req);
                }
            }else{
                map.put(rem, 1);
            }
            // System.out.print(arr[i]+" ");
            // System.out.println(map);
        }
        
        System.out.println(map.size() == 0);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr,k);
	}

}
