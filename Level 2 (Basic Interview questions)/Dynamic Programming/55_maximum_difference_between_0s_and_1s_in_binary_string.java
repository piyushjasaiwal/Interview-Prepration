/*abstract
1. You are given a string containing only 0's and 1's.
2. You have to find the length of substring which is having maximum difference of number of 0s and number of 1s i.e (Number of 0's - Number of 1's).
3. If there are all 1's present in the given string, then print '-1'.
Input Format
A Binary String
Output Format
A number 
Question Video

  COMMENTConstraints
1 <= length of string <= 10^5
Sample Input
11000010001
Sample Output
6
*/


/*
solution 
replace 1 with -1
replace 0 with 1

apply kadanes algorithm
you will get your answer
*/

import java.io.*;
import java.util.*;

class maximum_difference_between_0s_and_1s_in_binary_string {

	public static int solution(String str) {
		// write your code here
        // boolean flag = true;
        // for(int i = 0;i<str.length();i++){
        //     if(str.charAt(i) == '0'){
        //         flag = false;
        //     }
        // }

        // if(flag){
        //     return -1;
        // }

        int ans = -1;
        int mssf = 0;

        for(int i = 0;i<str.length();i++){
            int val = (str.charAt(i) == '0') ? 1 : -1;

            mssf = Math.max(mssf+val, val);
            ans = Math.max(ans, mssf);
        }

		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String string = scn.next();
		System.out.println(solution(string));
	}

}