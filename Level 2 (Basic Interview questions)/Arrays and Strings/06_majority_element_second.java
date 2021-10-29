/*
1. Given an integer array of size 'n'.
2. Find all elements that appear more than n / 3 times and return it in an arraylist.
3. Note : solve the problem in linear time and in O(1) space.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1. 1 <= arr.length <= 10^4
2. -10 ^ 9 <= arr[i] <= 10^9
Sample Input
3
3 2 3
Sample Output
[3]
*/

import java.util.*;

class majority_element_second {
   // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
    public static ArrayList<Integer> majorityElement2(int[] arr) {
        // write your code here
        int val1 = arr[0];
        int cnt1 = 1;
        int val2 = arr[0];
        int cnt2 = 0;

        for(int i = 1;i<arr.length;i++)
        {
            if(arr[i] == val1){
                cnt1+=1;
            }else if(arr[i] == val2){
                cnt2+=1;
            }else{
                if(cnt1 == 0){
                    val1 = arr[i];
                    cnt1=1;
                }else if(cnt2 == 0){
                    val2 = arr[i];
                    cnt2 = 1;
                }else{
                    cnt1--;
                    cnt2--;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        if(is_greater_than_3(arr, val1)){
            ans.add(val1);
        }
        if(val1 != val2 && is_greater_than_3(arr, val2)){
            ans.add(val2);
        }
        return ans;
    }

    private static boolean is_greater_than_3(int[] arr, int val) {
        int cnt = 0;
        for(int a : arr){
            if(a == val){
                cnt+=1;
            }
        }
        return cnt > arr.length/3;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer> res = majorityElement2(arr);
        System.out.println(res);
    } 
}
