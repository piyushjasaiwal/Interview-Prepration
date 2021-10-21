/*
Two players Alice and Bob are playing a game. They have n piles. ith pile conatins arr[i] no. of coins. In each move a player can choose a pile and remove as many coins as he wants (minimum 1 coin). The player who removes the last set of coins from table will win. Alice goes first.
Input Format
The first line contains integer n, no. of piles.
second line contains n integer containing number of coins in each pile.
Output Format
Print the winner (ALICE or BOB).
Question Video

  COMMENTConstraints
1<= n <= 10^5
1<= arr[i] <= 10^8
Sample Input
3
1 2 3
Sample Output
BOB
*/

/*
strategy for the solution

take a variable nim sum which will be equal to xor of all the numbers in the array 
if the xor comes out to be:
  0 -> then bob will win
  otherwise alice will win
*/

import java.io.*;

class nim_game {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int [] ar = new int[n];
    String[] str = br.readLine().split(" ");
    for(int i = 0;i<n;i++){
      ar[i] = Integer.parseInt(str[i]);
    }
    int xor = 0;
    for(int val:ar){
      xor = xor^val;
    }

    System.out.println(xor == 0 ? "BOB" : "ALICE");
  }
}
