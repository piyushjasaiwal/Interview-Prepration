/*abstract
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
Input Format
Input is managed for you
Output Format
 Output is managed for you
Question Video

  COMMENTConstraints
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-10^6 <= nums1[i], nums2[i] <= 10^6
Sample Input
5
3 5 7 9 12
3
4 6 14
Sample Output
6.5
*/

import java.util.*;
import java.io.*;

class median_of_two_sorted_arrays {

    public static double find(int[]a1,int[]a2) {
        //write your code here
        int total = a1.length+a2.length;
        if(total%2 == 0){
          int req_1 = total/2 - 1;
          int req_2 = req_1+1;

          int median_1 = -1;
          int median_2 = -1;

          int i = 0;
          int j = 0;
          int k = -1;
          while(i < a1.length && j < a2.length){
            if(a1[i] < a2[j]){
              k++;
              if(k == req_1){
                median_1 = a1[i];
              }

              if(k == req_2){
                median_2 = a1[i];
              }
              i++;
            }else{
              k++;
              if(k == req_1){
                median_1 = a2[j];
              }

              if(k == req_2){
                median_2 = a2[j];
              }
              j++;
            }
          }

          while(i<a1.length){
            k++;
            if(k == req_1){
              median_1 = a1[i];
            }

            if(k == req_2){
              median_2 = a1[i];
            }
              i++;
          }

          while(j < a2.length){
            k++;
              if(k == req_1){
                median_1 = a2[j];
              }

              if(k == req_2){
                median_2 = a2[j];
              }
              j++;
          }

          return (median_1+median_2+1.0-1.0)/2;
          
        }else{
          int req = total/2;
          int i = 0;
          int j = 0;
          int k = -1;
          int median = -1;
          while(i < a1.length && j < a2.length){
            if(a1[i] < a2[j]){
              k++;
              if(k == req){
                median = a1[i];
              }
              i++;
            }else{
              k++;
              if(k == req){
                median = a2[j];
              }
              j++;
            }
          }

          while(i<a1.length){
            k++;
              if(k == req){
                median = a1[i];
              }
              i++;
          }

          while(j < a2.length){
            k++;
              if(k == req){
                median = a2[j];
              }
              j++;
          }

          return median+1.0-1.0;
        }
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);

        //input work
        int n1 = scn.nextInt();
        int[]a = new int[n1];

        for(int i=0;i < n1;i++){
            a[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[]b = new int[n2];

        for(int i=0; i < n2;i++) {
            b[i] = scn.nextInt();
        }

        double median = find(a,b);
        System.out.println(median);
    }
}