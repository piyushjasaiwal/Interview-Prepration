/*abstract
Given a sorted array of size N and an integer, K. Check if K is present in the array or not using ternary search.
Ternary Search - It is a divide and conquers algorithm that can be used to find an element in an array. It is similar to binary search where we divide the array into two parts but in this algorithm, we divide the given array into three parts and determine which has the key (searched element).
Input Format
The first line contains two integers N and K denoting the size of the array and the element to be searched.
The second line contains n space separated integers a[1],a[2]...a[n].
Output Format
If the element is present in the array then print "Found" else print "Not Found"
Question Video

  COMMENTConstraints
1 <= N <= 10^6
1 <= K <= 10^6
1 <= arr[i] <= 10^6
Sample Input
5 2
1 2 3 4 5
Sample Output
Found
*/

import java.util.Scanner;

class searching_an_elemtent_in_sorted_array {
    public static void ternarySearch(int arr[], int k)
    {
        //Code Here
        int l = 0;
        int r = arr.length-1;
        boolean flag = false;

        while(l<=r){
            int m1 = l + (r-l)/3;
            int m2 = r - (r-l)/3;

            if(arr[m1] == k || arr[m2] == k){
                flag = true;
                break;
            }

            if(arr[m1] > k){
                r = m1-1;
            }else if(arr[m2] < k){
                l = m2+1;
            }else{
                l = m1+1;
                r = m2-1;
            }
        }

        System.out.println(flag ? "Found" : "Not Found");
    }


    //================================//
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
        }

        ternarySearch(arr, k);
    }
}