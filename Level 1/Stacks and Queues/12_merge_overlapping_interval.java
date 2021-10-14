
/*
1. You are given a number n, representing the number of time-intervals.
2. In the next n lines, you are given a pair of space separated numbers.
3. The pair of numbers represent the start time and end time of a meeting (first number is start time and second number is end time)
4. You are required to merge the meetings and print the merged meetings output in increasing order of start time.

E.g. Let us say there are 6 meetings
1 8
5 12
14 19
22 28
25 27
27 30

Then the output of merged meetings will belongs
1 12
14 19
22 30

Note -> The given input maynot be sorted by start-time.
Input Format
Input is managed for you 
Output Format
Print a merged meeting start time and end time separated by a space in a line
.. print all merged meetings one in each line.
Question Video

  COMMENTConstraints
1 <= n <= 10^4
0 <= ith start time < 100
ith start time < ith end time <= 100
Sample Input
6
22 28
1 8
25 27
14 19
27 30
5 12
Sample Output
1 12
14 19
22 30
*/
import java.io.*;
import java.util.*;

class merge_overlapping_interval {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Stack<int []> s = new Stack<>();
        Arrays.sort(arr, new comp());

        for(int [] ar: arr){
            if(s.empty()){
                s.push(ar);
            }else{
                if(s.peek()[1] < ar[0]){
                    s.push(ar);
                }else{
                    int [] pop = s.pop();
                    pop[1] = Math.max(pop[1], ar[1]);
                    s.push(pop);
                }
            }
        }

        Stack<int []> s2 = new Stack<>();
        while(!s.empty()){
            s2.push(s.pop());
        }

        s = s2;
        s2 = null;
        while(!s.empty()){
            int []a = s.pop();
            System.out.println(a[0]+" "+a[1]);
        }
    }
}

class comp implements Comparator<int []>{

    @Override
    public int compare(int[] o1, int[] o2) {
        // TODO Auto-generated method stub
        return o1[0] - o2[0];
    }
    
}
