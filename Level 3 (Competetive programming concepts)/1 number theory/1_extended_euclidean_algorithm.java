/*
You have been given two Integers a and b. you need to find an integral solution of x and y such that a*x + b*y= gcd(a,b).
It can be proven that solution always exist.
Input Format
The first line contains 2 integer a and b
Output Format
output integral value of x and y in a single line.
Question Video

  COMMENTConstraints
1 <= a, b <= 10^6
Sample Input
34
24
Sample Output
5 -7
*/

import java.util.*;

class extended_euclidean_algorithm{
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int a = s.nextInt();
      int b = s.nextInt();
      coef g = gcd(a,b);
      System.out.println(g.x+" "+g.y);
    }

    public static coef gcd(int a, int b){
      if(b == 0){
        return new coef(1, 0, a);
      }
      
      coef c = gcd(b, a%b);
      int x1 = c.x;
      int y1 = c.y;
      c.x = y1;
      c.y = x1 - ((a/b)*y1);
      return c;
    }
}

class coef{
  int x,y,gcd;
  coef(int x, int y, int gcd){
    this.x = x;
    this.y = y;
    this.gcd = gcd;
  }
}