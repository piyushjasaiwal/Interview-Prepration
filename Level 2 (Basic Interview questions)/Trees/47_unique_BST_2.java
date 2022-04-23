/*abstract
Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
Input Format
Integer n
Output Format
List of TreeNode type
Question Video

  COMMENTConstraints
1 <= n <= 8
*/

import java.util.*;

class unique_BST_2 {
  public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
      int n = scn.nextInt();
      System.out.println(catalan(n));
    }

    private static int catalan(int n) {

      if(n == 1){
        return 1;
      }

      int ans = 0;
      int i = 0;
      int j = n;
      while(i <= j){
        if(i != j){
          ans = ans + (2*(ncr(j, i)));
        }else{
          ans = ans + ((ncr(j, i)));
        }
        i++;
        j--;
      }
      return ans;
    }

    private static int ncr(int n, int r) {
      if(r == 0){
        return 1;
      }
      int ans = 1;
      while(r > 0){
        ans = ((ans*n)/r);
        r--;
      }
      return ans;
    }
}