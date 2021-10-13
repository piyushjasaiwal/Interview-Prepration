import java.util.Scanner;

/*
wilson theoram states that for every prime number n this holds true
(n-1)! is congruent to (n-1)%n

or 

(n-1)!%n = n-1

over here the ans will be 

ans = ((p-1)*((n+1)^(p-2))*((n+2)^(p-2))*.................*((p-1)^(p-2)))%p;
*/


/*
you have been given number n and p, you need to find n! % p (n factorial mod p). p is a prime no.
Input Format
The first line contains the integer n and p. 
Output Format
Output an integer in a line containing n! modulo P.
Question Video

  COMMENTConstraints
1<= n <= 10^9
1<= p <= 10^9
1<= abs(n - p) <= 1000
Sample Input
5 11
Sample Output
10
*/

class wilson_theoram {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long p = s.nextLong();

        if(n >= p){
            System.out.println(0);
        }else{
            long ans = (p-1)%p;
            for(long i = n+1;i<=p-1;i++){
                ans = (ans*(pow(i, p-2, p)%p))%p;
            }
            System.out.println(ans);
        }
    }

    private static long pow(long a, long b, long mod) {
        if(b == 0){
            return 1%mod;
        }

        if(a == 0){
            return a%mod;
        }

        if(b%2 == 0){
            long ans = pow(a, b/2, mod);
            ans = ans%mod;
            return (ans*ans)%mod;
        }else{
            long ans = pow(a, b-1, mod);
            ans = ans%mod;
            return (ans*a)%mod;
        }
    }
}
