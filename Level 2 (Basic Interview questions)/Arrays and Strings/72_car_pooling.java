/*abstract
1. A car moving in east direction has to make some pickups/drops(passengers) on the way.
2. Car has a limited capacity to carry passengers.
3. Given a List of Trips i.e. trip[i] = [pickup_location,drop_Location,num_passengers] , find out whether it is possible to make all trips on the way or not.
NOTE: Car will only move in east directions i.e. no turn-around trip is possible.


Task is to "Find out whether it is possible to make all trips on the way[YES] or not[NO]".


Example 1 : 
    trip[] = [[1,5,2],[4,8,1],[11,15,3]]
    passengerCapacity : 3
    output : YES
    

Example 2 : 
    trip[] : [[1,3,5]]
    passengerCapacity : 4;
    output : NO

Example 3 :
    trip[] : []
    passengerCapacity : 2
    output : YES

Example 4 : 
    trip[] = [[1,5,2],[4,8,2],[11,15,3]]
    passengerCapacity : 3
    output : NO
Input Format
A Number "n" (no. of trips)
pl1 dl1 p1
pl2 dl2 p2
pl3 dl3 p3
pl4 dl4 p4
.
.
.
pln dln pn
A number "cap" (maximum passenger capacity of the car)
NOTE : 1. pli is pickup location of ith trip.
       2. dli is drop location of ith trip.
       3. pi is passenger count for ith trip.
       4. Input is handled for you.
Output Format
"Find out whether it is possible to make all trips on the way[YES] or not[NO]"
(Output Format is handled for you.)
Question Video

  COMMENTConstraints
1. 0 <= n(number of trips) <= 10^3
2. 0 <= trip[i][0](pickup_location) <= 1000
3. pickup_location <= trip[i][1](drop_Location) <= 1000
4. 1 <= num_passengers <= 1000000
5. 0 < passengerCapacity < 1000000
Sample Input
3
1 5 2
4 8 1
11 15 3
3
Sample Output
YES
*/

import java.util.Scanner;

class car_pooling {
    public static boolean carPooling(int trips[][], int cap) {
        // write your code here
        System.out.println(cap);

        long [] location = new long[30];
        for(int [] trip : trips){
            location[trip[0]] += trip[2];
            location[trip[1]] -= trip[2];
        }

        long sum = 0;
        for(long val : location){
            sum += val;
            if(sum > cap){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int trips[][] = new int[n][3];
        for (int i = 0 ; i < n ; i++) {
            trips[i][0] = scn.nextInt();
            trips[i][1] = scn.nextInt();
            trips[i][2] = scn.nextInt();
        }
        int cap = scn.nextInt();

        if (carPooling(trips, cap)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
