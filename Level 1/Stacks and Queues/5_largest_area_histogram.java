/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the height of bars in a bar chart.
3. You are required to find and print the area of largest rectangle in the histogram.

e.g.
for the array [6 2 5 4 5 1 6] -> 12
Input Format
Input is managed for you
Output Format
A number representing area of largest rectangle in histogram
Question Video

  COMMENTConstraints
0 <= n < 20
0 <= a[i] <= 10
Sample Input
7
6
2
5
4
5
1
6
Sample Output
12
*/

import java.util.*;
import java.io.*;

class largest_area_histogram {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = Integer.parseInt(br.readLine());
        }
    
        // code
        System.out.println(max_area(a));
     }

    private static int max_area(int[] a) {
        if(a == null){
            return 0;
        }

        int area = Integer.MIN_VALUE;
        int [] left = new int[a.length];
        int [] right = new int[a.length];

        Stack<Integer> s = new Stack<>();
        
        int i = 0;
        while(i<a.length){
            while(!s.empty() && a[i] < a[s.peek()]){
                right[s.pop()] = i;
            }

            s.push(i);
            i++;
        }

        while(!s.empty()){
            right[s.pop()] = -1;
        }

        s = new Stack<>();

        i = a.length-1;
        while(i>=0){
            while(!s.empty() && a[i] < a[s.peek()]){
                left[s.pop()] = i;
            }

            s.push(i);
            i--;
        }

        while(!s.empty()){
            left[s.pop()] = -1;
        }

        for(i = 0;i<a.length;i++){
            int temp = 0;
            if(left[i] == -1 && right[i] == -1){
                temp = a[i]*a.length; 
            }else if(left[i] == -1 || right[i] == -1){
                if(left[i] == -1){
                    temp = a[i]*(right[i] - i + 1);
                }else{
                    temp = a[i]*(a.length - left[i] + 1);
                }
            }else{
                temp = a[i]*(right[i]-left[i]+1);
            }
            area = Math.max(area, temp);
            System.out.print(temp+" ");
        }
        System.out.println();
        display(a);
        display(left);
        display(right);
        System.out.println();
        return area;
    }

    private static void display(int[] ar) {
        System.out.println("---------------------------------------");
        for(int val : ar){
            System.out.print(val+" ");
        }
        System.out.println();
        System.out.println("---------------------------------------");
    }
}
