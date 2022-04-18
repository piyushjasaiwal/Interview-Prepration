/*abstract
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

Input Format
low integer
high integer
Output Format
List
Question Video

Constraints
10 <= low <= high <= 10^9
Sample Input
10
100
Sample Output
12 23 34 45 56 67 78 89 
*/

import java.beans.beancontext.BeanContext;
import java.util.*;

class sequetial_digits {

    public static ArrayList<Integer> sequentialDigits(int low, int high) {
        //Write your code here
        int [] all = {12,23,34,45,56,67,78,89,
                        123,234,345,456,567,678,789,
                        1234,2345,3456,4567,5678,6789,
                        12345,23456,34567,45678,56789,
                        123456,234567,345678,456789,
                        1234567,2345678,3456789,
                        12345678,23456789,
                        123456789};

        ArrayList<Integer> ans = new ArrayList<>();
        for(int val:all){
            if(val < low){
                continue;
            }
            if(val>high){
                break;
            }
            ans.add(val);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        ArrayList<Integer> ans = sequentialDigits(n, m);
        for (int ele : ans) {
            System.out.print(ele + " ");
        }
    }
}