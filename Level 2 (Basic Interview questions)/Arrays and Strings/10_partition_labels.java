/* this question to solved using chining method 
D:\interview prep\Interview-Prepration\Level 2 (Basic Interview questions)\Arrays and Strings\images\Screenshot (154).png
*/

/*
1. A string 's' of lowercase English letters is given. 
2. We want to partition this string into as many parts as possible so that each letter appears in at most one part.
3. Return a list of integers representing the size of these parts.
Input Format
s = "ababcbacadefegdehijhklij"
Output Format
[9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
Question Video

  COMMENTConstraints
1. 's' will have length in range [1, 500].
2. 's' will consist of lowercase English letters ('a' to 'z') only.
Sample Input
ababcbacadefegdehijhklij
Sample Output
9 7 8 
*/

import java.util.*;

class partition_labels {

  // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
  public static List<Integer> partitionLabels(String s) {
    // write your code here
    List<Integer> list = new ArrayList<>();
    HashMap<Character, Integer> map = new HashMap<>();

    for(int i = 0;i<s.length();i++){
        map.put(s.charAt(i), i);
    }

    int prev = -1;
    int max_impact = 0;

    for(int i = 0;i<s.length();i++){
        if(map.get(s.charAt(i)) > max_impact){
            max_impact = map.get(s.charAt(i));
        }
        if(max_impact == i){
            list.add(max_impact - prev);
            prev = max_impact;
        }
    }

    return list;
  }

  // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    List<Integer> res = partitionLabels(str);
    for (int val : res) {
      System.out.print(val + " ");
    }
  }
}