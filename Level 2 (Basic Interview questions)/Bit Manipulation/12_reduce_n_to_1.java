/*abstract
1. You are given a positive number N.
2. You have to find the minimum number of operations required to convert N into 1.
3. Operations allowed :
     (i)  If n is even, you have to replace n with n/2.
     (ii) If n is odd, you can replace n with either n-1 or n+1.
Input Format
A number N
Output Format
Check the sample ouput and question video.
Question Video

  COMMENTConstraints
1 <= N <= 2147483647
Sample Input
8
Sample Output
3
*/

import java.io.*;
import java.util.*;

class reduce_n_to_1 {

    public static int solution(int n) {
        //write your code here

        if(n == 3){
            return 2;
        }

        int cnt = 0;
        while(n>1){
            if(n%2 == 0){
                n = (n>>1);
                cnt+=1;
            }else{
                if(n%4 == 1){
                    n = n-1;
                }else{
                    n+=1;
                }
                cnt+=1;
            }
        }

        return cnt;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        System.out.println(solution(n));
    }
	
	
}