/*
Given an array of integers, two players Alice and Bob are playing a game where Alice can remove any  element from the array that are multiples of 3. Similarly, Bob can remove multiples of 5. The player who can't remove any element loses the game. The task is to find the winner of the game if Alice starts first and both play optimally.
Input Format
The first line contains integer n, no. of integers.
second line contains n integers arr[1],arr[2]...arr[n].
Output Format
Print the winner (ALICE or BOB).
Question Video

  COMMENTConstraints
1<= n <= 10^5
1<= arr[i] <= 10^8
Sample Input
5
15 6 9 10 20
Sample Output
ALICE
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class modified_nim_game {
  static String getWinner(int arr[], int n) {
      int common_count = 0;
      int m3 = 0, m5 = 0;
      for(int val:arr){
          if(val%3 == 0 && val%5 == 0){
              common_count++;
          }else{
              if(val%3 == 0){
                  m3++;
              }
              if(val%5 == 0){
                  m5++;
              }
          }
      }

      if(m3>m5){
          return "ALICE";
      }else if(m3<m5){
        return "BOB";
      }else{
          if(common_count > 0){
              return "ALICE";
          }else{
              return "BOB";
          }
      }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] st = br.readLine().split(" ");

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st[i]);
    }

    System.out.println(getWinner(arr, n));
  }
}