/*abstract

1. You are given two arrays - 
     The first array(keys), which is sorted and has distinct integers, represents search keys.
   Second one(freq) represents frequency counts, where freq[i] is the number of searches to keys[i].
2. A binary search tree is constructed containing all keys and the total cost of searches is minimum. 
3. The cost of a BST node is the level of that node multiplied by its frequency.
4. You have to find the minimum cost of all searches.
Input Format
A number N
a1
a2.. N integers
b1
b2.. N numbers
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= N <= 1000
1 <= keys[i],freq[i] <= 1000
Sample Input
9
1
3
4
5
6
7
8
9
11
3
6
4
8
7
3
7
4
7
Sample Output
125
*/

import java.io.*;
import java.util.*;

class optimal_Binary_saarch_tree {
  
    private static void optimalbst(int[] keys, int[] frequency, int n) {
        //write your code here
        
	}

    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        int[] keys = new int[n];
        int[] frequency = new int[n];
        for(int i= 0 ;i < n ; i++) {
            keys[i] = scn.nextInt();
        }
        for(int i = 0 ; i < n; i++){
            frequency[i] = scn.nextInt();
        }
        optimalbst(keys,frequency,n);
    }

}