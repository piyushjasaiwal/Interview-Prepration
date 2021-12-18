/*here we will use grundy theoram*/

/*
Two players Alice and Bob are playing a game. They have a pile with n coins in it.
They can pick only allowed numbers of coins at a time given in an array picks.
Alice goes first and they take alternate turns.
The player who picks the last coin is the winner. Can you find out the winner.
Input Format
The first line contains integer n(no. of coins in the pile).
Second line contains size of picks array say l
picks[0]
picks[1]
....
picks[l-1]
Output Format
Print the winner (ALICE or BOB).
Question Video

  COMMENTConstraints
1<= n <= 1000
Sample Input
8
3
5
1
4
Sample Output
BOB
*/

import java.io.*;
import java.util.*;

class grundy_numbers {

  static void solve(int coins, int picks[]) {
    // print the winner here
    Arrays.sort(picks);
    int [] ar = new int[coins+1];
    for(int i = 0;i<picks[0];i++){
        ar[i] = 2;
    }

    for(int i = picks[0];i<=coins;i++){
        int ans = 2;
        for(int pick : picks){
            if(i-pick >= 0){
                if(ar[i-pick] == 2){
                    ans = 1;
                    break;
                }
            }
        }
        ar[i] = ans;
    }

    System.out.println(ar[coins] == 1 ? "ALICE" : "BOB");
  }

  public static void main(String[] args) throws Exception {

    Scanner scn = new Scanner(System.in);

    int coins = scn.nextInt();
    int l = scn.nextInt();
    int picks[] = new int[l];

    for (int i = 0; i < l; i++) {
      picks[i] = scn.nextInt();
    }

    solve(coins, picks);
  }
}
