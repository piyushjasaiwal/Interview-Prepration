/*abstract
1. Question will be provided with two Intervals Lists.
2. An interval is is defined as (sp,ep) i.e. sp --> starting point &  ep --> ending point of an interval
3. All intervals are closed in nature
4. Intervals[i] = [startingPointi,endingPointi]
5. Both interval lists are sorted in nature(sorted based upon starting time of each interval).

Task is to "find & print all intersection of intervals from both interval lists(intervals from list 1 & list 2).".

Example 1 : 
    list_1 : [[1,3]] 
    list_2 : [[2,5]]
    Output : [[2,3]]
    Explanation : interval from list 1 starts @ 1 & ends @ 3 where as interval from list 2 starts @ 2 & ends @ 5 thus intersection(time span common in intervals from both lists) is {2,3}.

Example 2 : 
    list_1 : [[1,3]] 
    list_2 : [[4,5]]
    Output : []
    Explanation : there is no common time-span(i.e. no intersection)  between intervals from both given list.
Example 3 : 
    list_1 : [[1,3] [5,10] [12,17]] 
    list_2 : [[2,4] [5,7] [9,13]]
    Output : [[2,3] [5,7] [9,10] [12,13]]
Input Format
n (Representing number of intervals in list 1)
input of "n" intervals for list 1 (startTime-endTime space seperated)
m (Representing number of intervals in list 2)
input of "m" intervals for list 2 (startTime-endTime space seperated)

Note :
    1. startTime <= endTime
    2. Given lists will be sorted. 
    3. Input format is handled for you.
Output Format
print all intersection of intervals from both interval lists(intervals from list 1 & list 2)
(Output Format is handled for you.)
Question Video

  COMMENTConstraints
1. sp(Starting point) <= ep(Ending Point)
2. both interval lists are sorted(based upon start-time)
3.  0 <= (Number of intervals in each list) <= 10^4
4. there are no overlapping intervals in their respective interval-list.
Sample Input
1
1 3
1
2 5
Sample Output
[[2, 3]]
*/

import java.util.*;

class interval_list_intersection {

    

    public static int[][] intersection(int intervalList1[][], int intervalList2[][]) {
        // write your code here
        ArrayList<int[]> temp = new ArrayList<>();

        Arrays.sort(intervalList1, new comp());
        Arrays.sort(intervalList2, new comp());

        int i = 0;
        int j = 0;
        
        while(i < intervalList1.length && j < intervalList2.length){
            int csp = Math.max(intervalList1[i][0], intervalList2[j][0]);
            int esp = Math.min(intervalList1[i][1], intervalList2[j][1]);

            if(csp <= esp){
                temp.add(new int[]{csp, esp});
            }

            if(intervalList1[i][1] < intervalList2[j][1]){
                i++;
            }else{
                j++;
            }
        }

        int [][] ans = new int[temp.size()][2];
        for(i = 0;i<temp.size();i++){
            ans[i] = temp.get(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // Input format
        int n = scn.nextInt();
        int list1[][] = new int[n][2];
        for (int i = 0 ; i < n ; i++) {
        list1[i][0] = scn.nextInt();
        list1[i][1] = scn.nextInt();
        }

        int m = scn.nextInt();
        int list2[][] = new int[m][2];
        for (int i = 0 ; i < m ; i++) {
        list2[i][0] = scn.nextInt();
        list2[i][1] = scn.nextInt();
        }

        // output
        int ans[][] = intersection(list1, list2);
        System.out.print("[");
        for (int interval[] : ans) {
        System.out.print(Arrays.toString(interval));
        }
        System.out.println("]");
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
