/*abstract
1. We have arrival and departure times of all trains that reach a railway station. 
2. We have to find the minimum number of platforms required for the railway station so that no train is kept waiting.
3. Consider that all the trains arrive on the same day and leave on the same day. 
4. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. 
5. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.
Input Format
n = 6 
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output Format
3
Question Video

  COMMENTConstraints
1. 1 <= no. of trains <= 10000
2. 0000 <= Arrival[i] < Departure[i] <= 2359
Sample Input
6 
0900 0940 0950 1100 1500 1800
0910 1200 1120 1130 1900 2000
Sample Output
3
*/

import java.util.*;

class minimum_Platforms {

  public static int findPlatform(int[] arr, int[] dep) {
    // write your code here
    Arrays.sort(arr);
    Arrays.sort(dep);

    

    return 0;
  }

  static class Pair implements Comparable<Pair>{
    int arr;
    int dep;
    Pair(int a, int d){
        arr = a;
        dep = d;
    }

    public int compareTo(Pair o){
        return dep-o.dep;
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int[] dep = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    for (int i = 0; i < n; i++) {
      dep[i] = scn.nextInt();
    }

    int plateforms = findPlatform(arr, dep);
    System.out.println(plateforms);
  }
}