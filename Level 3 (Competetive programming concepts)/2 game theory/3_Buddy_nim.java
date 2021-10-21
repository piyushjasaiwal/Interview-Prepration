/*

Three players Alice and Bob and Charlie are playing a game. There are two tables, on the first table, there are N heaps containing A[1],A[2].... A[n] coins, on the second table , there are M heaps containing B[1], B[2]... B[m] coins.
Initially, Alice is playing at the first table and Bob is playing at the second table. The players take their turns in this order: Charlie, Alice, Bob, Charlie, etc.
Bob and alice in their turn can remove as much coin as they want(min is 1) from any one pile of their respective tables. Whoever cannot remove any stone from a pile loses.
Charlie does not play at any table. Instead, on his turn, he decides if Alice and Bob should keep playing at their respective tables or swap places.
Alice and Charlie are buddies and they cooperate, playing in the optimal way that results in Alice's victory (if possible). Find out whether alice will win or bob.
Input Format
The first line contains two space separated integers n and m.
The second line contains n space separated integers a[1],a[2]...a[n].
The third line contains m space separated integers b[1], b[2]....b[n].
Output Format
Print the winner (ALICE or BOB).
Question Video

  COMMENTConstraints
1<= n,m <= 10^5
1<= A[i] <= 10^8
1<= B[i] <= 10^8
Sample Input
6 7
24 6 10 56 9 1
0 6 24 1 9 56 10
Sample Output
BOB
 */

import java.io.*;

class buddy_nim {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = 1;
    while (t-- > 0) {
      String[] st = br.readLine().split(" ");
      int n = Integer.parseInt(st[0]);
      int m = Integer.parseInt(st[1]);

      int[] arr1 = new int[n];
      int[] arr2 = new int[m];

      st = br.readLine().split(" ");
      for (int i = 0; i < n; i++) {
        arr1[i] = Integer.parseInt(st[i]);
      }
      st = br.readLine().split(" ");
      for (int i = 0; i < m; i++) {
        arr2[i] = Integer.parseInt(st[i]);
      }

      long sum1 = 0;
      long sum2 = 0;
      long xor1 = 0; 
      long xor2 = 0;
      
      for(int val:arr1){
        sum1 += val;
        xor1 = (xor1^val);
    }


      for(int val:arr2){
          sum2 += val;
          xor2 = (xor2^val);
      }

      if(sum1 != sum2){
        System.out.println("ALICE");
      }else{
          if((xor1^xor2) == 0){
              System.out.println("BOB");
          }else{
              System.out.println("ALICE");
          }
      }
    }

  }

}
