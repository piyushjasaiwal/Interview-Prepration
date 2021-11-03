/*abstract
1. You are given an array which represents heights of consecutive buildings.
2. You can move from the roof of a building to the roof of next adjacent building. 
3. You need to find the maximum number of consecutive steps you can put forward such that you gain an increase in altitude with each step.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= N <= 10^6
1 <= A[i] <= 10^5
Sample Input
7
1 4 5 2 3 2 4
Sample Output
2
*/

import java.util.*;

class roof_top {

    public static int findMaxSteps(int[]arr) {
        //write your code here
        int max = Integer.MIN_VALUE;
        int i = 0;
        while(i<arr.length){
            int j = i;
            while(j != arr.length - 1 && arr[j] < arr[j+1]){
                j++;
            }

            max = Math.max(max, j-i);
            i = j+1;
        }

        return max;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findMaxSteps(arr);
        System.out.println(ans);
    }
}