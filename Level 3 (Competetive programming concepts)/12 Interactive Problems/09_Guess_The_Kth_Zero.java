/*
This is an interactive problem.

This is an easy version of the problem. The difference from the hard version is that in the easy version t=1 and the number of queries is limited to 20.

Polycarp is playing a computer game. In this game, an array consisting of zeros and ones is hidden. Polycarp wins if he guesses the position of the k-th zero from the left t times.

Polycarp can make no more than 20 requests of the following type:

? l r — find out the sum of all elements in positions from l to r (1≤l≤r≤n) inclusive.
In this (easy version) of the problem, this paragraph doesn't really make sense since t=1 always. To make the game more interesting, each guessed zero turns into one and the game continues on the changed array. More formally, if the position of the k-th zero was x, then after Polycarp guesses this position, the x-th element of the array will be replaced from 0 to 1. Of course, this feature affects something only for t>1.

Help Polycarp win the game.

Interaction
First, your program must read two integers n and t (1≤n≤2⋅105, t=1).

Then t lines follow, each of which contains one integer k (1≤k≤n). It is guaranteed that at the moment of the request the array contains at least k zeros. In order to get the next value of k, you must output the answer for the current value of k.

After that, you can make no more than 20 requests.

Use the following format to output the answer (it is not a request, it doesn't count in 20):

! x — position of the k-th zero.
Positions in the array are numbered from left to right from 1 to n inclusive.

After printing t answers, your program should exit immediately.

In this task, the interactor is not adaptive. This means that within the same test, the hidden array and the queries do not change.

In case of an incorrect query, -1 will be displayed. When this value is received, your program must immediately exit normally (for example, by calling exit(0)), otherwise, the testing system may issue an arbitrary verdict.

If the number of requests is exceeded, the verdict wrong answer will be displayed.

Your solution may get the verdict Idleness limit exceeded if you don't print anything or forget to flush the output buffer.

To flush the output buffer, you need to do the following immediately after the query output and the end-of-line character:

fflush(stdout) or cout.flush() in C ++;
System.out.flush() in Java;
flush(output) in Pascal;
stdout.flush() in Python;
see the documentation for other languages.
Hacks

Use the following format for hacks:

On the first line print the string s (1≤|s|≤2⋅105), consisting of zeros and ones, and an integer t (t=1) — hidden array and number of requests, respectively. In the next t lines output the number k (1≤k≤|s|).

The hacked solution will not have direct access to the hidden array.

Example
inputCopy
6 1
2

2

1

1

0

0
outputCopy
? 4 6

? 1 1

? 1 2

? 2 2

? 5 5

! 5
Note
In the first test, the [1,0,1,1,0,1] array is hidden. In this test k=2.
*/

import java.util.*;
 
class Guess_The_Kth_Zero {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int t = s.nextInt();
        int k = s.nextInt();
        int lo = 0;
        int hi = n-1;
        int ans = -1;
        int [] ar = new int[n];
 
        while(lo <= hi){
            int mid = (lo+hi)/2;
            System.out.print("? 1"+" "+(mid+1)+"\n");
            System.out.flush();
            int sum = s.nextInt();
            int len = mid+1;
            int kth = len-sum;
            if(kth == k){
                ans = mid;
                break;
            }else if(kth < k){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
 
        System.out.println("! "+(ans+1));
    }
}