/*
We are given a set of congruence equations.
a = a1 (mod n1)
a = a2 (mod n2)

Where ai are some given constants, which indicates ai = a % ni. 
The original form of CRT(Chinese Remainder Theorem) states that the given set of congruence equations always has one and exactly one solution modulo m. where m = lcm(n1, n2).

Find exactly one value of a.
If it's not possible to find the value of a then print "no solution";
Input Format
The first line of input consists of four integers a1, n1, a2, n2.
Output Format
Print two integers a, M, where M = lcm(n1, n2) and 0 <= a < M, giving the solution a (mod M) to the equations
a = a1 (mod n1)
a = a2 (mod n2)
Print "no solution" if there is no solution for a given set of congruence equations;
Question Video

  COMMENTConstraints
1 <= n1, n2 <= 10^9
0 <= a1 < n1
0 <= a2 < n2
Sample Input
10000 23000 10000 23000
Sample Output
10000 23000
*/

import java.util.Scanner;

class chinese_remainder_theoram {
  public static void main(String[] args) {
    //Write code here
    Scanner s = new Scanner(System.in);
    
    long a1 = s.nextLong();
    long n1 = s.nextLong();
    long a2 = s.nextLong();
    long n2 = s.nextLong();

    long gcd = give_gcd(n1, n2);
    if(Math.abs(a1-a2)%gcd != 0){
      System.out.println("no solution");
      return ;
    }
    long k = (a1-a2)/gcd;
    Pair p = euclids(n1, n2);
    long lcm = (n1*(n2/gcd));

    long x_solution = -1*(p.x*k);

    //keeping in mind about the overflow condition
    long a_val = a1 + ((n1)*((x_solution)%(n2/gcd)));
    if(a_val < 0){
      a_val += lcm;
    }
    a_val = a_val%lcm;
    System.out.println(a_val + " " + lcm);
  }

//========= Extended Euclidean Algorithm =========//
//------------------------------------------------//

  public static class Pair {
    long x;
    long y;
    long gcd;

    public Pair(long x, long y, long gcd) {
      this.x = x;
      this.y = y;
      this.gcd = gcd;
    }
  }

  public static long give_gcd(long a, long b){
    if(b == 0){
      return a;
    }
    return give_gcd(b, a%b);
  }

  public static Pair euclids(long a, long b) {
    if (b == 0) {
      return new Pair(1, 0, a);
    }
    Pair dash = euclids(b, a % b);

    return new Pair(dash.y, dash.x - ((a / b) * dash.y), dash.gcd);
  }
}