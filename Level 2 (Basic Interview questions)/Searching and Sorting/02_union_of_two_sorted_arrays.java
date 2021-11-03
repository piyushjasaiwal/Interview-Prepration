/*abstract
1. Given two sorted arrays a[] and b[] of size n and m respectively. The task is to find union between these two arrays.
2. Union of the two arrays can be defined as the set containing distinct elements from both the arrays. If there are repetitions, then only one occurrence of element should be printed in union.
3. Your task is to complete Union function that takes a, b as parameters and returns an Arraylist which contains the union elements of the two arrays.The printing is done by the driver code.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= n, m <= 10^5
1 <= a[i], b[i] < 10^5
Sample Input
6
1 2 2 3 3 4
4     
1 2 3 5
Sample Output
1 2 3 4 5 
*/

import java.util.*;
import java.io.*;

class union_of_two_sorted_arrays {

    /*You have to complete union function and return an Arraylist which contains union elements of the two arrays*/
    public static ArrayList<Integer> union(int[] a,int[] b) {
        //write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while(i < a.length && j < b.length){
            if(a[i] == b[j]){
                if(ans.size() == 0 || ans.get(ans.size()-1) != a[i]){
                    ans.add(a[i]);
                }
                i++;
                j++;                
            }else if(a[i] < b[j]){
                if(ans.size() == 0 || ans.get(ans.size()-1) != a[i]){
                    ans.add(a[i]);
                }
                i++;
            }else{
                if(ans.size() == 0 || ans.get(ans.size()-1) != b[j]){
                    ans.add(b[j]);
                }
                j++;
            }
        }

        while(i<a.length){
            if(ans.size() == 0 || ans.get(ans.size()-1) != a[i]){
                ans.add(a[i]);
            }
            i++;
        }

        while(j<b.length){
            if(ans.size() == 0 || ans.get(ans.size()-1) != b[j]){
                ans.add(b[j]);
            }
            j++;
        }


        return ans;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]a = new int[n];
        for(int i=0; i < n;i++) {
            a[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int[]b = new int[m];
        for(int i=0;i < m;i++) {
            b[i] = scn.nextInt();
        }

        ArrayList<Integer>ans = union(a,b);

        //print answer list
        for(int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}