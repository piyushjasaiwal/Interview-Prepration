/*abstract
1: Given a string S of '(' and ')' parentheses.
2: You need to find count of minimum number of parentheses '(' or ')' when added in any positions so that the resulting parentheses string is valid.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1: S.length <= 1000
2: S only consists of '(' and ')' characters.
Sample Input
()))((
Sample Output
4
*/

import java.io.*;
import java.util.*;

class minimum_add_to_make_parentthesis_valid {
    public static int minAddToMakeValid(String S) {
        // complete this function
        Stack<Character> s= new Stack<>();
        for(int i = 0;i<S.length();i++){
            char ch = S.charAt(i);
            if(ch == '('){
                s.push(ch);
            }else{
                if(!s.empty() && s.peek() == '('){
                    s.pop();
                }else{
                    s.push(ch);
                }
            }
        }

        return s.size();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int result = minAddToMakeValid(read.readLine());
        System.out.println(result);
    }
}