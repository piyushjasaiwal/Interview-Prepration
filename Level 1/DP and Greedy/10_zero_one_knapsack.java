/*
1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without 
     overflowing it's capacity.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item 
               again and again.
Input Format
A number n
v1 v2 .. n number of elements
w1 w2 .. n number of elements
A number cap
Output Format
A number representing the maximum value that can be created in the bag without overflowing it's capacity
Question Video

  COMMENTConstraints
1 <= n <= 20
0 <= v1, v2, .. n elements <= 50
0 < w1, w2, .. n elements <= 10
0 < cap <= 10
Sample Input
5
15 14 10 45 30
2 5 1 3 4
7
Sample Output
75
*/

// unomment the code if you want to study it
// import java.util.*;
// class knapsack{
//     public static void main(String[] args) {
//         Scanner s = new Scanner(System.in);
//         int n = s.nextInt();
//         Integer [] wt = new Integer[n];
//         Integer [] v = new Integer[n];
//         for(int i = 0;i<n;i++){
//             v[i] = s.nextInt();
//         }
//         for(int i = 0;i<n;i++){
//             wt[i] = s.nextInt();
//         }
//         obj [] o = new obj[n];
//         for(int i = 0;i<n;i++){
//             o[i] = new obj(wt[i], v[i]);
//         }
//         int cap = s.nextInt();
//         Arrays.sort(o);
//         int [][] dp = new int[n+1][cap+1];
//         for(int i = 0;i<=n;i++){
//             for(int j = 0;j<=cap;j++){
//                 if(i == 0 || j == 0){
//                     dp[i][j] = 0;
//                 }else{
//                     int ans = dp[i-1][j];
//                     if(j-o[i-1].wt>=0){
//                         ans = Math.max(ans, dp[i-1][j-o[i-1].wt]+o[i-1].v);
//                     }
//                     dp[i][j] = ans;
//                 }
//             }
//         }
//         System.out.println(dp[n][cap]);
//         // for(int [] d:dp){
//         //     for(int a:d){
//         //         System.out.print(a+" ");
//         //     }
//         //     System.out.println();
//         // }
//         // for(obj oo:o){
//         //     System.out.println(oo.wt +" "+oo.v);
//         // }
//     }
// }

// class obj implements Comparable<obj>{
//     int wt,v;
//     obj(int wt, int v){
//         this.wt = wt;
//         this.v = v;
//     }
//     @Override
//     public int compareTo(obj o) {
//         // TODO Auto-generated method stub
//         return this.wt - o.wt;
//     }    
    
// }