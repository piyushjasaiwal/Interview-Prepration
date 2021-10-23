/*
Two players Alice and Bob are playing a game. They have 2 pile's with n1 and n2 coins in it.
They can pick only allowed numbers of coins from any one pile at a time given in an array picks.
Alice goes first and they take alternate turns.
The player who picks the last coin is the winner. Can you find out the winner.
Input Format
The first line contains two integers n1 and n2.
Second line contains size of picks array say l
picks[0]
picks[1]
....
picks[l-1]
Output Format
Print the winner (ALICE or BOB).
Question Video

  COMMENTConstraints
1 <= n1, n2 <= 50
Sample Input
4 3
3
1
4
2
Sample Output
ALICE
*/

import java.io.*;
import java.util.*;

class two_piles_with_grundy_numbers {

  static void solve(int n1, int n2, int picks[]) {
    // print the winner here
    HashMap<Integer, Integer> grundy_mex = new HashMap<>();
    int max = Math.max(n1, n2);
    make_grundy_map(grundy_mex, max);
  }



  private static void make_grundy_map(HashMap<Integer, Integer> grundy_mex, int n, int [] picks) {
      if(n == 0){
          grundy_mex.put(0, 0);
          return ;
      }

      if(grundy_mex.containsKey(n)){
          return ;
      }

      Set<Integer> set = new HashSet<>();
      for(int pick:picks){
          if(n-pick >= 0){

          }
      }

  }

  private static int calculate_mex(int n, HashMap<Integer, Integer> grundy_mex){
    int mex = 0;
    if()
  } 



public static void main(String[] args) throws Exception {

    Scanner scn = new Scanner(System.in);

    int n1 = scn.nextInt();
    int n2 = scn.nextInt();
    int l = scn.nextInt();
    int picks[] = new int[l];

    for (int i = 0; i < l; i++) {
      picks[i] = scn.nextInt();
    }

    solve(n1, n2, picks);
  }
}

}