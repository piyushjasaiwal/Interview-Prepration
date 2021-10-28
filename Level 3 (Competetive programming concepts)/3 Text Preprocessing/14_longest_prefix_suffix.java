/*Given a string S, print the longest Prefix which is also a suffix.
Try doing it using constant space.
Input Format
A string S
Output Format
Print the answer, print "" (without quotes) if no answer found.
Question Video

  COMMENTConstraints
2 <= |S| <= 10^5
Sample Input
abcab
Sample Output
ab*/

import java.util.*;

class longest_prefix_suffix {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    // Write Code here
    String str = scn.next();
    int prev = 0;
    
    // we will use rabin karp algorithm
    int prime = 31;
    long ph = 0;
    long sh = 0;
    long mod = 1000000007;
    int ans = -1;
    long pow = 1;
    
    for(int i = 0;i<str.length()-1;i++){
        ph = (((ph*prime)%mod) + (str.charAt(i)-'a'+1))%mod;
        sh = (sh + ((str.charAt(str.length()-i-1)-'a'+1)*pow))%mod;

        pow = (pow*prime)%mod;

        if(ph == sh){
            ans = i+1;
        }
    }

    if(ans <= 0){
        System.out.println("");
    }else{
        System.out.println(str.substring(0, ans));
    }

    scn.close();
  }
}