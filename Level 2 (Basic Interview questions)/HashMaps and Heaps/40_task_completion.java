/*
 * 1. You are given two integers N and M, and an array(arr) of numbers with length M.
2. N represents the total number of tasks assigned to a group of 5 students.
3. Out of these five students, three students completed M number of tasks of their choices and left the group.
4. Tasks completed by these students are represented by the given array.
5. Now, the remaining two students(s1 and s2) have to complete all the remaining tasks.
6. They decided to complete the remaining tasks in an alternate way -
   First of the remaining tasks will be completed by s1
   Second of the remaining tasks will be completed by s2
   Third of the remaining tasks will be completed by s1.. and so on.    
7. You have to find the tasks that s1 and s2 have to complete.
Input Format
Two Number N and M
arr1
arr2.. M numbers
Output Format
2 lines containing space-separated numbers.
Numbers in first line represents the tasks that s1 have to complete.
Numbers in second line represents the tasks that s2 have to complete. 
Question Video

  COMMENTConstraints
1 <= M,N <= 10^3
1 <= arr[i] <= 10^3
Sample Input
15 6
2 5 6 7 9 4
Sample Output
1 8 11 13 15 
3 10 12 14 
 */

import java.util.*;

class task_completion {
	
    public static void completeTask(int n, int m, int[] arr) {
		// write your code here
        int [] task = new int[n+1];
        for(int t:arr){
            task[t] = -1;
        }
        boolean f = true;
        for(int i = 1;i<=n;i++){
            if(task[i] != -1){
                task[i] = f ? 1 : 2;
                f = !f;
            }
        }

        for(int i = 1;i<=n;i++){
            if(task[i] == 1){
                System.out.print(i+" ");
            }
        }
        System.out.println();
        for(int i = 1;i<=n;i++){
            if(task[i] == 2){
                System.out.print(i+" ");
            }
        }
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] num = new int[m];
		for (int i = 0; i < m; i++) {
			num[i] = scn.nextInt();
		}
		completeTask(n, m, num);
	}

}