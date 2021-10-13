/*
1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. You are required to find the intersection of a1 and a2. To get an idea check the example below:
 
if a1 -> 1 1 2 2 2 3 5
and a2 -> 1 1 1 2 2 4 5
intersection is -> 1 1 2 2 5

Note -> Don't assume the arrays to be sorted. Check out the question video.
Input Format
A number n1
n1 number of elements line separated
A number n2
n2 number of elements line separated
Output Format
All relevant elements of intersection in separate lines
The elements of intersection should be printed in order of their occurence in a2.
Question Video

  COMMENTConstraints
1 <= n1, n2 <= 100
0 <= a1[i], a2[i] < 10
Time complexity should be O(n)
Sample Input
7
1
1
2
2
2
3
5
7
1
1
1
2
2
4
5
Sample Output
1
1
2
2
5
*/

import java.util.*;

class get_common_elements_second {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int [] a = new int[n1];
        for(int i = 0;i<n1;i++){
            a[i] = s.nextInt();
        }
        int n2 = s.nextInt();
        int [] b = new int[n2];
        for(int i = 0;i<n2;i++){
            b[i] = s.nextInt();
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int aa: a){
            map.put(aa, map.getOrDefault(aa, 0)+1);
        }

        for(int bb : b){
            if(map.containsKey(bb)){
                System.out.println(bb);
                if(map.get(bb) > 1){
                    map.put(bb, map.get(bb)-1);
                }else{
                    map.remove(bb);
                }
            }
        }
    }  
}
