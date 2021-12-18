/*
Given two integer numbers, your task is to find count of all common divisors of given numbers
Input Format
The first line contains an integer T, number of test cases.
The next t lines contain two numbers a and b each.
Output Format
Print number of common divisors in next t lines.
Question Video

COMMENTConstraints
1<= t <= 10^5
1<= a, b <= 10^5
Sample Input
3
100000 100000
12 24
747794 238336
Sample Output
36
6
2
*/

import java.util.*;

class count_of_common_divisor {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int a = s.nextInt();
            int b = s.nextInt();

            int cnt = 0;

            for(int i = 1;i*i<=a;i++){
                if(a%i == 0){
                    int v1 = a/i;
                    int v2 = i;

                    if(b%v1 == 0){
                        cnt+=1;
                    }

                    if(v1 != v2){
                        if(b%v2 == 0){
                            cnt+=1;
                        }
                    }
                }
            }

            System.out.println(cnt);
        }
    }   
}
