/*
Given t test cases and in each test case you have a positive integer n, we have to find the total number of divisors for n.
Input Format
The first line of input contains integer t.
The next t lines of the input contains integer n.
Output Format
Print number of divisors in a line for each test case.
Question Video

  COMMENTConstraints
1 <= t <= 1000
1 <= n <= 10^5
Sample Input
10
21
22
23
24
25
26
27
28
29
30
Sample Output
4
4
2
8
3
4
4
6
2
8
*/


import java.util.*;
import java.io.*;

class all_factors_using_sieve {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int cnt = 0;
            for(int i = 1;i*i<=n;i++){
                if(n%i == 0){
                    if(n/i != i){
                        cnt+=2;
                    }else{
                        cnt+=1;
                    }
                }
            }
            System.out.println(cnt);
        }     
    }
}
