/*abstract
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the height of bars in a bar chart.
3. You are required to find and print the area of largest rectangle in the histogram.

Challenge. Could u solve it in one iteration.
Note. This question is same as Largest Area Histogram just the constrains are higher.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1. 1 <= heights.length <= 10^5
2. 0 <= heights[i] <= 10^4
Sample Input
6
2
1
5
6
2
3
Sample Output
10
*/

import java.io.*;
import java.util.*;

class largest_area_histogram_two {
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

        int n = Integer.parseInt(read.readLine());
        int heights[] = new int[n];
        for(int i=0;i<n;i++)heights[i] = Integer.parseInt(read.readLine());

        System.out.println(largestRectangleArea(heights));
        
    }
}
