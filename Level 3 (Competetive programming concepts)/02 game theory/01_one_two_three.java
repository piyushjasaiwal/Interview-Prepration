/*
Two players Alice and Bob are playing a game. They have a pile with n coins in it. They can pick either 1 or 2 coins in one turn. Alice goes first and they take alternate turns.The player who picks the last coin is the winner. Can you find out the winner.
Input Format
The first line contains integer n(no. of coins in the pile).
Output Format
Print the winner (ALICE or BOB).
Question Video

  COMMENTConstraints
1<= n <= 10^18
Sample Input
10
Sample Output
ALICE
*/

import java.io.*;
import java.util.*;

class one_two_three {

  public static void main(String[] args) throws NumberFormatException, IOException {
    Scanner s = new Scanner(System.in);
    long n = s.nextLong();
    n = n%3;
    if(n == 0){
        System.out.println("BOB");
    }else{
        System.out.println("ALICE");
    }
  }
}
