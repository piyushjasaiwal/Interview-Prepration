/*abstract
You are given one integer number n. Find three distinct integers a,b,c such that 2≤a,b,c and a⋅b⋅c=n or say that it is impossible to do it.

If there are several answers, you can print any.

You have to answer t independent test cases.

Input
The first line of the input contains one integer t (1≤t≤100) — the number of test cases.

The next n lines describe test cases. The i-th test case is given on a new line as one integer n (2≤n≤109).

Output
For each test case, print the answer on it. Print "NO" if it is impossible to represent n as a⋅b⋅c for some distinct integers a,b,c such that 2≤a,b,c.

Otherwise, print "YES" and any possible such representation.

Example
inputCopy
5
64
32
97
2
12345
outputCopy
YES
2 4 8 
NO
NO
NO
YES
3 5 823 
*/

import java.io.*;

class product_of_three_numbers {

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    // String inp[] = read.readLine().split(" ");

    int t = Integer.parseInt(read.readLine());
    // int n = Integer.parseInt(inp[1]);

    // write your code from here

    StringBuilder sb = new StringBuilder();

    while(t-->0){
        long n = Long.parseLong(read.readLine());
        long a = 0;
        boolean flag = true;
        long b = 0;
        for(long i = 2;i*i<=n;i++){
            if(n%i == 0){
                flag = false;
                a = i;
                b = n/i;
                break;
            }
        }

        if(!flag){
            sb.append("YES\n");
            long c = n/b;
            sb.append(a+" "+b+" "+c+"\n");
        }else{
            sb.append("NO\n");
        }
    }

    System.out.println(sb);

  }
}