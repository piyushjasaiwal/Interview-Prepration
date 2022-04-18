/*abstract
1. There is a class of N students and the task is to find the top K marks scorers. 
2. You need to print the index of the toppers of the class which will be same as the index of the student in the input array (use 0-based indexing). 
3. First print the index of the students having highest marks then the students with second highest and so on. If there are more than one students having same marks then print their indices in ascending order.Suppose k = 2 and the students having highest marks have indices 0 and 5 and students having second highest marks have indices 6 and 7 then output will be 0 5 6 7.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= N <= 10^6
1 <= M <= 10^6
Sample Input
5
2 2 1 3 1
3
Sample Output
3 0 1 
*/

import java.util.*;
import java.io.*;

class toppers_of_class {

    static class Pair implements Comparable<Pair>{

        int i;
        int m;

        Pair(int i, int m){
            this.i = i;
            this.m = m;
        }

        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            if(o.m == this.m){
                return this.i - o.i;
            }
            return o.m - this.m;
        }

    }


    public static int[] kToppers(int[]marks, int k) {
        //write your code here
        int [] ans = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0;i<marks.length;i++){
            pq.add(new Pair(i, marks[i]));
        }
        int i = 0;
        while(k-->0){
            ans[i] = pq.poll().i;
            i++;
        }
        return ans;
    }

    public static void main(String[]args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]marks = new int[n];

        for (int i = 0; i < n; i++) {
            marks[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        int[]ans = kToppers(marks, k);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

    }
}