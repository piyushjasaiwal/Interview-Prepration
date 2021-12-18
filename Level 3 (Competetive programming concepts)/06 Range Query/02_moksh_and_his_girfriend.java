/*abstract
Recently Moksh(HR of Pepcoding) invented a serum which can increase height of plant by 1 unit. Moksh's girlfriend birthday is next month.
He is planning something amazing as a gift for her.His girlfriend's favourite Integer is M.

Initially Moksh has N (1 to N) no. of beautiful Rose plants, Each plant can have an Integer height,Initially the height of each plant is zero.
Subhesh gives Moksh Q number of operations,In each operation Moksh got two integer start and end and he increases the height of all the plants between start and end position (including start and end) by 1.
As Moksh wasn't happy with the pattern of height of the plants formed, He went to Rajneesh and asked him to remove any 1 operation from the Q operations such that the count of plants with height M is maximum possible.
Output the maximum possible number of plants with height M.

Expected Complexity : O(n+q)
Input Format
First line contains three space separated integer N(no. of Rose plants), Q(number of operations), M.
Each of the next Q lines contains two space-separated integers L and R describing one operation.
Output Format
print a single line containing one integer - the maximum possible number of Trees with height M.
Question Video

  COMMENTConstraints
Constraint : 
2<=N<=100000.
2<=Q<=100000.
1<=M1<=L<=R<=N.
Sample Input
10 3 2
2 6
4 9
1 4
Sample Output
3
*/

import java.io.*;
import java.util.*;
class moksh_and_his_girfriend {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        int m = s.nextInt();

        int [] range_array = new int[n+1];
        int [][] queries = new int[q][2];

        for(int i = 0;i<q;i++){
            queries[i][0] = s.nextInt();
            queries[i][1] = s.nextInt();

            range_array[queries[i][0]] += 1;
            if(queries[i][1]+1<=n){
                range_array[queries[i][1]+1] -= 1;
            }
        }

        int sum = 0;
        for(int i = 0;i<range_array.length;i++){
            sum += range_array[i];
            range_array[i] = sum;
        }

        int []prefix_m = new int[n+1];
        int []prefix_m_plus_one = new int[n+1];
        int count = 0; //to count the occurance of number of m
        for(int i = 0;i<range_array.length;i++){

            if(range_array[i] == m){
                count++;
            }

            //to construct the prefix m array
            if(range_array[i] == m){
                if(i == 0){
                    prefix_m[i] = 1;
                }else{
                    prefix_m[i] = prefix_m[i-1]+1;
                }
            }else{
                if(i == 0){
                    prefix_m[i] = 0;
                }else{
                    prefix_m[i] = prefix_m[i-1];
                }
            }

            //to construct the prefix m+1 array
            if(range_array[i] == m+1){
                if(i == 0){
                    prefix_m_plus_one[i] = 1;
                }else{
                    prefix_m_plus_one[i] = prefix_m_plus_one[i-1]+1;
                }
            }else{
                if(i == 0){
                    prefix_m_plus_one[i] = 0;
                }else{
                    prefix_m_plus_one[i] = prefix_m_plus_one[i-1];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int [] query : queries){
            int cnt_m = 0;
            if(query[0]-1>=0){
                cnt_m = prefix_m[query[1]] - prefix_m[query[0]-1];
            }else{
                cnt_m = prefix_m[query[1]];
            }

            int cnt_m_plus_1 = 0;
            if(query[0]-1>=0){
                cnt_m_plus_1 = prefix_m_plus_one[query[1]] - prefix_m_plus_one[query[0]-1];
            }else{
                cnt_m_plus_1 = prefix_m_plus_one[query[1]];
            }

            int count_m_temp = count - cnt_m + cnt_m_plus_1;
            max = Math.max(max, count_m_temp);
        }

        // display_mat(queries);
        // display_arr(range_array);
        // display_arr(prefix_m);
        // display_arr(prefix_m_plus_one);
        // System.out.println(count);

        System.out.println(max);
        return ;
    }

    public static void display_arr(int [] arr){
        System.out.println("--------------------------------");
        for(int val : arr){
            System.out.print(val+" ");
        }
        System.out.println("\n--------------------------------");
    }

    public static void display_mat(int [][] mat){
        System.out.println("--------------------------------");
        for(int []val : mat){
            for(int v:val){
                System.out.print(v+" ");
            }
            System.out.println();
        }
        System.out.println("\n--------------------------------");
    }
}
