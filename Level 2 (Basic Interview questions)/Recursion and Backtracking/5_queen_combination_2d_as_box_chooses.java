/*
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
qq
--

q-
q-

q-
-q

-q
q-

-q
-q

--
qq
*/

import java.io.*;

class queen_combination_2d_as_box_chooses {
    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        // write your code here
        if(col == tq){
            asf = asf+"\n";
            row +=1;
            col = 0;
        }
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
            }
            return ;
        }

        queensCombinations(qpsf+1, tq, row, col+1, asf+'q');
        queensCombinations(qpsf, tq, row, col+1, asf+'-');

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}
