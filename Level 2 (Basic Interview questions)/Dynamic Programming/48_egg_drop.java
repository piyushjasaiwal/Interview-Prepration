/*abstract
1. You are given two integers N and K. N represents the number of eggs and K represents the number of floors in a building.
2. You have to find the minimum number of attempts you need in order to find the critical floor in the worst case while using the best strategy.
3. The critical floor is defined as the lowest floor from which you drop an egg and it doesn't break. 
4. There are certain which you have to follow -
   a. All eggs are identical.
   b. An egg that survives a fall can be used again.
   c. A broken egg can't be used again.
   d. If the egg doesn't break at a certain floor, it will not break at any floor below.
   e. If the egg breaks at a certain floor, it will break at any floor above.
Input Format
Two integers N and K
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= N <= 100
1 <= k <= 50
Sample Input
3
10
Sample Output
4
*/

import java.io.*;
import java.util.*;

class egg_drop {

	public static int eggDrop(int eggs, int floors){
		//write your code here
        int [][] dp = new int[eggs+1][floors+1];

        for(int e = 0;e<=eggs;e++){
            for(int f = 0;f<=floors;f++){
                if(e == 0){
                    continue;
                }else if(e == 1){
                    dp[e][f] = f;
                }else if(f == 0){
                    dp[e][f] = 0;
                }else if(f == 1){
                    dp[e][f] = 1;
                }else{
                    int min = Integer.MAX_VALUE;
                    int up = 0, down = f-1;
                    while(down >= 0){
                        min = Math.min(min, Math.max(dp[e-1][up], dp[e][down]));
                        down--;
                        up++;
                    }

                    dp[e][f] = min+1;
                }
            }
        }

        // for(int [] d :dp){
        //     for(int val:d){
        //         System.out.print(val+" ");
        //     }
        //     System.out.println();
        // }

		return dp[eggs][floors];
	} 

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//n -> number of eggs and k -> number of floors
		int n = scn.nextInt();
		int k = scn.nextInt();
		System.out.println(eggDrop(n,k));
	}
	
}