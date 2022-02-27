/*abstract
1. You are given a string.
2. You have to print the count of distinct and non-empty subsequences of the given string. 

Note -> String contains only lowercase letters.

Constraints
1 <= length of string <= 60

Format
Input
A String

Output
A number

Example
Sample Input

abc

Sample Output
7
*/

import java.util.*;

class count_distinct_subsequences{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        //write your code here

        HashMap<Character, Integer> lastOccurance = new HashMap<>();
        
        int [] dp = new int[str.length()+1];
        dp[0] = 1;
        for(int i = 1;i<=str.length();i++){
            char ch = str.charAt(i-1);

            dp[i] = dp[i-1]*2;
            if(lastOccurance.containsKey(ch)){
                int lo = lastOccurance.get(ch);
                dp[i] -= dp[lo-1];
            }

            lastOccurance.put(ch, i);
        }

        System.out.println(dp[str.length()]-1);
    }
}