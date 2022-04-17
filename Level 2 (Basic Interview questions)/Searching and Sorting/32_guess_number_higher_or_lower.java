/*abstract
1. We are playing the Guess Game. The game is as follows:
2. I pick a number from 1 to n. You have to guess which number I picked.
3. Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
4. You call a pre-defined API int guess(int num), which returns 3 possible results:
   a) -1: The number I picked is lower than your guess (i.e. pick < num).
   b) 1: The number I picked is higher than your guess (i.e. pick > num).
   c). 0: The number I picked is equal to your guess (i.e. pick == num).
5. Return the number that I picked.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= n <= 231 - 1
1 <= pick <= n
Sample Input
10 6
Sample Output
6
*/

import java.util.*;
import java.io.*;

class guess_number_higher_or_lower {

  public static int guessNumber(int n) {
    //write your code here
    int lo = 0;
    int hi = n;
    while(lo <= hi){
        int mid = (lo+hi)/2;
        int guess = guess(mid);
        if(guess == 0){
            return mid;
        }else if(guess == -1){
            hi = mid-1;
        }else{
            lo = mid+1;
        }
    }
    return -1;
  }

  static int pn = 0; //picked number
  public static int guess(int val) {
    if (val == pn) {
      return 0;
    }
    else if (val < pn) {
      return 1;
    }
    else {
      return -1;
    }
  }

  public static void solve(int n, int pick) {
    pn = pick;
    System.out.println(guessNumber(n));
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int pick = scn.nextInt();

    solve(n, pick);
  }
}