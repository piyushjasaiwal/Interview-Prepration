/*
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the permutations in which n queens can be placed on the 
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
q1	q2	
-	-	

q1	-	
q2	-	

q1	-	
-	q2	

q2	q1	
-	-	

-	q1	
q2	-	

-	q1	
-	q2	

q2	-	
q1	-	

-	q2	
q1	-	

-	-	
q1	q2	

q2	-	
-	q1	

-	q2	
-	q1	

-	-	
q2	q1	
*/

import java.io.*;

class queen_permutation_2d_as_queen_chooses{
    public static void queensPermutations(int qpsf, int tq, int[][] chess){
        // write your code here
        if(qpsf == tq){
            for(int i = 0;i<chess.length;i++){
                for(int j = 0;j<chess[0].length;j++){
                    if(chess[i][j] == 0){
                        System.out.print("-\t");
                    }else{
                        System.out.print("q" + chess[i][j] + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return ;
        }

        for(int i = 0;i<chess.length;i++){
            for(int j = 0;j<chess[0].length;j++){
                if(chess[i][j] == 0){
                    for(int k = qpsf+1 ;k<=tq;k++){
                        chess[i][j] = k;
                        queensPermutations(qpsf+1, tq, chess);
                        chess[i][j] = 0;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        
        queensPermutations(0, n, chess);
    }
}