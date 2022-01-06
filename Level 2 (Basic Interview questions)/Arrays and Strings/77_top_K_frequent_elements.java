/*abstract
1.Given a non-empty array of integers.
 2.You have to find the k most frequent elements.
 3.You have to complete the topKFrequent() function which should return the list of k most frequent elements.
Input Format
1.First line contains an integr 'N' denoting the size of the array.
 2.Second line contains 'N' space separated elements
 3.Third line contains an integer 'K'.
Output Format
Return the array list of integer in any order.
Question Video

Constraints
1 <= k <= number of unique elements.
Sample Input
6
1 1 1 2 2 3
2
Sample Output
[1, 2]
*/

import java.util.*;
 
class top_K_frequent_elements {
 
 	 
 	public static ArrayList<Integer> topKFrequent(int n, int[] nums, int k) {
 	    //Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        ArrayList<Integer> keyset = new ArrayList<>();
        return null;
 	}
 
 	//Don't make any changes here.
 	public static void main(String[] args) {
 
 	 	Scanner s = new Scanner(System.in);
 	 	int n = s.nextInt();
 	 	int[] ar = new int[n];
 	 	for (int i = 0; i < ar.length; i++) {
 	 	 	ar[i] = s.nextInt();
 	 	}
 	 	int k = s.nextInt();
 	 	ArrayList<Integer> res = topKFrequent(n, ar, k);
 	 	Collections.sort(res);
 	 	System.out.println(res);
 	}
 
}