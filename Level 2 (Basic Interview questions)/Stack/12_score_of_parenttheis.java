/*abstract
Given a balanced parentheses string S, compute the score of the string based on the following rule:
    () has score 1
    AB has score A + B, where A and B are balanced parentheses strings.
    (A) has score 2 * A, where A is a balanced parentheses string.

Score of ()()() string is 3 => 1 + 1 + 1
Score of (()) string is 2 => 2 * 1
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1: S is a balanced parentheses string, containing only ( and ).
2: 2 <= S.length <= 50
Sample Input
(()(()))
Sample Output
6
*/

/* hint which i figured out on my own 

we can use recursion here

*/

import java.io.*;
import java.util.*;

class score_of_parenttheis {
    public static int scoreOfParentheses(String S) {
        return score(S, 0, S.length()-1);
    }

    private static int score(String str, int beg, int end) {
        if(beg + 1 == end){
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int score = scoreOfParentheses(read.readLine());
        System.out.println(score);
        
    }
}
