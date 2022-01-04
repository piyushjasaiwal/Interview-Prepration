/*abstract
Given a string s, Your task is, for any prefix of string s which matches a suffix of string s, print the number of times it occurs in string s as a substring.
Expected Complexity: O(n)
Input Format
The first line contains string s.
Output Format
In the first line, print integer k (0<=k<=|s|) - the number of prefixes that match a suffix of string s. Next print k lines, in each line print two integers li ci. Numbers li ci mean that the prefix of the length li matches the suffix of length li and occurs in string s as a substring ci times. Print pairs li ci in the order of increasing li.
Question Video

  COMMENTConstraints
1<= s.length() <= 10^5
Sample Input
ABABABAB
Sample Output
4
2 4
4 3
6 2
8 1
*/

import java.io.*;

class prefix_and_suffix_count {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int [] z = z_function(str);
        int max = 0;
        for(int val:z){
            max = Math.max(max, val);
        }
        int [] suffix_sum = new int[max+1];

        int cnt = 0;
        for(int i = 0;i<z.length;i++){
            if(str.length()-i == z[i]){
                cnt++;
                suffix_sum[str.length()-i]+=1;
            }
        }

        for(int i = suffix_sum.length-2;i>=0;i--){
            suffix_sum[i] = suffix_sum[i]+suffix_sum[i+1];
        }

        System.out.println(cnt+1);

        for(int i = z.length-1;i>=0;i--){
            if(str.length()-i == z[i]){
                System.out.println(z[i] + " " + (suffix_sum[z[i]]+1));
            }
        }
        System.out.println(str.length() + " 1");
	}

    public static int [] z_function(String str){
        int [] z = new int[str.length()];

        int l = 0, r = 0;
        for(int i = 1;i<str.length();i++){
            if(i <= r){
                z[i] = Math.min(z[i-l], r-i+1);
            }

            while(i+z[i] < str.length() && str.charAt(z[i]) == str.charAt(z[i]+i)){
                z[i]++;
            }

            if(i+z[i]-1 > r){
                l = i;
                r = i+z[i]-1;
            }
        }


        return z;
    }
}
