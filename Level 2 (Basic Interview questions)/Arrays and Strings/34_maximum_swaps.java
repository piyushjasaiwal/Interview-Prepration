/*
1. You are given a number in form of String. 
2. You can swap two digits at most once to get the maximum valued number in that string.
3. Return the maximum valued number you can get in form of string.
Input Format
num = "2736"
Output Format
res = "7236"
Explanation : swap 2 and 7 to get maximum values
Question Video

  COMMENTConstraints
0 < num.lenght() < 10^5
Sample Input
2736
Sample Output
7236
*/

import java.util.*;

class maximum_swaps {

  // ~~~~~~~~~~User Section~~~~~~~~~~~
  public static String maximumSwap(String num) {
    // write your code here
    int [] max = new int[num.length()];
    int max_idx = num.length()-1;
    char [] nums = num.toCharArray();

    for(int i = num.length()-1;i>=0;i--){
        if(nums[i] >= nums[max_idx]){
            max_idx = i;
        }

        max[i] = max_idx;
    }

    for(int i = 0;i<max_idx;i++){
        if(nums[max[i]] != nums[i]){
            char ch = nums[i];
            nums[i] = nums[max[i]];
            nums[max[i]] = ch;
            for(int val : max){
              System.out.print(nums[val]+" ");
            }
            System.out.println();
            return new String(nums);
        }
    }
    for(int val : max){
      System.out.print(nums[val]+" ");
    }
    System.out.println();

    for(int val : max){
      System.out.print(val+" ");
    }
    System.out.println();


    return new String(nums);
  }

  // ~~~~~~~~Input Management~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    String ans = maximumSwap(str);
    System.out.println(ans);
  }
}