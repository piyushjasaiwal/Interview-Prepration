import java.util.Scanner;

/*
You are given three integers a,b and c.

Find two positive integers x and y (x>0 & y>0) such that:

1.the decimal representation of x without leading zeroes consists of "a" digits;
2.the decimal representation of y without leading zeroes consists of "b" digits;
3.the decimal representation of gcd(x,y) without leading zeroes consists of c digits.
gcd(x,y) denotes the greatest common divisor (GCD) of integers x and y.

Output x and y.
Input Format
The first line contains an integer T, number of test cases.
The next t lines contain three integers a and b and c.
Output Format
For each test case print two positive integers x and y.
Question Video

  COMMENTConstraints
1 <= t <= 200
1 <= a,b <= 9
1<= c <= min(a,b)
Sample Input
4
2 3 1
2 2 2
6 6 2
1 1 1
Sample Output
16 243
10 10
163840 196830
1 1
*/

class gcd_length {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        long [] ar = {1,1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000,10000000000L};
        while(t-- > 0){
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            
            long num_min = ar[c];
            long num1 = ar[c];
            long num2 = ar[c];
            while(digits(num1) < a){
                num1 = num1*2;
            }

            while(digits(num2) < b){
                num2 = num2*3;
            }

            System.out.println(num1+" "+num2);
        }
    }

    private static int digits(long num) {
        int cnt = 0;
        while(num > 0){
            cnt+=1;
            num = num/10;
        }
        return cnt;
    }
}
