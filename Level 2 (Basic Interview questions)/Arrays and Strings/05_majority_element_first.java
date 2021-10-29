/*
1. Give an array of size 'n'.
2. Find Majority element and print it(if exist), otherwise print "No Majority Element exist".
3. Majority element-> if frequency of an element is more than n/2, then that element is majority element.
3. Note : solve the problem in linear time and in O(1) space.
Input Format
Array = [2,2,1,1,1,2,2]
Array = [1, 1, 5, 5, 3, 6]
Output Format
2
No Majority Element exist
Question Video

  COMMENTConstraints
1. 1 <= n <= 10^4
2. -10^9 < arr[n] < 10^9
Sample Input
7
2 2 1 1 1 2 2
Sample Output
2
*/

import java.util.*;

class majority_element_first {
    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static void printMajorityElement(int[] arr) {
        // write your code here
        int cnt = 0;
        int ans = -1;
        for(int i = 0;i<arr.length;i++){
            if(cnt == 0){
                ans = arr[i];
                cnt+=1;
            }else if(arr[i] == ans){
                cnt+=1;
            }else{
                cnt-=1;
            }
        }
        if(cnt <= 0){
            System.out.println("No Majority Element exist");
        }else{
            System.out.println(ans);
        }
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        printMajorityElement(arr);
    }
}
