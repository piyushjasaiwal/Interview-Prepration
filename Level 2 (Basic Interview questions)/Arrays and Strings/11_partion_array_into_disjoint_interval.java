/*
1. Given an integer array nums.
2. Partition it into two (contiguous) subarrays left and right so that:
    a. Every element in left is less than or equal to every element in right.
    b. Left and right are non-empty.
    c. Left has the smallest possible size.
3. Return the length of left after such a partitioning.
NOTE : Test cases are generated such that partitioning exists.
Input Format
Input is Managed for You
nums = [5,0,3,8,6]

nums = [1,1,1,0,6,12]
Output Format
3
Explanation: left = [5,0,3], right = [8,6]

4
Explanation: left = [1,1,1,0], right = [6,12]
Question Video

  COMMENTConstraints
1. 2 <= nums.length <= 10^5
2. 0 <= nums[i] <= 10^6
3. There is at least one valid answer for the given input.
Sample Input
5
5 0 3 8 6
Sample Output
3
*/

// import java.util.*;

// class partion_array_into_disjoint_interval {

//   // ~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~
//   public static int partitionDisjoint(int[] arr) {
//     // write your code here
    
//   }

//   // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
//   public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);
//     int n = scn.nextInt();
//     int[] arr = new int[n];

//     for (int i = 0; i < n; i++) {
//       arr[i] = scn.nextInt();
//     }

//     int len = partitionDisjoint(arr);
//     System.out.println(len);
//   }
// }
 