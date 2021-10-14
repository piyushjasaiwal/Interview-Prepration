/*
you have been given a number n, count the number of integers between 1 to n inclusive, which are co-prime to n.
Input Format
The first line contains the integer n. 
Output Format
Output an integer in a line.
Question Video

  COMMENTConstraints
1 <= n <= 10^9
Sample Input
7
Sample Output
6
*/

import java.util.*;

class eular_totient_function {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextInt();
        long ans = n;
        for(int i = 2;i*i<=n;i++){
          if(n%i == 0){
            ans = ans - ans/i;

            while(n%i == 0){
              n = n/i;
            }
          }
        }

        if(n>1){
          ans = ans - ans/n;
        }
        System.out.println(ans);
    }
}
