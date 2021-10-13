/*
1. Given an integer array of size 'n'.
2. Return an array answer such that answer[i] is equal to the product of all the elements of arr except arr[i].
3. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
Input Format
N -> size of array.
N distinct elements n0 n1, n2, . , . , . nN.
Output Format
print Final res
Question Video

  COMMENTConstraints
1. 2 <= arr.length <= 10^5
2. -30 <= arr[i] <= 30
3. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
Sample Input
4
1 2 3 4
Sample Output
24 12 8 6
*/

import java.util.*;

class product_of_array_without_self_without_division {
    //~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
    public static int[] productExceptSelf(int[] arr) {
        // write your code here
        int [] ans = new int[arr.length];
        int prod = 1;
        for(int i = 0;i<arr.length;i++){
            ans[i] = prod;
            prod *= arr[i];
        }
        prod = 1;
        for(int i = arr.length-1;i>=0;i--){
            ans[i] *= prod;
            prod *= arr[i];
        }

        return ans;
    }

    //~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] res = productExceptSelf(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
