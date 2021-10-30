/*abstract 
1. Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
2. In Pascal's triangle, each number is the sum of the two numbers directly above OR it is also a pattern which can be made from combination maths
3. For More clearance, watch video till explanation of question.
eg. 
row 0 -> 1
row 1 -> 1 1
row 2 -> 1 2 1
row 3 -> 1 3 3 1
row 4 -> 1 4 6 4 1
Input Format
rowIndex = 3
Output Format
1 3 3 1
Question Video

  COMMENTConstraints
1. 0 <= rowIndex <= 33
Sample Input
3
Sample Output
1 3 3 1 
*/

// formula used will be (n)C(r+1) = (n)C(r)*((n-i)/(i+1))

import java.util.*;

class Pascals_triangle_2 {

  // ~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
  public static ArrayList<Integer> pascalRow(int n) {
    // write your code here
    ArrayList<Integer> ans = new ArrayList<>();
    int val = 1;
    for(int i = 0;i<=n;i++){
        ans.add(val);
        val = val * (n-i) / (i+1);
    }
    return ans;
  }

// ~~~~~~~~~~~Input management~~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    ArrayList<Integer> res = pascalRow(n);
    for (Integer val : res) {
      System.out.print(val + " ");
    }
    System.out.println();
  }
}