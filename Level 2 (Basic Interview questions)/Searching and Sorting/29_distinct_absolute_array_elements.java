/*abstract
Given a sorted array of size N. Count the number of distinct absolute values present in the array.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= N <= 10^5
-10^8 <= Arr[i] <= 10^8
The array may contain duplicates
Sample Input
6
-3 -2 0 3 4 5
Sample Output
5
*/

import java.util.*;
import java.io.*;

class distinct_absolute_array_elements {

    public static int count(int[]arr) {
        //write your code here
        HashSet<Integer> set = new HashSet<>();
        for(int val:arr){
            set.add(Math.abs(val));
        }
        return set.size();
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println(count(arr));
    }
}