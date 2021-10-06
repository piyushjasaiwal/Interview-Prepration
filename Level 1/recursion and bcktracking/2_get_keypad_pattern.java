/*
1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
2. The following list is the key to characters map :
    0 -> .;
    1 -> abc
    2 -> def
    3 -> ghi
    4 -> jkl
    5 -> mno
    6 -> pqrs
    7 -> tu
    8 -> vwx
    9 -> yz
3. Complete the body of getKPC function - without changing signature - to get the list of all words that could be produced by the keys in str.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A string str
Output Format
Contents of the arraylist containing words as shown in sample output


Sample Input
78
Sample Output
[tv, tw, tx, uv, uw, ux]
*/
import java.io.*;
import java.util.*;

class keypad {

    static HashMap<Character, String> map;
    public static void main(String[] args) throws Exception {
        map = new HashMap<>();
        map.put('0', ".;"
 );       map.put('1', "abc"
);        map.put('2', "def"
);        map.put('3', "ghi"
);        map.put('4', "jkl"
);        map.put('5', "mno"
);        map.put('6', "pqrs");
        map.put('7', "tu"
 );       map.put('8', "vwx"
);        map.put('9', "yz"
 );   


        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(getKPC(str));


}

    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        ArrayList<String> base = getKPC(str.substring(1));
        String curr = map.get(ch);
        ArrayList<String> rr = new ArrayList<>();
        for(int i = 0;i<curr.length();i++){
            for(String ss:base){
                rr.add(curr.charAt(i)+ss);
            }
        }
        return rr;
    }

}