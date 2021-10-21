/*

Given an array of integers, two players Alice and Bob are playing a game where Alice can remove any element from the array.If the bitwise XOR of all remaining elements equals 0 after removal of selected element, then that player looses.Find out winner if both of the players play optimally. Alice starts the game first. In case case one-element in array consider its value as the XOR of array
Input Format
The first line contains integer n, no. of integers.
second line contains n integers arr[1],arr[2]...arr[n].
Output Format
Print the winner (Alice or Bob).
Question Video

  COMMENTConstraints
1<= n <= 10^5
1<= arr[i] <= 10^8
Sample Input
5
15 6 9 10 20
Sample Output
Bob

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class winner_in_nim_game {
  static String findWinner(int[] arr, int n) {
    int xor = 0;
    for(int val:arr){
        xor = xor^val;
    }

    boolean flag = false;
    for(int val:arr){
        int remxor = xor^val;
        if(remxor != 0){
            flag = true;
            break;
        }
    }
    if(flag){
        return "ALICE";
    }else{
        return "BOB";
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

    System.out.println(findWinner(arr, n));
  }
}