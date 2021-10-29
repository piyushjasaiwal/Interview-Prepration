/*

1. You are given a string exp representing an expression.
2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
3. But, some of the pair of brackets maybe extra/needless. 
4. You are required to print true if you detect extra brackets and false otherwise.

e.g.'
((a + b) + (c + d)) -> false
(a + b) + ((c + d)) -> true
Input Format
A string str
Output Format
true or false
Question Video

  COMMENTConstraints
0 <= str.length <= 100
Sample Input
(a + b) + ((c + d))
Sample Output
true

*/

import java.io.*;
import java.util.*;

class duplicate_brackets {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(is_dup(str));
    }
    public static boolean is_dup(String str){
        Stack<Character> s = new Stack<>();
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == ' '){
                continue;
            }
            if(str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']'){
                boolean is_between = false;
                if(str.charAt(i) == ')'){
                    while(!s.empty() && s.peek() != '('){
                        is_between=true;
                        s.pop();
                    }
                }else if(str.charAt(i) == '}'){
                    while(!s.empty() && s.peek() != '{'){
                        is_between=true;
                        s.pop();
                    }
                }else if(str.charAt(i) == ']'){
                    while(!s.empty() && s.peek() != '('){
                        is_between=true;
                        s.pop();
                    }
                }
                if(!is_between){
                    return true;
                }
                s.pop();
            }else{
                s.push(str.charAt(i));
            }
            // System.out.println(s);
        }
        return false;
    }
}