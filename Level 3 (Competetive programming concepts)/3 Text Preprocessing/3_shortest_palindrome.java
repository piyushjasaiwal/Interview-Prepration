/*
1. You are given string(str). 
2. You can convert the given string to a palindrome by adding some characters in front of it.
3. You have to find the shortest palindromic string formed after performing the above-mentioned transformation.
Input Format
A string
Output Format
A string
Question Video

  COMMENTConstraints
1 <= length of the string <= 10^4
Sample Input
coding
Sample Output
gnidocoding
*/

import java.util.*;

class shortest_palindrome {
    public static String solution(String str){
        // write your code here
        String newString = str +"$"+reverse(str);
        int [] ans = lps(newString);
        return (reverse(str.substring(ans[ans.length-1])) + str);
    }
    
    private static String reverse(String str) {
        char []arr = str.toCharArray();
        int i = 0, j = arr.length-1;
        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

    public static int [] lps(String str){
        int []ans = new int[str.length()];
        ans[0] = 0;
        for(int i = 1;i<ans.length;i++){
            int j = ans[i-1];
            while(j > 0 && str.charAt(i) != str.charAt(j)){
                j = ans[j-1];
            }

            if(str.charAt(i) == str.charAt(j)){
                j++;
            }
            ans[i] = j;
        }
        return ans;
    }
}

