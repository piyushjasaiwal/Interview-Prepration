// /*
// 1. Given an integer array nums.
// 2. Partition it into two (contiguous) subarrays left and right so that:
//     a. Every element in left is less than or equal to every element in right.
//     b. Left and right are non-empty.
//     c. Left has the smallest possible size.
// 3. Return the length of left after such a partitioning.
// NOTE : Test cases are generated such that partitioning exists.
// Input Format
// Input is Managed for You
// nums = [5,0,3,8,6]

// nums = [1,1,1,0,6,12]
// Output Format
// 3
// Explanation: left = [5,0,3], right = [8,6]

// 4
// Explanation: left = [1,1,1,0], right = [6,12]
// Question Video

//   COMMENTConstraints
// 1. 2 <= nums.length <= 10^5
// 2. 0 <= nums[i] <= 10^6
// 3. There is at least one valid answer for the given input.
// Sample Input
// 5
// 5 0 3 8 6
// Sample Output
// 3
// */

// import java.util.*;

// class partion_array_into_disjoint_interval {

//   // ~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~
//   public static int partitionDisjoint_using_O_N_space(int[] arr) {
//     // write your code here
//     int [] right_min = new int[arr.length+1];
//     int [] left_max = new int[arr.length];
//     int min = Integer.MAX_VALUE;
//     right_min[arr.length] = min;

//     for(int i = arr.length-1;i>=0;i--){
//       min = Math.min(min, arr[i]);
//       right_min[i] = min;
//     }

//     int max = Integer.MIN_VALUE;
//     for(int i = 0;i<arr.length;i++){
//       max = Math.max(max, arr[i]);
//       left_max[i] = max;
//     }

//     // for(int val:right_min){
//     //   System.out.print(val+" ");
//     // }
//     // System.out.println();

//     // for(int val:left_max){
//     //   System.out.print(val+" ");
//     // }
//     // System.out.println();

    

//     for(int i = 0;i<arr.length;i++){
//       if(left_max[i] <= right_min[i+1]){
//         return i+1;
//       }
//     }
//     return -1;
//   }

//   public static int partitionDisjoint_using_O_1_space(int [] arr){
//     int left_index = 0;
//     int left_max = Integer.MIN_VALUE;
//     for(int i = 0;i<arr.length;i++){
//       if(arr[i] <= left_max){
//         left_index = i;
//       }else{
//         left_index
//       }
//     }
//     return left_index+1;
//   }
//   // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
//   public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);
//     int n = scn.nextInt();
//     int[] arr = new int[n];

//     for (int i = 0; i < n; i++) {
//       arr[i] = scn.nextInt();
//     }

//     // int len = partitionDisjoint_using_O_N_space(arr);
//     int len = partitionDisjoint_using_O_1_space(arr);
//     System.out.println(len);
//   }
// }
 