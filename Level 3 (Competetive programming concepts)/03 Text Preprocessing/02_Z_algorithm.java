/*
1. You are given two strings s1 and s2.
2. s1 represents a text and s2 represents a pattern. 
3. You have to print the starting index for all occurrences of the pattern in the given text string.
Input Format
Two strings s1 and s2 in two different lines.
Output Format
Starting index for all occurrences of the pattern in the given text string.
Question Video

  COMMENTConstraints
1 <= length of the strings <= 10^4
Sample Input
abab
ab
Sample Output
0
2
*/

import java.util.*;

class Z_algorithm {

  // Z function in O(n^2) time complexity
  
  public static int [] Z_function(String str){
    int [] z = new int [str.length()];
    for(int i = 1;i<str.length();i++){
      while(i+z[i] < str.length() && str.charAt(i + z[i]) == str.charAt(z[i])){
        z[i]++;
      }
    }
    return z;
  }

  // Z function in O(n) time complexity
  
  public static int [] Z_function_O_N(String str){
    int [] z = new int [str.length()];
    int l = 0;
    int r = 0;

    for(int i = 1;i<str.length();i++){
        if(i <= r){
          z[i] = Math.min(z[i-l], r-i+1);
        }

        while(i+z[i] < str.length() && str.charAt(z[i]) == str.charAt(z[i]+i)){
          z[i]++;
        }

        if(i+z[i]-1 > r){
          l = i;
          r = i+z[i]-1;
        }
    }
    return z;
  }

  public static void display(int [] ar){
    System.out.println("------------------------------------------------------------------------");
    for(int val:ar){
      System.out.print(val+" ");
    }
    System.out.println("\n------------------------------------------------------------------------");
  }

  public static void solution(String txt, String pat) {
    // write your code here
    int [] z_function = Z_function_O_N(pat + "#" + txt);
    for(int i = 1;i<z_function.length;i++){
      if(z_function[i] == pat.length()){
        System.out.println(i - pat.length() - 1);
      }
    }
  }
  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    solution(s1, s2);
    System.out.println();
    scn.close();
	}

}