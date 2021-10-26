/*
Your task is so simple given a string and a pattern. You find the pattern on the given string. If found print how many time found the pattern and their index. Otherwise print ‘Not Found’

Input:          

The input   line consists of a number T (1 ≤ T ≤ 50) test cases.

For each case given two string number  A,B. the string and the pattern  1 ≤|A|, |B| ≤10^6

All character will be lower case Latin character.  And |  | is the length of string.

Output:

For each case print the number  (found pattern from the given string) next line there position And Otherwise print 'Not Found' without quota.
There will a blank line between two cases.

input
3
ababab ab
aaaaa bbb
aafafaasf aaf

output
3
1 3 5

Not Found

1
1
*/

import java.util.*;

class rabin_karp {

    public static long hashCode(String s, int start, int end) {
        //Write your code here
        // NOTE: use prime number = 31 and mod = 1000000007
        long sum = 0;
        long prod = 1;
        long mod = 1000000007;
        for(int i = start;i<end;i++){
            sum = (sum + (prod *(s.charAt(i)-'a' + 1))%mod)%mod;
            prod = (prod*31)%mod;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            String s1 = s.next();
            String s2 = s.next();

            long hash = hashCode(s2, 0, s2.length());
            int cnt = 0;
            StringBuilder sb = new StringBuilder("");
            for(int i = 0;i<=s1.length()-s2.length();i++){
                if(hashCode(s1, i, i+s2.length()) == hash && isEqual(s1, s2, i, i+s2.length())){
                    cnt++;
                    sb.append((i+1)+" ");
                }
            }

            if(cnt > 0){
                System.out.println(cnt);
                System.out.println(sb);
            }else{
                System.out.println("Not Found");
            }
            System.out.println();
        }
    }

    private static boolean isEqual(String s1, String s2, int start, int end) {
        for(int i = 0;i<s2.length();i++){
            if(s1.charAt(start+i) != s2.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
