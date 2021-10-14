/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates).

Note -> In case there are two sequences of equal length (and they are also the longest), then print the one for which the starting point of which occurs first in the array.
Input Format
A number n
n1
n2
.. n number of elements
Output Format
Elements of longest sequence of consecutive elements of array in separate lines (ignoring duplicates)
Question Video

  COMMENTConstraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 15
Sample Input
17
12
5
1
2
10
2
13
7
11
8
9
11
8
9
5
6
11
Sample Output
5
6
7
8
9
10
11
12
13
*/


import java.util.*;
class longest_consecutive_elements_sequence{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<Integer, Boolean> map = new HashMap<>();
        int n = s.nextInt();
        int [] ar = new int[n];
        for(int i = 0;i<ar.length;i++){
            ar[i] = s.nextInt();
            map.put(ar[i], true);
        }

        for(int val : ar){
            if(map.containsKey(val-1)){
                map.put(val, false);
            }
        }
        int ans_start = 0;
        int ans_cnt = 0;
        for(int i = 0;i<ar.length;i++){
            if(map.get(ar[i]) == true){
                int cnt = 0;
                for(int j = ar[i];;j++){
                    if(!map.containsKey(j)){
                        break;
                    }
                    cnt+=1;
                }
                if(cnt > ans_cnt){
                    ans_cnt = cnt;
                    ans_start = ar[i];
                }
            }
        }
        for(int i = ans_start;i<ans_start + ans_cnt;i++){
            System.out.println(i);
        }
    }
}