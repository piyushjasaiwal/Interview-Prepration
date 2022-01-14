/*abstract
1. You are given a number n.
2. You have to swap all odd position bits with even position bits.
3. Every odd position bit is swapped with adjacent bit on left side.
4. Every even position bit is swapped with adjacent bit on right side.
5. Print the number formed after swapping.
Input Format
A number n
Output Format
Check the sample ouput and question video.
Question Video

  COMMENTConstraints
1 <= n <= 10^9
Sample Input
10
Sample Output
5
*/

import java.io.*;
import java.util.*;

class swap_all_odd_and_even_bits {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //write your code here

        int oddMask = 0x55555555;
        int evenMask = 0XAAAAAAAA;

        int odds = (n&oddMask);
        int evens = (n&evenMask);

        odds = odds << 1;
        evens = evens>>1;

        System.out.println((odds|evens));
    }
}