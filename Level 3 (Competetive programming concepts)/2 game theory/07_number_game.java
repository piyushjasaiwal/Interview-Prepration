/*
Alice and Bob play a game.

They start with a number n and play in turns. In each turn, a player can make any one of the following moves:
1. Divide n by any of its odd divisors greater than 1.
2. Subtract 1 from n if n is greater than 1.


Divisors of a number include the number itself.
The player who is unable to make a move loses the game.
Alice moves first. Determine the winner of the game if both of them play optimally.
Input Format
The first line contains integer t, no. of test cases.
Each of next t lines contain a number n.
Output Format
Print the winner ALICE or BOB.
Question Video

  COMMENTConstraints
1<= t <= 100
1<= n <= 10^9
Sample Input
7
1
2
3
4
5
6
12
Sample Output
BOB
ALICE
ALICE
BOB
ALICE
BOB
ALICE
*/

import java.io.*;

class number_game {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    String a ="ALICE", b = "BOB";
    while(t-- > 0){
        long n = Long.parseLong(br.readLine());
        if(n == 1){
            System.out.println(b);
        }else if(n == 2){
            System.out.println(a);
        }else if(n%2 == 1){
            System.out.println(a);
        }else{
            if(is_power_of_2(n)){
                System.out.println(b);
            }else if(n%4 == 0){
                System.out.println(a);
            }else if(is_prime(n/2)){
                System.out.println(b);
            }else{
                System.out.println(a);
            }
        }
    }
  }

private static boolean is_prime(long num) {
    for(long i = 2;i*i<=num;i++){
        if(num%i == 0){
            return false;
        }
    }
    return true;
}

private static boolean is_power_of_2(long n) {
    return (n&(n-1)) == 0;
}
}