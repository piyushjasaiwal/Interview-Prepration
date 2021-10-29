/*abstract
1. In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. 
2. A domino(Dice Structured) is a tile with two numbers from 1 to 6 - one on each half of the tile.
3. We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
4. Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
5. If it cannot be done, return -1.
Input Format
tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
Output Format
2
Explanation: 
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

-1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
Question Video

  COMMENTConstraints
1. 2 <= tops.length == bottoms.length <= 2 * 10^4
2. 1 <= tops[i], bottoms[i] <= 6
Sample Input
6
5 3 5 6 2 5 
4 5 4 5 5 5
Sample Output
2*/

import java.util.*;

class minimum_domino_rotation {

    //~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        // write your code here
        int min_rotation = Integer.MAX_VALUE;
        for(int i = 1;i<=6;i++){
            min_rotation = Math.min(min_rotation, min_rotation_domino(tops, bottoms, i));
        }
        return min_rotation == Integer.MAX_VALUE ? -1 : min_rotation;
    }



    private static int min_rotation_domino(int[] tops, int[] bottoms, int des) {
        int cnt_up = 0;
        int cnt_down = 0;

        for(int i = 0;i<tops.length;i++){
            if(tops[i] != des && bottoms[i] != des){
                return Integer.MAX_VALUE;
            }
            if(tops[i] != des){
                cnt_up++;
            }

            if(bottoms[i] != des){
                cnt_down++;
            }
        }

        return Math.min(cnt_down, cnt_up);
    }



    //~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];

        // read top
        for (int i = 0; i < top.length; i++) {
        top[i] = scn.nextInt();
        }
        // read bottom
        for (int i = 0; i < bottom.length; i++) {
        bottom[i] = scn.nextInt();
        }

        int rotation = minDominoRotations(top, bottom);
        System.out.println(rotation);
    }
}