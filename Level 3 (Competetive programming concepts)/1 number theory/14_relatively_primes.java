import java.util.Scanner;

/*
You are given a set of all integers from l to r inclusive (r - l  is odd).You want to split these numbers into exactly (r-l+1)/2 pairs in such a way that for each pair (i,j), the greates common divisor of i and j is equal to 1.
Each pair should appear in exactly one of the pairs.

Print the resulting pairs or output that no solution exists.
Input Format
The only line contains two integer l and r.
Output Format
If any solution exists, print "YES" in the first line. Each of next (r-l+1)/2 line contains some pair of integers. GCD of each pair of integers should be equal to 1.
If there exists no solution print "NO".
Question Video

  COMMENTConstraints
1 <= l, r, <= 10^8
r-l+1 <= 10^5 and r-l is odd
Sample Input
1 8
Sample Output
YES
1 2
3 4
5 6
7 8
*/

class relatively_primes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long l = s.nextLong();
        long r = s.nextLong();

        System.out.println("YES");
        for(long i = l;i<r;i+=2){
          System.out.println(i+" "+(i+1));
        }
    }
}
