/*
1. Your friend is typing his name into a faulty keyboard. 
2. Sometimes, when typing a character 'c', the key might get long pressed, and the character will be typed 1 or more times.
3. You examine the typed characters of the keyboard. Return 'True' if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
Input Format
name = "mannu", typed = "mmaannu"
name = "sumeet", typed = "sumeet"
name = "shree", typed = "sshrre"
Output Format
true
[Explanation: 'm' and 'a' in 'mannu' were long pressed.]
true
[Explanation: It's not necessary to long press any character.]
false
[Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.]
Question Video

  COMMENTConstraints
1. 1 <= name.length <= 1000
2. 1 <= typed.length <= 1000
3. name and typed contain only lowercase English letters.
Sample Input
shree
sshhrreee
Sample Output
true
*/

import java.util.*;

class faulty_keyboard{
    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static boolean isPossible(String name, String typed) {
        // Write your code here
        int i = 0;
        int j = 0;
        while(i < name.length() && j < typed.length()){
            if(name.charAt(i) != typed.charAt(j)){
                return false;
            }

            char ch = name.charAt(i);
            int cnt1 = 0;
            while(i<name.length() && name.charAt(i) == ch){
                i++;
                cnt1++;
            }
            int cnt2 = 0;
            while(j<typed.length() && typed.charAt(j) == ch){
                j++;
                cnt2++;
            }
            if(cnt1 > cnt2){
                return false;
            }
        }
        if(i < name.length() || j < typed.length()){
            return false;
        }
        return true;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        String name = scn.next();
        String typed = scn.next();

        boolean res = isPossible(name, typed);

        System.out.println(res);
    }
}