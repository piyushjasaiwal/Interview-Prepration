/*
 1. You are given an array of strings.
2. You have to group the given strings in such a way that all strings in a group are shifted versions of each other. 
3. Two strings s1 and s2 are shifted if -
   -> Length of both the strings is the same.
   -> The difference between ASCII values of every character of s1 and s2 is constant.

Note -> Every string consists of lower-case English letters only.
Input Format
A number N
str1
str2.. N space-separated strings
Output Format
Every line of output contains space-separated strings which represents a group of shifted strings.
Question Video

  COMMENTConstraints
1 <= N <= 10^4
1 <= length of a string <= 100
Sample Input
9
acd dfg wyz yab mop bdfh a x moqs
Sample Output
acd dfg mop wyz yab 
a x 
bdfh moqs 
 */

import java.util.*;

class group_shifted_strings {

	public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
		// write your code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String str:strs){
            String give_key = giveKey(str);
            // System.out.println(give_key);
            // System.out.println(map.containsKey(give_key));
            ArrayList<String> value = map.getOrDefault(give_key, new ArrayList<>());
            value.add(str);
            map.put(give_key, value);
        }

        ArrayList<String> keys = new ArrayList<>(map.keySet());
        for(String key:keys){
            ans.add(map.get(key));
        }
        // System.out.println(ans);
		return ans;
	}



	private static String giveKey(String str) {
        if(str.length() == 1){
            return "#";
        }

        StringBuilder sb = new StringBuilder("");
        for(int i = 1;i<str.length();i++){
            int val = (str.charAt(i)-str.charAt(i-1));
            if(val<0){
                val+=26;
            }
            sb.append(val+"#");
        }
        return new String(sb);
    }



    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		ArrayList<ArrayList<String>> shiftedGroup = groupShiftedStrings(arr);
		for (ArrayList<String> lst : shiftedGroup) {
			Collections.sort(lst);
		}
		shiftedGroup.sort(new ListComparator());
		display(shiftedGroup);
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
