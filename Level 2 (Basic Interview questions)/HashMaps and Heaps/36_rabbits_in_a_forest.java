/*
 * 1. There are some rabbits in the forest and each rabbit has some color.
2. Some(possibly all) rabbits are selected from them and they tell you about the number of other rabbits having the same color as them.
3. You are given an array(arr) that contains the answers of all selected rabbits.
4. You have to find the minimum number of rabbits that could be in the forest.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
A number representing the minimum number of rabbits in the forest.
Question Video

  COMMENTConstraints
1 <= N <= 1000
0 <= arr[i] <= 1000
Sample Input
5
1 0 1 0 0
Sample Output
5
 */

import java.util.*;

class rabbits_in_a_forest {

    public static int solution(int[] arr) {
        // write your code here
        HashSet<Integer> set = new HashSet<>();
        int cnt = 0;
        for(int val:arr){
            if(val == 0){
                cnt++;
                continue;
            }

            if(!set.contains(val)){
                cnt++;
                cnt+=val;
                set.add(val);
            }
        }
        return cnt;
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
