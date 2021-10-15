/*
1. You are give a number of boxes (nboxes) and number of identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are identical and all of them are named 'i'
Note 1 -> Number of boxes is greater than number of items, hence some of the boxes may remain 
                   empty.
Note 2 -> Check out the question video and write the recursive code as it is intended without 
                   changing signature. The judge can't force you but intends you to teach a concept.
Input Format
Input is managed for you
Output Format
Check the sample ouput and question video. - means empty box, i means occupied by item.
Question Video

  COMMENTConstraints
0 < nboxes <= 10
0 <= ritems <= nboxes
Sample Input
5
3
Sample Output
iii--
ii-i-
ii--i
i-ii-
i-i-i
i--ii
-iii-
-ii-i
-i-ii
--iii
*/

import java.io.*;

class combinations_2 {
    public static void combinations(int[] boxes, int ci, int ti, int lb){
        // write your code here
        if(ci>ti){
            for(int val:boxes){
                System.out.print(val == 1 ? 'i' : '-');
            }
            System.out.println();
            return ;
        }
        for(int i = lb+1;i<boxes.length;i++){
            boxes[i] = 1;
            combinations(boxes, ci+1, ti, i);
            boxes[i]= 0;
        }

      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(new int[nboxes], 1, ritems, -1);
      }
}
