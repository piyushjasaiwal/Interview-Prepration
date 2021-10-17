/*
You have an array with n elements. you have to create all subsequences of this array with length K. For each subsequence, you have to write down the product of k-2 integers, all elements of this sequence except the minimum and maximum element.
your work will be considered done if you will be able to write down all these numbers and tell PepBoss their product mod 10^9+7.
Input Format
The first line contains integer N (length of array) and K.
The second line contains N space separated integers.
Output Format
Print a single line containing one integer - the product of all numbers written down by you modulo 10^9+7.
Question Video

  COMMENTConstraints
1<= N <= 5000
3 <= K <= N
1 <= arr[i] <= 10000
Sample Input
4 3 
1 2 3 4
Sample Output
36
*/

import java.util.*;

class no_max_no_min {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    
        int n = scn.nextInt();
        int k = scn.nextInt();
    
        long[] arr = new long[n];
        for (int z = 0; z < n; z++) {
            arr[z] = scn.nextInt();
        }

        arr = sort(arr);
        long mod_1 = 1000000006; 
        long mod_2 = 1000000007;
        long [][] ncr = ncr_function(n, n, mod_1);

        long [] valid_arr = new long[n];
        long total = ncr[n-1][k-1];

        for(int i = 1;i<=n/2;i++){
            long min_count = 0;
            long max_count = 0;

            if(i > k){
                max_count = ncr[i][k-1];
            }

            if(i+k <= arr.length){
                min_count = ncr[n-i-1][k-1];
            }

            long valid = (total - max_count + mod_1)%mod_1;
            valid = (total - min_count + mod_1)%mod_1;

            valid_arr[i] = valid;
            valid_arr[n-i-1] = valid;
        }

        long ans = 1;
        for(int i = 1;i<valid_arr.length-1;i++){
            System.out.println(ans);
            long curr_ans = bin_expo(arr[i], valid_arr[i]%mod_1, mod_2)%mod_2;
            ans = (ans*curr_ans)%mod_2;
        }
        System.out.println(ans);
    }
 
    public static long[] sort(long []ar){
        ArrayList<Long> list = new ArrayList<>();
        for(long val:ar){
            list.add(val);
        }
        Collections.sort(list);
        for(int i = 0;i<ar.length;i++){
            ar[i] = list.get(i);
        }
        return ar;
    }

    public static long [][] ncr_function(int n, int r, long mod){
        long [][] dp = new long[n+1][n+1];
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=i;j++){
                if(i == j ||  j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = (dp[i-1][j]+dp[i-1][j-1])%mod;
                }
            }
        }

        for(long [] dd:dp){
            for(long d:dd){
                System.out.print(d+" ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------------");
        return dp;

    }

    public static long bin_expo(long a, long b, long mod){
        if(b == 0){
            return 1L;
        }

        if(b == 1){
            return a%mod;
        }

        if(b%2 == 0){
            long y = bin_expo(a, b/2, mod);
            return ((y%mod)*(y%mod))%mod;
        }else{
            long y = bin_expo(a, b-1, mod);
            return ((y%mod)*(a%mod))%mod;
        }
    }
}
