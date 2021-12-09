/*abstract
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


q2	-
q1	-


q2	-
-	q1


-	q1
q2	-


-	q1
-	q2


-	q2
q1	-


-	q2
-	q1


-	-
q1	q2


-	-
q2	q1
*/

import java.io.*;
import java.util.*;

class queen_combination_2d_as_box_chooses_two {

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        // write your code here
        if(col >= queens.length){
            row += 1;
            col = 0;
            asf = asf+"\n";
        }

        if(row >= queens.length){
            if(tq == qpsf){
                System.out.println(asf);
                System.out.println();
            }
            return ;
        }

        for(int i = 1;i<=tq;i++){
            if(!queens[i-1]){
                queens[i-1] = true;
                queensPermutations(qpsf+1, tq, row, col+1, asf+("q"+(i)+"\t"), queens);
                queens[i-1] = false;
            }
        }

        queensPermutations(qpsf, tq, row, col+1, asf+("-\t"), queens);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];
        Arrays.fill(queens, false);
        queensPermutations(0, n, 0, 0, "", queens);
    }
}