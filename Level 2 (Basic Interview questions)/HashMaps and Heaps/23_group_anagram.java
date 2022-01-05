/*abstract
1. You are given an array of strings.
2. You have to group anagrams together.

Note -> Every string consists of lower-case English letters only.
Input Format
A number N
str1
str2.. N space-separated strings
Output Format
Every line of output contains space-separated strings which represents a group of anagrams.
Question Video

  COMMENTConstraints
1 <= N <= 10^4
1 <= length of a string <= 100
Sample Input
5
pepcoding codingpep pepper rapper repepp
Sample Output
codingpep pepcoding 
pepper repepp 
rapper 
*/

import java.util.*;

class group_anagram {

	public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
		// write your code here

    HashMap<String, ArrayList<String>> map = new HashMap<>();
    ArrayList<ArrayList<String>> ans = new ArrayList<>();

    for(int i = 0;i<strs.length;i++){
      char [] arr = strs[i].toCharArray();
      Arrays.sort(arr);
      String str = new String(arr);

      ArrayList<String> list = map.getOrDefault(str, new ArrayList<>());
      list.add(strs[i]);
      map.put(str, list);
    }

    ArrayList<String> keys = new ArrayList<>(map.keySet());

    for(String key:keys){
      ans.add(map.get(key));
    }

		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		ArrayList<ArrayList<String>> anagramsGrouped = groupAnagrams(arr);
		for (ArrayList<String> lst : anagramsGrouped) {
			Collections.sort(lst);
		}
		anagramsGrouped.sort(new ListComparator());
		display(anagramsGrouped);
	}

	// it is used to make the result unique
	static class ListComparator implements Comparator<List<String>> {
		@Override
		public int compare(List<String> l1, List<String> l2) {
			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			String l1str = l1.get(0);
			String l2str = l2.get(0);
			return l1str.compareTo(l2str);

		}
	}

	public static void display(ArrayList<ArrayList<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> currList = list.get(i);
			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}
			System.out.println();
		}
	}

}
