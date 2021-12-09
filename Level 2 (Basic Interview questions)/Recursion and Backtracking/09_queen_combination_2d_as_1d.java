/*abstract
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the 
     n * n chess-board. 

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
A number n
Output Format
Check the sample output and question video
Question Video

  COMMENTConstraints
1 <= n <= 5
Sample Input
2
Sample Output
q	q	
-	-	

q	-	
q	-	

q	-	
-	q	

-	q	
q	-	

-	q	
-	q	

-	-	
q	q	
*/

import java.io.*;
import java.util.*;

class queen_combination_2d_as_1d {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        // write your code here
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}