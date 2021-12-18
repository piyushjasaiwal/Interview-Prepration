/*
Linear Diophantine Equation
Medium  Prev   Next
You have been given three Integers a, b and k. you need to find an integral solution of x and y such that a*x + b*y= k * gcd(a,b). 

It can be proven that solution always exist.
Input Format
The first line contains 3 integer a, b and k.
Output Format
output integral value of x and y in a single line.
Question Video

  COMMENTConstraints
1 <= a, b, k <= 10^6
Sample Input
3 5 8
Sample Output
16 -8
*/

import java.util.*;
class linear_diphantine_equation {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
        int k = scn.nextInt();
        coefs c = gcd(a,b);
        System.out.println(c.x*k +" " + c.y*k);
	}

    public static coefs gcd(int a,int b){
        if(b == 0){
            return new coefs(1,0,a);
        }

        coefs c = gcd(b, a%b);
        int x1 = c.x;
        int y1 = c.y;
        c.x = y1;
        c.y = x1 - ((a/b)*y1);
        return c;
    }
}

class coefs{
    int x; 
    int y;
    int gcd;

    public coefs(int x, int y, int gcd){
        this.x = x;
        this.y = y;
        this.gcd = gcd;
    }
}