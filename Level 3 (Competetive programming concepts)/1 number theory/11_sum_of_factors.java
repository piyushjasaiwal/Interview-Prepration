/*
Given a number n, output the summation of all its proper Factors.

Note: A proper Factor of a natural number is the divisor that is strictly less than the number.
Input Format
The first line contains integer t stating number of test cases. 
For next t lines, each line contains an integer n.
Output Format
In each of t lines, print the summation of Factors of the Integer given.
Question Video

  COMMENTConstraints
1<= t <= 10^5
1<= n <= 10^5
Sample Input
3
2
10
20
Sample Output
1
8
22
*/

import java.util.*;

class sum_of_factors {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int sum = 0;
            int n = s.nextInt();
            for(int i = 1;i*i<=n;i++){
                if(n%i == 0){
                    int v1 = i;
                    int v2 = n/i;
                    if(v1 < n){
                        sum += v1;
                    }
                    
                    if(v2 < n && v1 != v2){
                        sum+=v2;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
