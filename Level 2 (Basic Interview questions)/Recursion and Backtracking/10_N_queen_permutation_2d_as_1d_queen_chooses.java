import java.io.*;

/*
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the permutations in which n queens (distinct) can be 
     placed on the n * n chess-board. 
3. No queen shall be able to kill another.

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
4
Sample Output
{
-	q1	-	-	
-	-	-	q2	
q3	-	-	-	
-	-	q4	-	

-	q1	-	-	
-	-	-	q2	
q4	-	-	-	
-	-	q3	-	

-	q1	-	-	
-	-	-	q3	
q2	-	-	-	
-	-	q4	-	

-	q1	-	-	
-	-	-	q4	
q2	-	-	-	
-	-	q3	-	

-	q1	-	-	
-	-	-	q3	
q4	-	-	-	
-	-	q2	-	

-	q1	-	-	
-	-	-	q4	
q3	-	-	-	
-	-	q2	-	

and so on
*/


class N_queen_permutation_2d_as_1d_queen_chooses {
    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        // write your code here
        int r = row;
        int c = col;

        while(r >= 0){
            if(chess[r][col] != 0){
                return false;
            }
            r--;
        }
        
        r = row;
        c = col;

        while(c >= 0){
            if(chess[row][c] != 0){
                return false;
            }
            r--;
        }
        
        r = row;
        c = col;

        while(c >= 0 && r >= 0){
            if(chess[r][c] != 0){
                return false;
            }
            r--;
            c--;
        }

        r = row;
        c = col;

        while(c < chess[0].length && r >= 0){
            if(chess[r][c] != 0){
                return false;
            }
            r--;
            c++;
        }

        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        // write your code here
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}
