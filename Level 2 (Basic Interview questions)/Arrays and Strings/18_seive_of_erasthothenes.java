/*
1. Given an Integer 'n'.
2. Print all primes from 2 to 'n'.
3. Portal is not forced you, but try to submit the problem in less than n.root(n) complexity.
Input Format
n = 10
Output Format
2 3 5 7
Question Video

  COMMENTConstraints
2 <= n <= 10^5
Sample Input
10
Sample Output
2 3 5 7 
*/

import java.util.*;

class seive_of_erasthothenes {
    
    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static void printPrimeUsingSieve(int n) {
        // write your code here
        boolean [] primes = make_seive(n);
        for(int i = 0;i<=n;i++){
            if(primes[i]){
                System.out.print(i+" ");
            }
        }
    }

    public static boolean [] make_seive(int n){
        boolean [] seive = new boolean[n+1];
        Arrays.fill(seive, true);
        seive[0] = false;
        seive[1] = false;

        for(int i = 2;i<=n;i++){
            if(seive[i]){
                long last = 1L*i*i;
                if(last <= n){
                    for(int j = i*i;j<=n;j+=i){
                        seive[j] = false;
                    }
                }
            }
        }

        return seive;
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {   
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPrimeUsingSieve(n);
    }
}