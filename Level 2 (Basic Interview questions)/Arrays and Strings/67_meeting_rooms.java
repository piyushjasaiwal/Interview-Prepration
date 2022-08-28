/*
 * 1. Question will be provided with "n" meeting-schedules. A meeting-schedule is defined as (sp,ep) i.e. sp --> starting point &  ep --> ending point of an meeting. Some meeting-schedules may or maynot overlap each other.
2. MeetingIntervals[i] = [startingPointi,endingPointi]
3. A meeting-schedule represents meeting time(i.e. starting time & ending time).

Task is to "figure out, whether is it possible to attend all meetings or not".
Input Format
n (Representing number of Meetings scheduled)
sp_1 ep_1
sp_2 ep_2
sp_3 ep_3
... till "n" Intervals
Note :
    1. sp_1 means starting point for meeting 1 , ep_1 means ending point for meeting 1
    2. Input format is handled for you.
Output Format
Output Format is handled for you.
Question Video

  COMMENTConstraints
1. sp(Starting point) <= ep(Ending Point)
2. input is unsorted
3.  0 < n(Number of Meetings Scheduled) <= 10^4
Sample Input
5
1 3
8 10
7 8
9 15
2 6
Sample Output
false
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


class meeting_rooms{
    public static boolean meetingRooms(int intervals[][]){
        // write code here

        if(intervals.length == 0){
            return true;
        }

        Arrays.sort(intervals, new comp());

        int pre_max_end = intervals[0][1];

        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0] < pre_max_end){
                return false;
            }
            pre_max_end = Math.max(pre_max_end, intervals[i][1]);
        }

        return true;

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
        boolean res = meetingRooms(input);
        System.out.println(res);
    }

    static class comp implements Comparator<int[]>{

        @Override
        public int compare(int[] o1, int[] o2) {
            // TODO Auto-generated method stub
    
            if(o1[0] != o2[0]){
                return o1[0] - o2[0];
            }
    
            return o1[1] - o2[1];
        }
        
    }
}

