import java.util.*;

/*abstract
Asterix, Obelix and their temporary buddies Suffix and Prefix has finally found the Harmony temple. However, its doors were firmly locked and even Obelix had no luck opening them.

A little later they found a string s, carved on a rock below the temple's gates. Asterix supposed that that's the password that opens the temple and read the string aloud. However, nothing happened. Then Asterix supposed that a password is some substring t of the string s.

Prefix supposed that the substring t is the beginning of the string s; Suffix supposed that the substring t should be the end of the string s; and Obelix supposed that t should be located somewhere inside the string s, that is, t is neither its beginning, nor its end.

Asterix chose the substring t so as to please all his companions. Besides, from all acceptable variants Asterix chose the longest one (as Asterix loves long strings). When Asterix read the substring t aloud, the temple doors opened.

You know the string s. Find the substring t or determine that such substring does not exist and all that's been written above is just a nice legend.

Input
You are given the string s whose length can vary from 1 to 106 (inclusive), consisting of small Latin letters.

Output
Print the string t. If a suitable t string does not exist, then print "Just a legend" without the quotes.

Examples
inputCopy
fixprefixsuffix
outputCopy
fix
inputCopy
abcdabc
outputCopy
Just a legend
*/

class password{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String str = s.next();

        // lps starts
        int [] lps = new int[str.length()];
        for(int i = 1;i<str.length();i++){
            int j = lps[i-1];
            while(j>0 && str.charAt(i) != str.charAt(j)){
                j = lps[j-1];
            }

            if(str.charAt(i) == str.charAt(j)){
                j++;
            }

            lps[i] = j;
        }
        //lps ends

        // System.out.println("-----------------------------------");
        // for(int val:lps){
        //     System.out.print(val+" ");
        // }
        // System.out.println("\n-----------------------------------");

        if(lps[str.length()-1] == 0){
            System.out.println("Just a legend");
            return ;
        }

        String patt = "";

        if(lps[str.length()-1] > str.length()/2){
            patt = str.substring(0, str.length()-lps[str.length()-1]);
        }else{
            patt = str.substring(0, lps[str.length()-1]);
        }
        int i = 0;
        int j = 0;

        while(i<str.length()){
            if(str.charAt(i) == patt.charAt(j)){
                i++;
                j++;
            }

            if(j == patt.length()){
                if(i != str.length() && i != patt.length()){
                    System.out.println(patt);
                    return ;
                }
                
                j = lps[j-1];
            }else if(i<str.length() && str.charAt(i) != patt.charAt(j)){
                if(j == 0){
                    i++;
                }else{
                    j = lps[j-1];
                }
            }
        }

        System.out.println("Just a legend");
    }
}