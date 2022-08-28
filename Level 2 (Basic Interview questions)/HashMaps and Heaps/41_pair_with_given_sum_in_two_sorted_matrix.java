/*
 * 1. You are given a number N and two sorted matrices(A and B) of N*N dimensions.
2. You are also given a number X.
3. You have to find the count of all valid pairs from matrices whose sum is equal to X.
4. A pair is called valid if one element of the pair is selected from A and the second element is selected from B.
Input Format
A number N
A1
A2.. N*N numbers
B1
B2.. N*N numbers
Output Format
A number representing the count of all valid pairs.
Question Video

  COMMENTConstraints
1 <= N <= 10^3
-10^3 <= elements of matrices <= 10^3
Sample Input
3
1 5 6
8 10 11
15 16 18
2 4 7
9 10 12
13 16 20
21
Sample Output
4
 */

import java.util.*;

class pair_with_given_sum_in_two_sorted_matrix {
	
    public static int solve(int[][] num1, int[][] num2, int k) {
		// write your code here
		int cnt = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int []ar:num1){
			for(int a:ar){
				map.put(a, map.getOrDefault(a, 0)+1);
			}
		}

		for(int [] ar : num2){
			for(int a : ar){
				if(map.containsKey(k-a)){
					cnt+=map.get(k-a);
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] mat1 = new int[N][N];
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[0].length; j++) {
				mat1[i][j] = sc.nextInt();
			}
		}

		int[][] mat2 = new int[N][N];
		for (int i = 0; i < mat2.length; i++) {
			for (int j = 0; j < mat2[0].length; j++) {
				mat2[i][j] = sc.nextInt();
			}
		}
		int K = sc.nextInt();
		System.out.println(solve(mat1, mat2, K));

	}

}
