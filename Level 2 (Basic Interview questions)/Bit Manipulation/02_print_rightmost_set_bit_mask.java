import java.util.Scanner;

/*
1. You are given a number n.
2. You have to print the right-most set bit mask.
Input Format
A number n
Output Format
A number
Question Video

  COMMENTConstraints
1 <= n <= 10^9
Sample Input
58
Sample Output
10
*/

class print_rightmost_set_bit_mask {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        //write your code here

        //taking the 2's complement i.e. making each 0 bit 1 and 1 bit 0 for 2's complement we just have to do -n
        n = n&-n;
        System.out.println(Integer.toBinaryString(n));
      }
}
