/*abstract
1. You are given two numbers A and B.
2. You have to print the count of bits needed to be flipped to convert 'A' to 'B'.
Input Format
2 numbers A and B
Output Format
A number
Question Video

  COMMENTConstraints
-10^9 <= A,B <= 10^9
Sample Input
57
76
Sample Output
5
*/

import java.util.*;

class Flip_Bits_to_convert_A_to_B_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long a = s.nextLong();
        long b = s.nextLong();

        long xor = a^b;
        int count = 0;

        while(xor > 0){
            count++;
            xor = (xor&(xor-1));
        }

        System.out.println(count);
    }
}
