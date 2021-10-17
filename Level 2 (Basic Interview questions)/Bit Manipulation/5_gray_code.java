import java.util.*;

/*
1. The gray code is a binary numeral system where two successive numbers differ in only one bit.
2. Given a non-negative integer n representing the total number of bits in the code, print the 
     sequence of gray code. A gray code sequence must begin with 0.
 
 Example:
 Input: 2
 Output: [0,1,3,2]
 Explanation:
 00 - 0
 01 - 1
 11 - 3
 10 - 2
 [0,2,3,1] is also a valid gray code sequence.
 00 - 0
 10 - 2
 11 - 3
 01 - 1
Input Format
First line contains n(number of digits).
Output Format
Return the list of numbers in any valid order.
Question Video

  COMMENTConstraints
0<=n<=20
Sample Input
2
Sample Output
[0, 1, 2, 3]
*/

class gray_code {
    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        //Write your code here
        for(int i = 0;i<pow(2,n);i++){
            list.add(i);
        }
        return list;
    }
   
    private static int pow(int a, int b) {
        if(b == 0){
            return 1;
        }
        return a*pow(a, b-1);
    }

    public static void main(String[] args) {
           Scanner scn = new Scanner(System.in);
           List<Integer> ans=grayCode(scn.nextInt());
           Collections.sort(ans);
           System.out.println(ans);
    }
}
