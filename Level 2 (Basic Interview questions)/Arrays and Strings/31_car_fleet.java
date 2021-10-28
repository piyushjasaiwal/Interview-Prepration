/*
There are n cars going to the same destination along a one-lane road. The destination is target miles away.

You are given two integer array position and speed, both of length n, where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).

A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.

The distance between these two cars is ignored (i.e., they are assumed to have the same position).

A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.

If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.

Return the number of car fleets that will arrive at the destination.

 

Example 1:

Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation: 
The cars starting at 10 and 8 become a fleet, meeting each other at 12.
The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
The cars starting at 5 and 3 become a fleet, meeting each other at 6.
Note that no other cars meet these fleets before the destination, so the answer is 3.
Example 2:

Input: target = 10, position = [3], speed = [3]
Output: 1
 

Constraints:

n == position.length == speed.length
1 <= n <= 105
0 < target <= 106
0 <= position[i] < target
All the values of position are unique.
0 < speed[i] <= 106
*/

import java.util.*;

class car_fleet{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int target = s.nextInt();
        int [] pos = new int[n];
        int [] speed = new int[n];

        for(int i = 0;i<n;i++){
            pos[i] = s.nextInt();
        }

        for(int i = 0;i<n;i++){
            speed[i] = s.nextInt();
        }

        Solution_car_fleet solution = new Solution_car_fleet();
        System.out.println(solution.carFleet(target, pos, speed));
    }
}

class Solution_car_fleet {
    public int carFleet(int target, int[] position, int[] speed) {
        car [] cars = new car[position.length];
        for(int i = 0;i<position.length;i++){
            cars[i] = new car(position[i], speed[i]);
        }
        // Arrays.sort(cars);
        // for(car c:cars){
        //     System.out.println(c);
        // }
        // return -1;
        int cnt = 0;
        double max_time = 0;
        for(car c:cars){
            int dis = target - c.pos;
            double time = (dis*1.0)/c.speed;

            if(time > max_time || Math.abs(time - max_time) < 0.01){
                cnt+=1;
                max_time = time;
            }
        }

        return cnt;
    }
}

class car implements Comparable<car>{
    int pos;
    int speed;
    public car(int p, int s){
        pos = p;
        speed = s;
    }
    @Override
    public int compareTo(car o) {
        // TODO Auto-generated method stub
        return o.pos - this.pos;
    }

    public String toString(){
        return "{ " + pos +" => " + speed + " }";
    }

}