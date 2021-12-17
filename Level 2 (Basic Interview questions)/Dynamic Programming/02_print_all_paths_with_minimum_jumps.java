/*abstract
1. You are given a number N representing number of elements.
2. You are given N space separated numbers (ELE : elements).
3. Your task is to find & print  
    3.1) "MINIMUM JUMPS" need from 0th step to (n-1)th step.
    3.2) all configurations of "MINIMUM JUMPS".
NOTE: Checkout sample question/solution video inorder to have more insight.
Input Format
A number N (representing "NUMBER OF ELEMENTS").
ELE1 ,ELE2 ,ELE3 ,ELE4 .... ELEn (N space separated numbers represnting numbers).
Output Format
1) A number representing "MINIMUM JUMPS" need from 0th step to (n-1)th step.
2) Strings representing configurations of "MINIMUM JUMPS".
Check the sample ouput and question video.
Question Video

  COMMENTConstraints
1 <= N <= 100
1 <= ELE <= 1000
Sample Input
10
3
3
0
2
1
2
4
2
0
0
Sample Output
4
0 -> 3 -> 5 -> 6 -> 9 .
0 -> 3 -> 5 -> 7 -> 9 .
*/

import java.util.*;

class print_all_paths_with_minimum_jumps{

    static public class Pair{
        int i;
        int s;
        int j;
        String psf;

        public Pair(int i, int s, int j, String psf){
            this.i = i;
            this.s = s;
            this.j = j;
            this.psf = psf;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "{i => " + i+", j => "+j+", s => "+s+", psf => "+psf+"}";
        }
    }

    public static void Solution(int arr[]){
        // write your code here
        Integer [] dp = new Integer[arr.length];
        dp[arr.length-1] = 0;
        for(int i = arr.length-2;i>=0;i--){
            int steps = arr[i];
            int min = Integer.MAX_VALUE;
            for(int j = 1;j <= steps && i+j < arr.length;j++){
                if(dp[i+j] != null){
                    min = Math.min(min, dp[i+j]);
                }
            }

            if(min != Integer.MAX_VALUE){
                dp[i] = min+1;
            }
        }
        System.out.println(dp[0]);

        LinkedList<Pair> ll = new LinkedList<>();
        ll.add(new Pair(0, dp[0], arr[0], ""));
        while(!ll.isEmpty()){
            System.out.println(ll);
            Pair curr = ll.removeFirst();
            if(curr.s == 0){
                System.out.println(curr.psf+curr.i+" .");
            }else{
                for(int j = 1;j<=curr.s && curr.i+j < arr.length;j++){
                    if(dp[curr.i+j] != null && dp[curr.i+j] == curr.s-1){
                        ll.add(new Pair(curr.i+j, dp[curr.i+j], arr[curr.i+j], curr.psf+curr.i+" -> "));
                    }
                }
            }
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}