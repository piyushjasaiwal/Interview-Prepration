/*
1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
3. You are required to calculate and print the count of encodings for the string str.

     For 123 -> there are 3 encodings. abc, aw, lc
     For 993 -> there is 1 encoding. iic 
     For 013 -> This is an invalid input. A string starting with 0 will not be passed.
     For 103 -> there is 1 encoding. jc
     For 303 -> there are 0 encodings. But such a string maybe passed. In this case 
     print 0.
Input Format
A string str
Output Format
count of encodings
Question Video

  COMMENTConstraints
0 < str.length <= 10
Sample Input
123
Sample Output
3
*/
import java.util.*;
class count_encodings {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        if(invalid(str)){
            System.out.println(0);
        }else{
            int [] dp = new int[str.length()];
            dp[0] = 1;
            
            if(str.length() >= 2){
                if(Integer.parseInt(str.substring(0, 2))<=26){
                    dp[1] = 2;
                }else{
                    dp[1] = 1;
                }
            }
    
            for(int i = 2;i<str.length();i++){
                int ans = 0;
                if(Integer.parseInt(str.substring(i, i+1))<=26){
                    ans += dp[i-1];
                }
    
                if(Integer.parseInt(str.substring(i-1, i+1))<=26){
                    ans += dp[i-2];
                }
                dp[i] = ans;
            }
            System.out.println(dp[str.length()-1]);
        }
    }

    private static boolean invalid(String str) {
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == '0'){
                return true;
            }
        }
        return false;
    }
}
