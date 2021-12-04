import java.util.Scanner;

/*
1. You are given an integer N which represents the total number of soldiers standing in a circle 
     having position marked from 1 to N.
2. A cruel king wants to execute them but in a different way.
3. He starts executing soldiers from 1st position and proceeds around the circle in clockwise 
     direction.
4. In each step, every second soldier is executed.
5. The elimination proceeds around the circle (which is becoming smaller and smaller as the 
     executed soldiers are removed), until only the last soldier remains, who is given freedom.
6. You have to find the position of that lucky soldier.
Input Format
A number N
Output Format
Check the sample ouput and question video.
Question Video

  COMMENTConstraints
1 <= N <= 10^9
Sample Input
4
Sample Output
1
*/

/* solution

n = 2^x + l

where our answer is (2*l + 1)

*/

class josephus_special {
    public static int solution(int n){
        //write your code here
        int mask = make_mask(n);
        int l = (n-(mask));
        return (2*l)+1;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
    }

    public static int make_mask(int n){
        int mask = 1;
        while(mask*2 <= n){
            mask = (mask<<1);
        }
        return mask;
    }
}
