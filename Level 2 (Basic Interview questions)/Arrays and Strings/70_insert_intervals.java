/*abstract
1. IntervalList & a newInterval will be given as input.
2. IntervalList is a sequence of sorted(on the basis of start time) & non-overlapping intervals.
3. any interval[i] (from IntervalList) = [startTime,endTime].
4. a newInterval will also be passed as input.
Task is to "Insert this newInterval to the given sorted IntervalList".
NOTE : Inserting this newInterval may lead to merging of intervals.

Example 1 : 
    IntervalList = [[1,5][8,10]]
    newInterval = [3,8]
    OUTPUT : [[1,10]].
    Explanation : after inserting newInterval (3,8) ,every interval can now be merged to (1,10).

Example 2 : 
    IntervalList = [[1,5][8,10]]
    newInterval = [3,6]
    OUTPUT : [[1,6][8,10]].

Example 3 :
    IntervalList = [[3,5][8,10]]
    newInterval = [1,2]
    OUTPUT : [[1,2][3,5][8,10]].
    
Example 4 : 
    IntervalList = []
    newInterval = [3,8]
    OUTPUT : [[3,8]].
Input Format
A Number "n" (no. of intervals in IntervalList)
startTime1 endTime1
startTime2 endTime2
startTime3 endTime3
... input for n intertavals

newStartTime newEndTime (newInterval)

Note :
    1. startTime <= endTime
    2. Given IntervalList will be sorted(based upon startTime) & non-overlapping. 
    3. Input format is handled for you.
Output Format
"Insert newInterval to the given sorted IntervalList"
(Output Format is handled for you.)
Question Video

  COMMENTConstraints
1. Interval[i] = [startTime,endTime]
2. 0 <= startTime <= endTime
3. 0 <= length(IntervalList) <= 10^4
4. newInterval = (startTime,endTime)
5. length(newInterval) = 2;
Sample Input
5
1 5
7 9
10 13
16 19
20 25
12 20
Sample Output
[[1, 5][7, 9][10, 25]]
*/

import java.util.*;

class insert_intervals {

    public static int[][] insertIntervals(int intervalList[][], int newInterval[]) {
        // write your code here
        return null;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int intervalList[][] = new int[n][2];
        for (int i = 0 ; i < n ; i++) {
            int st = scn.nextInt();
            int et = scn.nextInt();

            intervalList[i][0] = st;
            intervalList[i][1] = et;
        }
        int newInterval[] = new int[2];
        newInterval[0] = scn.nextInt();
        newInterval[1] = scn.nextInt();

        int ans[][] = insertIntervals(intervalList, newInterval);

        System.out.print("[");
        for (int interval[] : ans) {
            System.out.print(Arrays.toString(interval));
        }
        System.out.println("]");

    }
}