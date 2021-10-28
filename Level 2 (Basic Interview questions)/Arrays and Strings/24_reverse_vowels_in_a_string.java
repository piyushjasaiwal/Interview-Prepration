/*
1. Given a string 's'.
2. Reverse only all the vowels in the string and return it.
3. The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
Input Format
s = "hello"
s = "PepCoding"
Output Format
res = "holle"
res = "PipCodeng"
Question Video

  COMMENTConstraints
1. 1 <= s.length() <= 10^5
2. String consist of printable ASCII characters.
Sample Input
hello
Sample Output
holle
*/

import java.util.*;

class reverse_vowels_in_a_string {
  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~
  public static String reverseVowels(String s) {
    // write your code here
    char [] arr = s.toCharArray();
    int i = 0;
    int j = s.length()-1;
    while(i < j){
        while(i<s.length() && !is_vowel(arr[i])){
            i++;
        }

        while(j>=0 && !is_vowel(arr[j])){
            j--;
        }

        if(i < j){
            swap(arr, i, j);
        }
        i++;
        j--;
    }
    return new String(arr);     
  }

  private static void swap(char[] arr, int i, int j) {
    char ch = arr[i];
    arr[i] = arr[j];
    arr[j] = ch;
}

private static boolean is_vowel(char c) {
    return c == 'a' || 
           c == 'e' || 
           c == 'i' || 
           c == 'o' || 
           c == 'u' || 
           c == 'A' || 
           c == 'E' || 
           c == 'I' || 
           c == 'O' || 
           c == 'U';
}

// ~~~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    String res = reverseVowels(str);
    System.out.println(res);
  }
}
