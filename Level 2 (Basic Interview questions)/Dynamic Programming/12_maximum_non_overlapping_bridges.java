/*abstract
1. You are given a number n, representing the number of bridges on a river.
2. You are given n pair of numbers, representing the north bank and south bank co-ordinates of each bridge.
3. You are required to print the count of maximum number of non-overlapping bridges.
Input Format
A number n
.. n pair of number each on a separate line (and pair separated by space)
Output Format
A number representing the count of maximum number of non-overlapping bridges.
Question Video

  COMMENTConstraints
0 <= n <= 20
0 <= n1n, n1s, n2n, n2s, .. <= 100
Sample Input
10
10 20
2 7
8 15
17 3
21 40
50 4
41 57
60 80
80 90
1 30
Sample Output
7
*/

import java.util.*;

class maximum_non_overlapping_bridges{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Pair [] arr = new Pair[n];

        for(int i = 0;i<n;i++){
          Pair nPair = new Pair(s.nextInt(), s.nextInt());
          arr[i] = nPair;
        }

        for(Pair pp : arr){
          System.out.println(pp);
        }
        Arrays.sort(arr, new comp());
        System.out.println("--------------------------------------------");
        for(Pair pp : arr){
          System.out.println(pp);
        }

        int ans = 0;

        int [] dp = new int[n];
        for(int i = 0;i<n;i++){
          int max = 0;
          for(int j = 0;j<i;j++){
            if(arr[i].end >= arr[j].end){
              max = Math.max(max, dp[j]);
            }
          }

          dp[i] = max+1;
          ans = Math.max(dp[i], ans);
        }

        System.out.println(ans);
    }
}

class Pair{
  int start;
  int end;

  public Pair(int s, int e){
    start = s;
    end = e;
  }

  @Override
  public String toString() {
      // TODO Auto-generated method stub
      return "{" + start+", "+end+"}";
  }
}

class comp implements Comparator<Pair>{

  @Override
  public int compare(Pair o1, Pair o2) {
    if(o1.start != o2.start){
      return o1.start - o2.start;
    }else{
      return o1.end - o2.end;
    }
  }
  
}