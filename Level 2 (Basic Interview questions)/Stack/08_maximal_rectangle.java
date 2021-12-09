/*abstract
1. Given a rows x cols binary matrix filled with 0's and 1's.
2. Find the largest rectangle containing only 1's and return its area.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1. 1 <= row, cols <= 200
2. matrix[i][j] is 0 or 1.
Sample Input
2
5
10100
10111
Sample Output
3
*/

import java.io.*;
import java.util.*;

class maximal_rectangle {

    public static int maximalRectangle(int[][] ar) {           
        int [] heights = new int[ar[0].length];
        
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<ar.length;i++){
            for(int j = 0;j<ar[0].length;j++){
                if(ar[i][j] == 0){
                    heights[j] = 0;
                }else{
                    heights[j]+=1;
                }
            }

            max = Math.max(max, largestRectangleArea(heights));
        }

        return max;
    }

    public static int largestRectangleArea(int[] heights) {
        int [] next_smaller = new int[heights.length];
        int [] previous_smaller = new int[heights.length];
        Stack<Integer> s = new Stack<>();
        int i = 0;
        
        s.push(i);
        while(i<heights.length){
            while(!s.empty() && heights[i] < heights[s.peek()]){
                next_smaller[s.pop()] = i;
            }
            s.push(i);
            i++;
        }

        while(!s.empty()){
            next_smaller[s.pop()] = heights.length;
        }

        i = heights.length-1;
        
        s.push(i);
        while(i>=0){
            while(!s.empty() && heights[i] < heights[s.peek()]){
                previous_smaller[s.pop()] = i;
            }
            s.push(i);
            i--;
        }

        while(!s.empty()){
            previous_smaller[s.pop()] = -1;
        }

        int max = -1;

        for(i = 0;i<heights.length;i++){
            max=Math.max(max, heights[i]*(next_smaller[i]-previous_smaller[i]-1));
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int row = Integer.parseInt(read.readLine());
        int col = Integer.parseInt(read.readLine());
        
        int bmat[][] = new int[row][col];

        for(int i=0;i<row;i++){
            String s = read.readLine();
            for(int j=0;j<col;j++){
                bmat[i][j] = s.charAt(j)-'0';
            }
        }

        int result = maximalRectangle(bmat);
        System.out.println(result);
        
    }
}
