import java.util.Scanner;

/*
1. You are given a number x.
2. You are given another number n.
3. You are required to calculate x raised to the power n mod 10^9 + 7 in logn complexity.
Input Format
The first line contains the integer x and n.
Output Format
Output an integer in a line containing x^n mod 10^9+7.
Question Video

  COMMENTConstraints
1 <= x <= 10^9
0 <= n <= 10^9
Sample Input
10 5 
Sample Output
100000
*/

class fast_exponentiation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long x = s.nextInt();
        long y = s.nextInt(); 
        long mod = 1000000007;
        System.out.println(exp(x,y,mod));
    }

    public static long exp(long a, long b, long mod){
        if(b == 1){
            return a%mod;
        }
        if(b == 0){
            return 1%mod;
        }

        if(b%2 == 0){
            long ans = exp(a, b/2, mod);
            ans = ans%mod;
            return (ans*ans)%mod;
        }else{
            long ans = exp(a, b-1, mod);
            ans = ans%mod;
            return (ans*a)%mod;
        }
    }
}
