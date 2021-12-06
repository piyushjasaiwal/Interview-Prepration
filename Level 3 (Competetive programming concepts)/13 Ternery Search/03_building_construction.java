/*abstract
Given N buildings of height h1,h2,h3...hn, the objective is to make every building has equal height. This can be done by removing bricks from a building or adding some bricks to a building.Removing a  brick or  adding  a brick is done at certain cost which will be given along with the heights of the buildings.Find the minimal cost at which you can make the buildings look beautiful by re-constructing the buildings such that the N buildings satisfy 

h1=h2=h3=..=hn=k ( k can be any number).

For convenience, all buildings are considered to be vertical piles of bricks, which are of same dimensions. 

Input
 

The first line of input contains an integer T which denotes number of test cases .This will be followed by 3*T lines , 3 lines per test case. The first line of each test case contains an integer n and the  second line contains n integers which denotes the heights of the buildings [h1,h2,h3....hn] and the third line contains n integers [c1,c2,c3...cn] which denotes the cost of adding or removing one unit of brick from the corresponding building.

T<=15;n<=10000;0<=Hi<=10000;0<=Ci<=10000;

Output
 

The output must contain T lines each line corresponding to a testcase.

 

Example
Input:
1
3
1 2 3
10 100 1000


Output:
120
*/

import java.util.*;

class building_construction {
    public static void main(String[] args) throws Exception
    {
        //Code Here;
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0){
            int n = s.nextInt();
            int [] h = new int[n];
            int [] cost = new int[n];

            for(int i = 0;i<n;i++){
                h[i] = s.nextInt();
            }
            for(int i = 0;i<n;i++){
                cost[i] = s.nextInt();
            }

            solve(h, cost);
        }
    }

    private static void solve(int[] h, int[] cost) {
        int lo = 0;
        int hi = h[0];
        for(int val:h){
            hi = Math.max(hi, val);
        }
        long min = Long.MAX_VALUE;

        while(lo <= hi){
            int m1 = lo + (hi-lo)/3;
            int m2 = hi - (hi-lo)/3;

            long fm1 = calculate_cost(m1, h, cost);
            long fm2 = calculate_cost(m2, h, cost);

            if(fm1 > fm2){
                lo = m1+1;
            }else if(fm1 < fm2){
                hi = m2-1;
            }else{
                lo = m1+1;
                hi = m2-1;
                min = Math.min(min, fm1);
            }
        }

        System.out.println(min);
    }

    private static long calculate_cost(int x, int[] h, int[] cost) {
        long ans = 0;
        for(int i = 0;i<h.length;i++){
            ans += (Math.abs(x-h[i])*cost[i]);
        }
        return ans;
    }
}