/*
Given a string, print all suffixes of it in lexicographical order.
Input Format
A string S.
Output Format
Print |S| lines, each having a suffix.
Question Video

  COMMENTConstraints
|S| <= 10^5
Sample Input
bananaban
Sample Output
aban
an
anaban
ananaban
ban
bananaban
n
naban
nanaban
*/

import java.util.*;

class lexicographical_suffixes {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // Write Code here
        String str = scn.next();
        SuffixArray sa = new SuffixArray(str);

        for(int i = 0;i<sa.n;i++){
          System.out.println(str.substring(sa.SA[i]));
        }

        scn.close();
    }

    static class SuffixArray{
      int MAX_N = 100010;
      int n = -1;
      String s;
      int [] RA = new int[MAX_N];
      int [] SA = new int[MAX_N];
      int [] tempRA = new int[MAX_N];
      int [] tempSA = new int[MAX_N];
      int []lcp;

      void countingSort(int k){
        int i, maxi = Math.max(300, n);
        int sum = 0;
        int [] c = new int[MAX_N];
        for(i = 0;i<n;i++){
          c[i+k < n ? RA[i+k] : 0]++;
        }

        for(i = 0;i<maxi;i++){
          int t = c[i];
          c[i] = sum;
          sum+=t;
        }

        for(i = 0;i<n;i++){
          tempSA[c[SA[i]+k<n ? RA[SA[i] + k] : 0]++] = SA[i];
        }

        for(i = 0;i<n;i++){
          SA[i] = tempSA[i];
        }
      }

      SuffixArray(String x){
        this.s = x;
        // this.s = s+'$';
        this.n = s.length();

        for(int i = 0;i<n;i++){
          RA[i] = s.charAt(i);
          SA[i] = i;
        }

        for(int k = 1;k<n;k*=2){
          countingSort(k);
          countingSort(0);

          int r = 0;
          tempRA[SA[0]] = r;

          for(int i = 1;i<n;i++){
            tempRA[this.SA[i]] = (RA[this.SA[i]] == RA[this.SA[i-1]] && RA[this.SA[i]+k] == RA[this.SA[i - 1] + k]) ? r : ++r;
          }

          for(int i = 0;i<n;i++){
            RA[i] = tempRA[i];
          }

          if(RA[SA[n-1]] == n-1){
            break;
          }
        }

        kasai();
      }

      void kasai(){
        int k = 0;
        this.lcp = new int[n];
        int [] rank = new int[n];

        for(int i = 0;i<n;i++){
          rank[this.SA[i]] = i;
        }

        for(int i = 0;i<n;i++, k = Math.max(0, k-1)){
          if(rank[i] == n-1){
            k = 0;
            continue;
          }

          int j = this.SA[rank[i]+1];
          while(i+k<n && j+k<n && s.charAt(i+k) == s.charAt(j+k)){
            k++;
          }

          this.lcp[rank[i]] = k;
        }
      }

    }


    public void printArray(int [] a, int n){
      for(int i = 0;i<n;i++){
        System.out.print(a[i]+" ");
      }
      System.out.println();
    }
  }