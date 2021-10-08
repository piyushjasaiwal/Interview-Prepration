/*
1. You are given a string exp representing an expression.
2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

e.g.
[(a + b) + {(c + d) * (e / f)}] -> true
[(a + b) + {(c + d) * (e / f)]} -> false
[(a + b) + {(c + d) * (e / f)} -> false
([(a + b) + {(c + d) * (e / f)}] -> false
Input Format
A string str
Output Format
true or false
Question Video

  COMMENTConstraints
0 <= str.length <= 100
Sample Input
[(a + b) + {(c + d) * (e / f)}]
Sample Output
true
*/
import java.util.*;
class balanced_brackets {
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
            // System.out.println("------------------------------");;
            // System.out.println(str.charAt(i));
            // System.out.println("------------------------------");;
            if(str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']'){
                if(str.charAt(i) == ')'){
                    if(s.empty() || s.peek() != '('){
                        return false;
                    }
                }else if(str.charAt(i) == '}'){
                    if(s.empty() || s.peek() != '{'){
                        return false;
                    }
                }else if(str.charAt(i) == ']'){
                    if(s.empty() || s.peek() != '['){
                        return false;
                    }
                }
                s.pop();
            }else if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
                s.push(str.charAt(i));
            }
            // System.out.println(s);
        }
        return s.empty();
    }
}
