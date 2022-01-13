/*abstract
String analysis often arises in applications from biology and chemistry, such as the study of DNA and protein molecules. One interesting problem is to find how many substrings are repeated (at least twice) in a long string.

In this problem, you will write a program to find the total number of repeated substrings in a string of at most 100000 alphabetic characters. Any unique substring that occurs more than once is counted. As an example, if the string is “aabaab”, there are 5 repeated substrings: “a”, “aa”, “aab”, “ab”, “b”. If the string is “aaaaa”, the repeated substrings are “a”, “aa”, “aaa”, “aaaa”. Note that repeated occurrences of a substring may overlap (e.g. “aaaa” in the second case).

Input
The input consists of at most 10 cases. The first line contains a positive integer, specifying the number of cases to follow. Each of the following line contains a nonempty string of up to 100000 alphabetic characters.

Output
For each line of input, output one line containing the number of unique substrings that are repeated. You may assume that the correct answer fits in a signed 32-bit integer.

Sample Input 1	
3
aabaab
aaaaa
AaAaA

Sample Output 1
5
4
5
*/

import java.util.*;
class Repeated_Substrings_kattis {
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
      this.s += "$";
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

    int t = scn.nextInt();
    while(t-->0){
        String str = scn.next();
        System.out.println(repeatedStrings(str));
    }
  }
    private static int  repeatedStrings(String str) {
        SuffixArray sa = new SuffixArray(str);

        int count = sa.lcp[0];
        for(int i = 1;i<sa.lcp.length-1;i++){
            if(sa.lcp[i] > sa.lcp[i-1]){
                count += (sa.lcp[i] - sa.lcp[i-1]);
            }
        }
        return count;
    }
}