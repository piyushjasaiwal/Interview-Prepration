/*
1. Given two non-negative integers, num1 and num2 represented as string.
2. Return the sum of num1 and num2 as a string.
3. You must solve the problem without using any built-in library for handling large integers (such as BigInteger). 
4. You must also not convert the inputs to integers directly.
Input Format
n1 = "1234"
n2 = "897"
Output Format
res = "2131"
Question Video

  COMMENTConstraints
1. 1 <= num1.length, num2.length <= 10^4
2. num1 and num2 consist of only digits.
3. num1 and num2 don't have any leading zeros except for the zero itself.
Sample Input
1234
798
Sample Output
2032
*/

import java.util.*;

class add_strings {

  public static String addStrings(String num1, String num2) {
    // write your code here
    int i = num1.length()-1, j = num2.length()-1;
    int carry = 0;
    StringBuilder sb = new StringBuilder();
    while(i >= 0 && j >= 0){
        int sum = num1.charAt(i) + num2.charAt(j) - '0' - '0' + carry;
        carry = sum/10;
        sum = sum%10;
        sb.insert(0, sum);
        i--;
        j--;
    }

    while(i >= 0){
        int sum = num1.charAt(i) - '0' + carry;
        carry = sum/10;
        sum = sum%10;
        sb.insert(0, sum);
        i--;
    }

    while(j >= 0){
        int sum = num2.charAt(j) - '0' + carry;
        carry = sum/10;
        sum = sum%10;
        sb.insert(0, sum);
        j--;
    }
    if(carry > 0){
        sb.insert(0, carry);
    }
    return new String(sb);
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String n1 = scn.nextLine();
    String n2 = scn.nextLine();

    String res = addStrings(n1, n2);
    System.out.println(res);
  }
}