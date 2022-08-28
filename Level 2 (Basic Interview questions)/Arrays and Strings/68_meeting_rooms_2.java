/*
 * 1. Question will be provided with "n" meeting-schedules. A meeting-schedule is defined as (sp,ep) i.e. sp --> starting point &  ep --> ending point of an meeting. Some meeting-schedules may or maynot overlap each other.
2. MeetingIntervals[i] = [startingPointi,endingPointi]
3. A meeting-schedule represents meeting time(i.e. starting time & ending time).

Task is to "figure out, how many minimum number of meeting rooms are required to schedule all meetings?".

Example 1 : 
    Input : [[1,3],[2,4],[6,8],[10,14],[7,9]]
    Output : 2
    Explanation : Two meetings are scheduled are scheduled at a time i.e. we require atleast 2 meeting rooms to schedule meetings.

Example 2 : 
    Input : [[1,3],[3,10],[12,20]]
    Output : 1
    Explanation : There is no meeting-schedule overlap i.e. 1 meetng room can do the trick.
Example 3 : 
    Input : [[1,3],[5,8],[10,19],[15,20],[9,9]]
    Output : 2.
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
print minimum number of meeting rooms required to accommodate all meetings.
(Output Format is handled for you.)
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
2
 */

import java.util.*;


class meeting_rooms_2 {
  public static int meetingRooms(int intervals[][]) {
    // write your code here
    int [] sp = new int[intervals.length];
    int [] ep = new int[intervals.length];

    for(int i = 0;i<intervals.length;i++){
        sp[i] = intervals[i][0];
        ep[i] = intervals[i][1];
    }

    Arrays.sort(sp);
    Arrays.sort(ep);

    int max_meetings = 0;
    int rooms_required = 0;

    int i = 0, j = 0;

    while(i < intervals.length && j < intervals.length){
        if(sp[i] < ep[j]){
            max_meetings++;
            i++;
        }else{
            max_meetings--;
            j++;
        }

        rooms_required = Math.max(rooms_required, max_meetings);
    }

    return rooms_required;
  }
  public static void main(String args[]) {
    Scanner scn = new Scanner(System.in);

    // Input Format
    int n = scn.nextInt();
    int input[][] = new int[n][2];

    for (int i = 0 ; i <  n ; i++) {
      int sp = scn.nextInt();
      int ep = scn.nextInt();

      input[i][0] = sp;
      input[i][1] = ep;
    }

    // Output Format
    System.out.println(meetingRooms(input));
  }
}