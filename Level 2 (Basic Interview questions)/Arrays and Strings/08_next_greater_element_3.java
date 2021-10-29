/*
1. Given a positive number 'n' in form of String.
2. Find the smallest number which has exactly the same digits existing in the number 'n' and is greater in value than 'n'.
3. If no such positive number exists, return -1 as string.
Input Format
Input: n = 12
Input: n = 21
Output Format
Output: 21
Output: -1
Question Video

  COMMENTConstraints
1. 'n' is given in form of string.
Sample Input
132
Sample Output
213
*/

import java.util.*;

class next_greater_element_3 {
    
    //~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
    public static String nextGreaterElement(String str) {
        // write your code here
        if(!is_possible(str)){
            return "-1";
        }

        int j = str.length()-2;
        while(j>=0 && str.charAt(j) > str.charAt(j+1)){
            j--;
        }

        int i = str.length()-1;
        while(i >= 0 && str.charAt(i) < str.charAt(j)){
            i--;
        }

        char ar[] = str.toCharArray();
        
        //swap
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;

        i--;
        j++;

        reverse(ar, j, ar.length-1);
        
        return new String(ar);
    }

    private static void reverse(char[] ar, int i, int j) {
        while(i<j){
            char temp = ar[i];
            ar[i] = ar[j];
            ar[j] = temp;
            i++;
            j--;
        }
    }

    private static boolean is_possible(String str) {
        for(int i = 0;i<str.length()-1;i++){
            if(str.charAt(i) < str.charAt(i+1)){
                return true;
            }
        }
        return false;
    }

    //~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num = scn.next();
        String res = nextGreaterElement(num);

        System.out.println(res);
    }
}