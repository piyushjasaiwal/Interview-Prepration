/*
Given a string, print all suffixes of it in lexicographical order.
Input Format
A string S.
Output Format
Print |S| lines, each having a suffix.
Question Video

  COMMENTConstraints
|S| <= 10^5
Sample Input
bananaban
Sample Output
aban
an
anaban
ananaban
ban
bananaban
n
naban
nanaban
*/

import java.util.*;

class lexicographical_suffixes {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // Write Code here
        String str = scn.next();

        ArrayList<String> strings = new ArrayList<>();
        for(int i = str.length()-1;i>=0;i--){
            strings.add(str.substring(i, str.length()));
        }

        Collections.sort(strings);
        for(String val:strings){
            System.out.println(val);
        }
        scn.close();
    }
}