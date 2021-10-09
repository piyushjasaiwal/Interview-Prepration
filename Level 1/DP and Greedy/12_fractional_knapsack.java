/*
1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
Note1 -> Items can be added to the bag even partially. But you are not allowed to put same items again and again to the bag.
Input Format
A number n
v1 v2 .. n number of elements
w1 w2 .. n number of elements
A number cap
Output Format
A decimal number representing the maximum value that can be created in the bag without overflowing it's capacity
Question Video

Constraints
1 <= n <= 20
0 <= v1, v2, .. n elements <= 50
0 < w1, w2, .. n elements <= 10
0 < cap <= 10
Sample Input
10
33 14 50 9 8 11 6 40 2 15 
7 2 5 9 3 2 1 10 3 3 
5
Sample Output
50.0
*/

import java.util.*;
class fractional_knapsack {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Integer [] wt = new Integer[n];
        Integer [] v = new Integer[n];
        for(int i = 0;i<n;i++){
            v[i] = s.nextInt();
        }
        for(int i = 0;i<n;i++){
            wt[i] = s.nextInt();
        }
        art [] o = new art[n];
        for(int i = 0;i<n;i++){
            o[i] = new art(wt[i], v[i]);
        }
        int cap = s.nextInt();
        Arrays.sort(o);
        double ans = 0;
        for(art object:o){
            if(cap <=0){
                break;
            }
            if(cap >= object.wt){
                ans += object.val;
                cap-=object.wt;
            }else{
                ans += (object.dd*cap);
            }
        }
        System.out.println(ans);
        // for(art aa: o){
        //     System.out.println(aa);
        // }
    }
}
class art implements Comparable<art>{
    int wt; int val; double dd;
    art(int w, int v){
        wt = w;
        val = v;
        dd = (v*1.0)/w;
    }
    @Override
    public int compareTo(art o) {

        if(this.dd - o.dd > 0.1){
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return wt+" "+val+" "+dd;
    }
    
}