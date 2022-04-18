/*abstract
1. Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
2. Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
3. Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
4. Return the minimum integer k such that she can eat all the bananas within h hours.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= piles.length <= 10^4
piles.length <= h <= 10^9
1 <= piles[i] <= 10^9
Sample Input
4
3 6 7 11
8
Sample Output
4
*/

import java.util.*;
import java.io.*;

class koko_eating_bananas {
    public static int minEatingSpeed(int[]piles,int h) {
        //write your code here
        long lo = 1;
        long hi = 0;
        for(int pile:piles){
            hi = Math.max(hi, pile);
        }

        long ans = Long.MAX_VALUE;

        while(lo <= hi){
            long mid = (lo+hi)/2;
            // System.out.println(mid);
            // System.out.println(isPossible(piles, h, mid));
            if(isPossible(piles, h, mid)){
                hi = mid-1;
                ans = Math.min(ans, mid);
            }else{
                lo = mid+1;
            }
        }
        return (int)(ans);
    }

    private static boolean isPossible(int[] piles, int h, long mid) {
        int cnt = 0;
        for(int pile:piles){
            cnt += Math.ceil((pile*1.0)/mid);
        }
        return h >= cnt;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]piles = new int[n];

        for(int i=0 ; i < n ; i++) {
            piles[i] = scn.nextInt();
        }

        int h = scn.nextInt();

        int speed = minEatingSpeed(piles,h);
        System.out.println(speed);
    }
}