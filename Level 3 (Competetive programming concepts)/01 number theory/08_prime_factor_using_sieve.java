/*
you have T numbers and for each number N you want to print all of it's prime factors.

Expected complexity : 0(logn) for each query. You can do linear time preprocessing.
Input Format
The first line contains integer T (number of queries).
Next t lines contain integer n.
Output Format
for each number n print all of it's prime factors.
Question Video

  COMMENTConstraints
1<= T <= 10000
1<= n <= 100000
Sample Input
5
10
15
23
93
39
Sample Output
2 5 
3 5 
23 
3 31 
3 13 
*/

import java.util.*;

class prime_factor_using_sieve {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean [] sieve = new boolean[100001];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;

        for(int i = 0;i<=100000;i++){
            if(sieve[i]){
                long a = i;
                long pp = a*a;
                if(pp <= 100000){
                    for(int j = i*i;j<=100000;j+=i){
                        sieve[j] = false;
                    }
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 2;i<=100000;i++){
            if(sieve[i]){
                primes.add(i);
            }
        }
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int copy = n;
            for(int val:primes){
                if(val > n){
                    break;
                }
                while(copy%val == 0 && copy > 0){
                    System.out.print(val+" ");
                    copy = copy/val;
                }
            }
            System.out.println();
        }
    }
}
