/*abstract
1: Given two sequences pushed and popped with distinct values.
2: You have to return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1: pushed is a permutation of popped
2: pushed and popped have distinct values
Sample Input
1 2 3 4 5
4 5 3 2 1
Sample Output
true
*/

import java.io.*;
import java.util.*;

class validate_stack_sequence {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        // Write Your's code here

        if(pushed.length != popped.length){
            return false;
        }
        int j = 0;
        Stack<Integer> s = new Stack<>();

        for(int e:pushed){
            s.push(e);
            while(!s.empty() && s.peek() == popped[j]){
                j++;
                s.pop();
            }
        }

        return j == popped.length;
    }

    public static int[] getArr(String s){
        String nums[] = s.split(" ");
        int n = nums.length;
        int ar[] = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = Integer.parseInt(nums[i]);
        }
        return ar;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int pushed [] = getArr(read.readLine());
        int popped [] = getArr(read.readLine());
        
        boolean result = validateStackSequences(pushed, popped);

        System.out.println(result);
    }
}