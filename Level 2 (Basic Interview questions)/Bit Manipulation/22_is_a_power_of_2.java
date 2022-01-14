/*abstract
1. You are given a number n.
2. You have to check whether it is a power of 2 or not.
Input Format
A number n
Output Format
true/false
Question Video

  COMMENTConstraints
1 <= n <= 10^9
Sample Input
1024
Sample Output
true
*/

import java.io.*;
import java.util.*;

class is_a_power_of_2 {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    //write your code here
    
    System.out.println((n&(n-1)) == 0);
  }

}