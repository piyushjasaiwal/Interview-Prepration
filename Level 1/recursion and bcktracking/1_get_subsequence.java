/*1. You are given a string str.
2. Complete the body of getSS function - without changing signature - to calculate all subsequences of str.
Use sample input and output to take idea about subsequences.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A string str
Output Format
Contents of the arraylist containing subsequences as shown in sample output 

Sample Input
abc
Sample Output
[, c, b, bc, a, ac, ab, abc]
*/

import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(gss(str));
    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        ArrayList<String> rr = gss(str.substring(1));
        int len = rr.size();
        for(int i = 0 ;i<len;i++){
            rr.add(ch+rr.get(i));
        }
        return rr;
    }

}
