/*
Everyone loves short problem statements.

Given a function f(x) find its minimum value over the range 0<x<π/2
f(x)=(x2+b∗x+c)/sin(x)
Input:
First-line will contain T, the number of test cases. Then the test cases follow.
Each test case contains a single line of input, two real numbers b,c.
Output:
For each test case, output the minimum value of f(x) over the given range. Absolute error of 10−6 is allowed.

Constraints
1≤T≤100000
1≤b,c≤20
Sample Input:
1
2 2
Sample Output:
5.8831725615
*/

import java.io.*;

class is_this_jee {
  //f(x) = (x^2 + bx + c)/sin(x)
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Code Here
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String [] token = br.readLine().split(" ");
            int b = Integer.parseInt(token[0]);
            int c = Integer.parseInt(token[1]);


        }
    }
}
