/*abstract
1. You are given a boolean expression with symbols T,F, and operators &,|,^ , where
   T represents True
   F represents False
   & represents boolean AND
   | represents boolean OR
   ^ represents boolean XOR.
2. You have to find the number of ways in which the expression can be parenthesized so that the value of expression evaluates to true.
Input Format
Two strings s1 and s2
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
2 <= length of s1 <= 100
1 <= length of s2 <= 99
Sample Input
TFT
^&
Sample Output
2
*/

import java.util.*;

class boolean_parenthization {
	
	static class Pair{
		int ct;
		int cf;
		Pair(){
			this(0, 0);
		}
		public Pair(int t, int f) {
			ct = t;
			cf = f;
		}
	}
    public static int solution(String str1, String str2) {
		//write your code here
		int n = str1.length();
		int m = str2.length();

		Pair [][] dp = new Pair[n][n];
		for(Pair [] d:dp){
			Arrays.fill(d, new Pair());
		}
		for(int gap = 0;gap<n;gap++){
			int i = 0;
			int j = gap;
			while(j < n){
				if(gap == 0){
					if(str1.charAt(i) == 'T'){
						dp[i][j].ct = 1;
					}else{
						dp[i][j].cf = 1;
					}
				}else if(gap == 1){
					if(str2.charAt(i) == '&'){
						if(str1.charAt(i) == 'T' && str1.charAt(j) == 'T'){
							dp[i][j].ct = 1;
						}else{
							dp[i][j].cf = 1;
						}
					}else if(str2.charAt(i) == '|'){
						if(str1.charAt(i) == 'T' || str1.charAt(j) == 'T'){
							dp[i][j].ct = 1;
						}else{
							dp[i][j].cf = 1;
						}
					}else{
						if(str1.charAt(i) == 'T' || str1.charAt(j) == 'F'){
							dp[i][j].ct = 1;
						}else if(str1.charAt(i) == 'F' || str1.charAt(j) == 'T'){
							dp[i][j].ct = 1;
						}else{
							dp[i][j].cf = 1;
						}
					}
				}else{
					int ans_t = 0;
					int ans_f = 0;
					int k = i+1;
					while(k<j){
						//for true
						if(str2.charAt(k) == '&'){
							ans_t += (dp[i][k].ct*dp[k][j].ct);
						}else if(str2.charAt(k) == '|'){
							ans_t += (dp[i][k].ct*dp[k][j].ct);
							ans_t += (dp[i][k].ct*dp[k][j].cf);
							ans_t += (dp[i][k].cf*dp[k][j].ct);
						}else{
							ans_t += (dp[i][k].ct*dp[k][j].cf);
							ans_t += (dp[i][k].cf*dp[k][j].ct);
						}

						//for false;
						if(str2.charAt(k) == '&'){
							ans_f += (dp[i][k].cf*dp[k][j].cf);
							ans_f += (dp[i][k].ct*dp[k][j].cf);
							ans_f += (dp[i][k].cf*dp[k][j].ct);
						}else if(str2.charAt(k) == '|'){
							ans_f += (dp[i][k].cf*dp[k][j].cf);
						}else{
							ans_f += (dp[i][k].ct*dp[k][j].ct);
							ans_f += (dp[i][k].cf*dp[k][j].cf);
						}

						k++;
					}
					dp[i][j].ct = ans_t;
					dp[i][j].cf = ans_f;
				}
				i++;
				j++;
			}
		}
		for(Pair [] d:dp){
			for(Pair pair:d){
				System.out.print("{"+pair.ct+", "+pair.cf+"} ");
			}
			System.out.println();
		}
		return dp[0][n-1].ct;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1, s2));
	}
}


