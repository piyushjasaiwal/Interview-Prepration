/*
n participants of the competition were split into m teams in some manner so that each team has at least one participant. After the competition each pair of participants from the same team became friends.

Your task is to write a program that will find the minimum and the maximum number of pairs of friends that could have formed by the end of the competition.

Input
The only line of input contains two integers n and m, separated by a single space (1 ≤ m ≤ n ≤ 109) — the number of participants and the number of teams respectively.

Output
The only line of the output should contain two integers kmin and kmax — the minimum possible number of pairs of friends and the maximum possible number of pairs of friends respectively.

Examples
inputCopy
5 1
outputCopy
10 10
inputCopy
3 2
outputCopy
1 1
inputCopy
6 3
outputCopy
3 6
Note
In the first sample all the participants get into one team, so there will be exactly ten pairs of friends.

In the second sample at any possible arrangement one team will always have two participants and the other team will always have one participant. Thus, the number of pairs of friends will always be equal to one.

In the third sample minimum number of newly formed friendships can be achieved if participants were split on teams consisting of 2 people, maximum number can be achieved if participants were split on teams of 1, 1 and 4 people.

*/

import java.io.*;

class random_teams {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    String inp[] = read.readLine().split(" ");

    int n = Integer.parseInt(inp[0]);
    int m = Integer.parseInt(inp[1]);

    // write your code from here

    long max_cnt = n-m+1;

    //for max pairs
    long div = (long)Math.ceil((1.0*n)/m);
    long rem = n-div;

    long ans = ((div*(div-1))/2)*(m-1);

    long extras = div+rem;
    ans += ((extras*(extras-1))/2);

    System.out.println(ans + " " + (((max_cnt)*(max_cnt-1))/2));
  }
}
