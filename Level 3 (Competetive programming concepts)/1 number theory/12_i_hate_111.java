/*
here we can use chicken mcnugget theoram, which states that for any two numbers a and b, the largest number you cannot form by the additin of some a's and some b's = 

(a*b) - a -b
/*
You are given an integer x. Can you make x by summing up some number of 11,111,1111,11111,..?(You can use any number among them any number of times)
Input Format
The first line contains an integer T, number of test cases.
The next t lines contain an integer a.
Output Format
For each test case print "YES" or "NO".
Question Video

  COMMENTConstraints
1 <= t <= 10000
1 <= x <= 10^9
Sample Input
3
33
144
69
Sample Output
YES
YES
NO
*/

import java.util.*;

class i_hate_111 {
    public static void main(String[] args) {
        // the only two useful numbers are 11 and 111 other can be made up using 11 and 111
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            long n = s.nextLong();
            long a = n%11;
            if(n >= 111*a){
                if((n-(111*a))%11 == 0){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }else{
                System.out.println("NO");
            }
        }
    }
}
