/*
1. You are given a number n.
2. Print the number produced on setting its i-th bit.
3. Print the number produced on unsetting its j-th bit.
4. Print the number produced on toggling its k-th bit.
5. Also, Check if its m-th bit is on or off. Print 'true' if it is on, otherwise print 'false'.
Input Format
A number
Four numbers i,j,k,m.
Output Format
Check the sample ouput and question video.
Question Video

  COMMENTConstraints
1 <= n <= 10^9
1 <= i <= 9
1 <= j <= 9
1 <= k <= 9
1 <= m <= 9
Sample Input
57
3 
3 
3 
3
Sample Output
57
49
49
true
*/

import java.io.*;
import java.util.*;

class basics_of_bit_manipulation {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    

    //write your code here
    System.out.println(set(n,i));
    System.out.println(unset(n,j));
    System.out.println(toggle(n,k));
    System.out.println(check(n,m));
  }

  public static int set(int number, int i){
    int mask = 1<<(i);
    number = (number | mask);
    return number;
  }

  public static int unset(int number, int i){
    int mask = 1<<(i);
    mask = ~mask;
    number = (number & mask);
    return number;
  }

  public static int toggle(int number, int i){
    int mask = 1<<(i);
    if((mask & number) > 0){
        return unset(number, i);
    }else{
        return set(number, i);
    }
  }

  public static boolean check(int number, int i){
    int mask = 1<<(i);
    return (mask & number) > 0;    
  }



}