/*
1. You are given a binary string which represents a number.
2. You have to check whether this number is divisible by 3 or not.
3. Print 'true' if it is divisible by 3, otherwise print 'false'.
Input Format
A binary string
Output Format
true or false
Question Video

Constraints
1 <= length of binary string <= 10000
Sample Input
10010101010001
Sample Output
false
*/

import java.util.Scanner;

class check_divisibility_by_3 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
    
        //write your code here
        
        int odd = 0;
        int even = 0;

        for(int i = 0;i<str.length();i++){
            if(i%2 == 0){
                odd = odd+ (((str.charAt(i)-'0')%2 == 0) ? 0 : 1);
            }else{
                even = even+ (((str.charAt(i)-'0')%2 == 0) ? 0 : 1);
            }
        }

        System.out.println((even-odd)%11 == 0);
    }
}
