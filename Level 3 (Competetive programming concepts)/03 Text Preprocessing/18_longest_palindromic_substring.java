/*abstract
Print the length of the longest palindromic substring
Input Format
Given a string S
Output Format
Print the length of the longest palindromic substring (Integer value)
Question Video

  COMMENTConstraints
|S| <= 10^5
Sample Input
5
ababa
Sample Output
5
*/

import java.util.*;

class longest_palindromic_substring {
  static class SuffixArray {
    int MAX_N = 100010;
    int n = -1;
    String s;
    int[] RA = new int[MAX_N];
    int[] SA = new int[MAX_N];
    int[] tempRA = new int[MAX_N];
    int[] tempSA = new int[MAX_N];
    int[] lcp;

    void countingSort(int k) {          // O(n)
      int i, maxi = Math.max(300, n); // up to 255 ASCII chars or length of n
      int sum = 0;
      int[] c = new int[MAX_N];
      // memset(c, 0, sizeof(c));         // clear frequency table
      for (i = 0; i < n; i++) c[i + k < n ? RA[i + k] : 0]++; // count the frequency of each integer rank

      for (i = 0; i < maxi; i++) {
        int t = c[i];
        c[i] = sum;
        sum += t;
      }

      for (i = 0; i < n; i++) // shuffle the suffix array if necessary
        tempSA[c[SA[i] + k < n ? RA[SA[i] + k] : 0]++] = SA[i];

      for (i = 0; i < n; i++) // update the suffix array SA
        SA[i] = tempSA[i];
    }

    SuffixArray(String x) {
      this.s = x;
      // this.s += "$";
      this.n = s.length();
      for (int i = 0; i < n; i++) RA[i] = s.charAt(i);
      for (int i = 0; i < n; i++) SA[i] = i;

      for (int k = 1; k < n; k *= 2) {
        countingSort(k);
        countingSort(0);

        int r = 0;
        tempRA[SA[0]] = r;  // re-ranking; start from rank r = 0
        for (int i = 1; i < n; i++) // compare adjacent suffixes if same pair => same rank r; otherwise, increase r
        {
          tempRA[this.SA[i]] =  (RA[this.SA[i]] == RA[this.SA[i - 1]] && RA[this.SA[i] + k] == RA[this.SA[i - 1] + k]) ? r : ++r;
        }

        for (int i = 0; i < n; i++) {
          RA[i] = tempRA[i]; // update the rank array RA
        }

        if (RA[this.SA[n - 1]] == n - 1)break; // nice optimization trick
      }
      kasai();    // use it to make lcp array in O(N) time
    }

    void kasai() {
      int k = 0;
      this.lcp = new int[n];
      int[] rank = new int[n];

      for (int i = 0; i < n; i++) rank[this.SA[i]] = i;

      for (int i = 0; i < n; i++, k = Math.max(k - 1, 0)) {
        if (rank[i] == n - 1) {
          k = 0;
          continue;
        }
        int j = this.SA[rank[i] + 1];
        while (i + k < n && j + k < n && s.charAt(i + k) == s.charAt(j + k)) k++;
        this.lcp[rank[i]] = k;
      }
    }
  }
  public static void printArray(int[] a, int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    //Write code here, Suffix array has been implemented for you :)

    int n = scn.nextInt();
    String str = scn.next();

    String new_str = str + '$' + reverse(str);

    SuffixArray sa = new SuffixArray(new_str);

    int max = 0;
    for(int i = 0;i<sa.lcp.length-1;i++){
        if(sa.lcp[i] > max && isValid(sa, i, n)){
            // System.out.println("-----------------------------------------------");
            // System.out.println(new_str.substring(sa.SA[i]));
            // System.out.println(new_str.substring(sa.SA[i+1]));
            // System.out.println("-----------------------------------------------");
            max = sa.lcp[i];
        }
    }

    System.out.println(max);
  }
    private static String reverse(String str) {
        char [] arr = str.toCharArray();
        int i = 0, j = str.length()-1;
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return new String(arr);
    }

    private static boolean isValid(SuffixArray sa, int i, int n) {
        if(sa.SA[i] < n && sa.SA[i+1] > n){
          return true;
        }
  
        if(sa.SA[i] > n && sa.SA[i+1] < n){
          return true;
        }
  
        
        return false;
    }
}