/*abstract
1. You are given a valid parentheses string in form of A+B+C... where A, B and C are valid primitive strings.
2. A primitive string is a valid parentheses string which cant is split in s = x+y, with x and y nonempty valid parentheses strings.
3. You have to remove the outermost parentheses from all primitive strings.

Example "(()())(())" = "(()())" + "(())".
removing outermost parentheses from "(()())" and "(())" will result in ()()().
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1. s.length <= 10000
2. s[i] is "(" or ")"
3. s is a valid parentheses string
Sample Input
(()())(())
Sample Output
()()()
*/

import java.io.*;
import java.util.*;

class remove_outermost_parentthesis {
  public static String removeOuterParentheses(String str) {
    // write your code here
    StringBuilder sb = new StringBuilder("");
    Stack<Integer> s = new Stack<>();

    for(int i = 0;i<str.length();i++){
        char ch = str.charAt(i);
        if(ch == '('){
            s.push(i);
        }else{
            if(s.size() == 1){
                int start = s.pop();
                int end = i;
                sb.append(str.substring(start+1, end));
            }else{
                s.pop();
            }
        }
    }
    return new String(sb);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    String result = removeOuterParentheses(read.readLine());
    System.out.println(result);
  }
}
