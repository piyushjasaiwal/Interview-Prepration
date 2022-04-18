/*abstract
1. Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.
2. Every house can be warmed, as long as the house is within the heater's warm radius range. 
3. Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.
4. Notice that all the heaters follow your radius standard, and the warm radius will the same.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= houses.length, heaters.length <= 3 * 10^4
1 <= houses[i], heaters[i] <= 10^9
Sample Input
4
1 2 5 7
2
1 4
Sample Output
3
*/

import java.util.*;

import javax.swing.text.StyleConstants.FontConstants;

import java.io.*;

class heaters {
    public static int findRadius(int[]houses, int[]heaters) {
        //write your code here
        ArrayList<Integer> temp = new ArrayList<>();
        for(int val:heaters){
            temp.add(val);
        }

        Collections.sort(temp);
        for(int i = 0;i<heaters.length;i++){
            heaters[i] = temp.get(i);
        }

        int ans = Integer.MIN_VALUE;

        for(int val:houses){
            int find = findCeilFloor(val, heaters);
            ans = Math.max(ans, find);
        }
        return ans;
    }

    private static int findCeilFloor(int val, int[] heaters) {
        int ceil = -1;
        int floor = -1;

        //for finding ceil
        int lo = 0;
        int hi = heaters.length-1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(heaters[mid] >= val){
                ceil = heaters[mid];
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }

        //for finding floor
        lo = 0;
        hi = heaters.length-1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(heaters[mid] <= val){
                floor = heaters[mid];
                lo = mid+1;
            }else{
                hi = mid+-1;
            }
        }

        if(ceil == -1){
            return Math.abs(val-floor);
        }

        if(floor == -1){
            return Math.abs(val-ceil);
        }

        return Math.min(Math.abs(val-floor), Math.abs(val-ceil));
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]houses = new int[n];

        for (int i = 0; i < n; i++) {
            houses[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int[]heaters = new int[m];

        for (int i = 0; i < m; i++) {
            heaters[i] = scn.nextInt();
        }

        System.out.println(findRadius(houses, heaters));
    }
}