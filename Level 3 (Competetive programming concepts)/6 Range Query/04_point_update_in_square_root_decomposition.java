/*abstract
You are given a list of N numbers and Q queries. There are two types of queries:

1. f l r : In a line, the first character would be f, and 2 index l and r, you have to find the sum of numbers between l and r.
2. u i d : In a line, the first character would be u, and we have to change the value at index i in the original array by d.
Input Format
The first line contains N. The next line holds N numbers. Following the list is a number Q. The next Q lines each contain one of the 2 queries.
Output Format
Output the sum from l to r for type 1 query and update the value at index i for type 2 query.
Question Video

  COMMENTConstraints
1 <= N <= 10^6
1 <= Q <= 10^5
1 <= arr[i] <= 10^9
Sample Input
5
1 5 3 9 -2
3
f 0 4
u 2 3
f 0 4
Sample Output
16
19
*/


import java.io.*;
import java.util.*;

class point_update_in_square_root_decomposition {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] ar = new int[n];
        for(int i = 0;i<ar.length;i++){
            ar[i] = s.nextInt();
        }

        int q = s.nextInt();
        int [][] queries = new int[q][3];
        for(int i = 0;i<q;i++){
            char ch = s.next().charAt(0);
            if(ch == 'f'){
                queries[i][0] = 0;
                queries[i][1] = s.nextInt();
                queries[i][2] = s.nextInt();
            }else{
                queries[i][0] = 1;
                queries[i][1] = s.nextInt();
                queries[i][2] = s.nextInt();
            }
        }

        find_sum_square_root_decomposition(ar, queries);
	}

    public static void find_sum_square_root_decomposition(int [] ar, int [][] queries){
        int len = ar.length;
        int sqrt_arr_len = (int)Math.ceil(Math.sqrt(len));
        long [] sqrt_arr = new long[sqrt_arr_len];
        for(int i = 0;i<ar.length;i++){
            int idx = i/sqrt_arr_len;
            sqrt_arr[idx] += ar[i];
        }

        // display(ar);
        // display(sqrt_arr);

        for(int [] query : queries){
            int op = query[0];
            if(op == 0){
                int start = query[1];
                int end = query[2];

                long sum = 0;
                while(start<=end && start%sqrt_arr_len != 0){
                    sum += ar[start];
                    start++;
                }

                while(start + sqrt_arr_len <= end){
                    sum += sqrt_arr[start/sqrt_arr_len];
                    start += sqrt_arr_len;
                }

                while(start <= end){
                    sum += ar[start];
                    start++;
                }

                System.out.println(sum);
            }else{
                int idx = query[1];
                int num = query[2];

                int sqrt_idx = idx/sqrt_arr_len;
                sqrt_arr[sqrt_idx] = sqrt_arr[sqrt_idx] + num;
                ar[idx] += num;
            }
        }
    }

    public static void display(int [] ar){
        for(int a : ar){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void display(long [] ar){
        for(long a : ar){
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
