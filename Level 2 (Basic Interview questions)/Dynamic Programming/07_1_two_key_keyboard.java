/*abstract
1. You are given a number N.
2. You have to print exactly N number of 'X' on a notepad by performing the minimum number of operations.
3. Operations allowed are - 
   copyAll -> You can copy all the characters present on the notepad.
   Paste -> You can paste the last copied characters.
4. You have to find the minimum number of operations to get N 'X'.

Note -> Initially, one 'X' is present on the screen.
Input Format
A number
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= N <= 1000
Sample Input
3
Sample Output
3
*/

import java.io.*;
import java.util.*;

class two_key_keyboard {

	public static int solution(int n) {
		//write your code here
		int [] dp = new int[n+1];
        dp[1] = 0;

        for(int i = 2;i<=n;i++){
            int great = greatest_divisor(i);
            if(great == 1){
                dp[i] = i;
            }else{
                int rem = i/great;
                dp[i] = dp[great]+rem;
            }
        }
        // int i = 0;
        // for(int val:dp){
        //     System.out.println(i+" "+val);
        //     i+=1;
        // }
        // System.out.println();
		return dp[n];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

    public static int greatest_divisor(int n){
        int great = 1;
        for(int i = 1;i<n;i++){
            if(n%i == 0){
                great = i;
            }
        }
        return great;
    }

}