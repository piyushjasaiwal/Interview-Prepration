/*

Two players Alice and Bob are playing NIM Game with each other. Both are playing optimally.Alice starts the game. The task is to find the number of ways of playing 1st move for Alice to ensure a winning strategy for him if possible, otherwise print -1.
Input Format
The first line contains one integer n.
The second line contains n space separated integers a[1],a[2]...a[n].
Output Format
Print the number of possible first move for Alice to win. If Alice can't win, Print -1.
Question Video

  COMMENTConstraints
1<= n <= 10^5
1<= A[i] <= 10^8
Sample Input
7
24 6 10 56 9 1 24
Sample Output
1

*/

import java.io.*;

class first_move_nim_game {

  static int Solve(int[] arr) {
    int xor = 0;
    for(int val:arr){
        xor = xor^val;
    }
    if(xor == 0){
        return -1;
    }else{
        int cnt = 0;
        for(int val:arr){
            int remxor = xor^val;
            if(remxor < val){
                cnt+=1;
            }
        }
        return cnt;
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int arr[] = new int[n];
    String[] st = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st[i]);
    }
    System.out.println(Solve(arr));
  }
}
