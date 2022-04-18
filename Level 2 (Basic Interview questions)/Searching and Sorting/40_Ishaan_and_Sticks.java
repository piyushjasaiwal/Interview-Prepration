/*abstract
Ishaan has a craving for sticks. He has N sticks. He observes that some of his sticks are of the same length, and thus he can make squares out of those.
He wants to know how big a square he can make using those sticks as sides. Since the number of sticks is large, he can't do that manually. Can you tell him the maximum area of the biggest square that can be formed?
Also, calculate how many such squares can be made using the sticks.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
 1 <= N <= 10^5
1 <= arr[i] <= 10^3
Sample Input
10
3 3 4 4 3 4 3 1 4 2
Sample Output
16 1
*/

import java.util.*;
import java.io.*;

class Ishaan_and_Sticks {

    public static ArrayList<Integer> solve(int[]arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val:arr){
            map.put(val, map.getOrDefault(val, 0)+1);
        }

        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        int biggest = -1;

        for(int key:keys){
            if(key >= biggest && map.get(key) >= 4){
                biggest = key;
            }
        }

        ans.add(biggest*biggest);
        ans.add(map.get(biggest)/4);        
        return ans;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer>ans = solve(arr);

        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}