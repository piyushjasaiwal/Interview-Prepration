/*
1. Given an integer array 'arr',
2. Find three numbers whose product is maximum and return the maximum product.
Input Format
(Already managed for you)
4
1 2 3 4
Output Format
(Already managed for you)
24
Question Video

  COMMENTConstraints
1. 3 <= nums.length <= 10^4
2. -1000 <= nums[i] <= 1000
Sample Input
6
3 2 -4 -6 5 1
Sample Output
120
*/


import java.util.*;

class max_product_of_three_number {

    // ~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~
    public static int maximumProduct(int[] arr) {
        // write your code here
        int n = arr.length;
        Arrays.sort(arr);
        return Math.max(Math.max(arr[0]*arr[n-1]*arr[n-2], arr[n-1]*arr[n-2]*arr[n-3]), arr[0]*arr[1]*arr[n-1]);
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int prod = maximumProduct(arr);
        System.out.println(prod);
    }
}