import java.util.Scanner;

/*
1. You are given a number n.
2. You have to count the number of set bits in the given number.
Input Format
A number n
Output Format
Number of set bits in n
Question Video

  COMMENTConstraints
1 <= n <= 10^9
Sample Input
58
Sample Output
4
*/

class kernighans_algorithm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int cnt = 0;
        while(n > 0){
            cnt+=1;
            n = n&(n-1);
        }
        System.out.println(cnt);
    }
}
