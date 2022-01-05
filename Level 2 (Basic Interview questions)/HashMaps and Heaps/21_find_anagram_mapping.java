/*abstract
1. You are given two integer arrays(A and B), where B is an anagram of A.
2. B is an anagram of A means B is made by randomizing the order of the elements in A.
3. For every element in A, you have to print the index of that element in B.

Note -> Both arrays(A and B) are of the same length.
Input Format
A number N
a1
a2.. N numbers
b1
b2.. N numbers
Output Format
N space separated integers.
Question Video

  COMMENTConstraints
1 <= length of both arrays <= 10^4
1 <= A[i],B[i] <= 10^5
Sample Input
6
1 2 3 4 5 2
4 3 2 1 5 2
Sample Output
3 2 1 0 4 5 
*/

import java.util.*;

class find_anagram_mapping {
	public static int[] anagramMappings(int[] arr1, int[] arr2) {
		// write your code here

        int [] ans = new int[arr1.length];
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

        for(int i = 0;i<arr2.length;i++){
            LinkedList<Integer> list = map.getOrDefault(arr2[i], new LinkedList<>());
            list.add(i);
            map.put(arr2[i], list);
        }

        for(int i = 0;i<arr1.length;i++){
            ans[i] = map.get(arr1[i]).removeFirst();
        }

		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int j = 0; j < b.length; j++) {
			b[j] = s.nextInt();
		}
		int[] res = anagramMappings(a, b);
		for (int j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
	}

}
