/*abstract
Vitaly is a diligent student who never missed a lesson in his five years of studying in the university. He always does his homework on time and passes his exams in time.

During the last lesson the teacher has provided two strings s and t to Vitaly. The strings have the same length, they consist of lowercase English letters, string s is lexicographically smaller than string t. Vitaly wondered if there is such string that is lexicographically larger than string s and at the same is lexicographically smaller than string t. This string should also consist of lowercase English letters and have the length equal to the lengths of strings s and t.

Let's help Vitaly solve this easy problem!

Input
The first line contains string s (1 ≤ |s| ≤ 100), consisting of lowercase English letters. Here, |s| denotes the length of the string.

The second line contains string t (|t| = |s|), consisting of lowercase English letters.

It is guaranteed that the lengths of strings s and t are the same and string s is lexicographically less than string t.

Output
If the string that meets the given requirements doesn't exist, print a single string "No such string" (without the quotes).

If such string exists, print it. If there are multiple valid strings, you may print any of them.

Examples
inputCopy
a
c
outputCopy
b
inputCopy
aaa
zzz
outputCopy
kkk
inputCopy
abcdefg
abcdefh
outputCopy
No such string
Note
String s = s1s2... sn is said to be lexicographically smaller than t = t1t2... tn, if there exists such i, that s1 = t1, s2 = t2, ... si - 1 = ti - 1, si < ti.
*/

import java.util.*;

class vitaly_and_strings{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String t = scn.next();

        System.out.println(isPossible(s, t));
    }

    private static String isPossible(String s, String t) {
        
        char [] ans = s.toCharArray();
        for(int i = 0;i<s.length();i++){
            if(t.charAt(i)-s.charAt(i) > 1){
                ans[i] = (char)(ans[i]+1);
                return new String(ans);
            }else{
                if(t.charAt(i)-s.charAt(i) == 1 && i != s.length()-1){
                    ans[i] = (char)(ans[i]+1);
                    ans[i+1] = (char)((ans[i+1]+1)%26);
                    return new String(ans);
                }
            }
        }
        
        return "No such string";
    }
}