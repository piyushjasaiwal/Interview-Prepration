/*
1. You are given a pattern of upto 8 length containing characters 'i' and 'd'.
2. 'd' stands for decreasing and 'i' stands for increasing
3. You have to print the smallest number, using the digits 1 to 9 only without repetition, such that 
the digit decreases following a d and increases follwing an i.

e.g.
d -> 21
i -> 12
ddd -> 4321
iii -> 1234
dddiddd -> 43218765
iiddd -> 126543
Input Format
Input is managed for you
Output Format
Smallest sequence of digits (from 1 to 9) without duplicacy and following the pattern
Question Video

  COMMENTConstraints
0 < str.length <= 8
str contains only 'd' and 'i'
Sample Input
ddddiiii
Sample Output
543216789
*/
import java.io.*;
import java.util.*;

class Smallest_Number_Following_Pattern{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int num = 1;
    Stack<Integer> s = new Stack<>();
    for(int i = 0;i<str.length();i++){
        if(str.charAt(i) == 'd'){
            s.push(num);
            num++;
        }else{
            s.push(num);
            while(!s.empty()){
                System.out.print(s.pop());
            }
            num++;
        }
    }
    s.push(num);
    while(!s.empty()){
        System.out.print(s.pop());
    }
 }
}