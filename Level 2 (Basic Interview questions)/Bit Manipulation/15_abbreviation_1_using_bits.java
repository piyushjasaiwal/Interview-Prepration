/*abstract
1. You are given a word.
2. You have to generate all abbrevations of that word.
Note - Use bit manipulation
Input Format
A string representing a word
Output Format
Check the sample ouput and question video.
Question Video

  COMMENTConstraints
1 <= length of string <= 32
Sample Input
pep
Sample Output
pep
pe1
p1p
p2
1ep
1e1
2p
3
*/

import java.io.*;
import java.util.*;

class abbreviation_1_using_bits {

    public static void solve(String str){
        // write your code here
        for(int i = 0;i<(1<<str.length());i++){
            StringBuilder sb = new StringBuilder();
            int count = 0;

            for(int j = 0;j<str.length();j++){
                int b = (str.length()-j-1);

                if((i&(1<<b)) == 0){
                    if(count == 0){
                        sb.append(str.charAt(j));
                    }else{
                        sb.append(count);
                        sb.append(str.charAt(j));
                        count = 0;
                    }
                }else{
                    count++;
                }
            }

            if(count != 0){
                sb.append(count);
            }

            System.out.println(sb);
        }
    }
    
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solve(str);
    }
}