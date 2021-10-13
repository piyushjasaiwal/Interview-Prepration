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
      coef c = new coef(0,0);
      int g = gcd(a,b,c);
      System.out.println(c.x+" "+c.y);
    }

    public static int gcd(int a, int b, coef c){
      if(b == 0){
        c.x = 1;
        c.y = 0;
        return a;
      }
      coef new_c = new coef(0,0);
      int g = gcd(b, a%b, new_c);
      c.x = new_c.y;
      new_c.y = new_c.x - (new_c.y*(a/b));
      return g;
    }
}

class coef{
  int x,y;
  coef(int x, int y){
    this.x = x;
    this.y = y;
  }
}