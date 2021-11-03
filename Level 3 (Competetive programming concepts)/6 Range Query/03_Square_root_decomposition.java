/*abstract
You are given a list of N numbers and Q queries.Each query is specified by two numbers i and j.The answer to
each query is the minimum number between the range between i and j(including i and j).The query are specified using 0 based indexing.

Expected complexity : O(Q * logN)
Input Format
The first line contains N. The next line holds N numbers. Following the list is a number Q. The next Q lines each contain two numbers i and j which specify a query you must answer.
Output Format
For each query, output the Minimum in the range in a line.
Question Video

  COMMENTConstraints
1<= N <= 10^6
1 <= Q <= 10^5
0 <= i,j <= N-1
Sample Input
4
2 4 3 1
4
1 2
1 3 
2 2
0 1
Sample Output
3
1
3
2
*/

import java.io.*;
import java.util.*;

class Square_root_decomposition {

	public static void main(String[] args) throws NumberFormatException, IOException {
        // Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] ar = new int[n];
        String [] tokens = br.readLine().split(" ");
        for(int i = 0;i<n;i++){
            ar[i] = Integer.parseInt(tokens[i]);
        }

        int q = Integer.parseInt(br.readLine());
        int [][] q_array = new int[q][2];
        for(int i = 0;i<q;i++){
            tokens = br.readLine().split(" ");
            q_array[i][0] = Integer.parseInt(tokens[0]);
            q_array[i][1] = Integer.parseInt(tokens[1]);
        }
        Square_Root_Decomposition_minimum_of_array(ar, q_array);
	}

    public static void Square_Root_Decomposition_minimum_of_array(int [] ar, int [][] queries){
        int len = ar.length;
        int sqrt_arr_len = (int)Math.ceil(Math.sqrt(len));
        int [] sqrt_arr = new int[sqrt_arr_len];
        Arrays.fill(sqrt_arr, Integer.MAX_VALUE);
        // System.out.println(sqrt_arr_len);

        for(int i = 0;i<len;i++){
            int idx = i/sqrt_arr_len;
            sqrt_arr[idx] = Math.min(sqrt_arr[idx], ar[i]);
        }

        // display(ar);
        // display(sqrt_arr);

        for(int [] query:queries){
            int start = query[0];
            int end = query[1];

            int min = Integer.MAX_VALUE;

            //to traverse the first half of the array
            while(start <= end && start%sqrt_arr_len != 0){
                min = Math.min(min, ar[start]);
                start++;
            }

            // to traverse the middle part using the sqrt array
            while(start<=end && start + sqrt_arr_len <= end){
                min = Math.min(min, sqrt_arr[start/sqrt_arr_len]);
                start += sqrt_arr_len;             
            }
            // to traverse the last part
            while(start <= end){
                min = Math.min(min, ar[start]);
                start++;
            }

            System.out.println(min);
        }
    }

    public static void display(int [] ar){
        for(int a : ar){
            System.out.print(a+" ");
        }
        System.out.println();
    }
}