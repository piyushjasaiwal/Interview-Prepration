/*abstract
1. Question will be provided with "n" Intervals. An Interval is defined as (sp,ep) i.e. sp --> starting point &  ep --> ending point of an Interval (sp/ep are inclusive). Some Intervals may or maynot overlap eachother.
2. Intervals[i] = [startingPoint,endingPoint]
Task is to "Merge all Overlapping Intervals".

Example 1 : 
    Input : [[1,3],[2,4],[6,8],[10,14],[7,9]]
    Output : [[1,4],[6,9],[10,14]]

Example 2 : 
    Input : [[1,3],[3,15],[6,8],[10,14],[7,9]]
    Output : [[1,3][3,15]]

Example 3 : 
    Input : [[1,3],[5,8],[10,19],[15,20],[9,9]]
    Output : [[1,3],[5,8],[9,9],[10,20]]

Note : If ending time of interval I1 is same as starting time of I2 then both will consider as separate Intervals.
Input Format
n (Representing number of Intervals)
sp_1 ep_1
sp_2 ep_2
sp_3 ep_3
... till "n" Intervals
Note :
    1. sp_1 means starting point for interval 1 , ep_1 means ending point for interval 1
    2. Input format is handled for you.
Output Format
Output Format is handled for you.
Question Video

  COMMENTConstraints
1. sp(Starting point) <= ep(Ending Point)
2. input is unsorted
3.  0 < n(Number of Intervals) <= 10^4
Sample Input
5
1 3
8 10
7 8
9 15
2 6
Sample Output
[[1, 6][7, 8][8, 15]]
*/

import java.util.*;

class merge_interval{

    static class comp implements Comparator<int[]>{

        @Override
        public int compare(int[] a, int[] b) {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }

            return a[1] - b[1];
        }
        
    }

    public static int[][] mergeIntervals(int intervals[][]){
        // write your code here

        if(intervals.length == 0){
            return new int[0][0];
        }

        ArrayList<int[]> list = new ArrayList<>();

        // for(int [] interval:intervals){
        //     for(int val:interval){
        //         System.out.print(val+" ");
        //     }
        //     System.out.println();
        // }
        Arrays.sort(intervals, new comp());
        // System.out.println("----------------------------------------");
        // for(int [] interval:intervals){
        //     for(int val:interval){
        //         System.out.print(val+" ");
        //     }
        //     System.out.println();
        // }

        int prev_start = intervals[0][0];
        int prev_end = intervals[0][1];

        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0] >= prev_end){
                list.add(new int[]{prev_start, prev_end});
                prev_start = intervals[i][0];
                prev_end = intervals[i][1];
            }else{
                prev_end = Math.max(prev_end, intervals[i][1]);
            }
        }

        list.add(new int[]{prev_start, prev_end});
        // System.out.println(list);

        // for(int [] val:list){
        //     System.out.println(val[0] +" " + val[1]);
        // }

        int [][] ans = new int[list.size()][2];
        int i = 0;
        for(int [] val:list){
            ans[i] = val;
            i++;
        }

        return ans;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        // Input Format
        int n = scn.nextInt();
        int input[][] = new int[n][2];

        for(int i = 0 ; i <  n ; i++){
            int sp = scn.nextInt();
            int ep = scn.nextInt();

            input[i][0] = sp;
            input[i][1] = ep;
        }

        // Output Format
        int [][]output = mergeIntervals(input);

        System.out.print("[");
        for(int arr[] : output){
            System.out.print(Arrays.toString(arr));
        }
        System.out.println("]");
    }
}