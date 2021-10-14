/*
In 'MonkeyLand', there is a traditional game called "Bamboo Climbing". The rules of the game are as follows:

1. There are N monkeys who play this game and there are N bamboos of equal heights. Let the height be L meters.
2. Each monkey stands in front of a bamboo and every monkey is assigned a different bamboo.
3. When the whistle is blown, the monkeys start climbing the bamboos and they are not allowed to jump to a different bamboo throughout the game.
4. Since they are monkeys, they usually climb by jumping. And in each jump, the ith monkey can jump exactly pi meters (pi is a prime). After a while when a monkey finds that he cannot jump because one more jump may get him out of the bamboo, he reports the remaining length ri that he is not able to cover.
5. And before the game, each monkey is assigned a distinct pi.
6. The monkey, who has the lowest ri, wins.

Now, the organizers have found all the information of the game last year, but unluckily they haven't found the height of the bamboo. To be more exact, they know N, all pi and corresponding ri, but not L. So, you came forward and found the task challenging and so, you want to find L, from the given information.
Input Format
Input starts with an integer T, denoting the number of test cases.

Each case starts with a line containing an integer n. Each of the next n lines contains two integers pi and ri. All pi will be distinct.
Output Format
For each case, print the case number and the minimum possible value of L that satisfies the above conditions. If there is no solution, print Impossible.
Question Video

  COMMENTConstraints
T <= 10000
1 <= n <= 12
1 < pi < 40, pi is a prime
0 < ri < pi
Sample Input
2
3
5 4
7 6
11 3
4
2 1
3 2
5 3
7 1
Sample Output
Case 1: 69
Case 2: 113
*/

import java.util.*;

class monkey_tradition {
    public static void main(String[] args) {
        //Code Here
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i = 1;i<=t;i++){
            int n = s.nextInt();
            int pi = s.nextInt();

        }
    }
    
    
    //============EUCLIDS===============//
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
    
    public static Pair euclids(long a, long b) {
        if (b == 0) {
          return new Pair(1, 0, a);
        }
        Pair dash = euclids(b, a % b);
    
        return new Pair(dash.y, dash.x - ((a / b) * dash.y), dash.gcd);
    }
}
