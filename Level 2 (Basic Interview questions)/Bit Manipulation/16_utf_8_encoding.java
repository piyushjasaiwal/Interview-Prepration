/*abstract
1. You are given an array of integers.
2. You are required to test whether the array represents a valid sequence of UTF-8 characters or 
     not.
3. A character in UTF-8 can be from 1 to 4 bytes long and follows some rules - 
       (i)  For 1-byte long character, first bit will be 0 and rest represents its unicode code.
       (ii) For n-bytes long character, first n-bits will be 1's, the n+1th bit is 0, followed by n-1 bytes 
             with most significant 2 bits being 10.

Note -> Only the least significant 8 bits of each element in array is used for data.
Note -> Check out the question video for details.
Input Format
A number N
arr1
arr2..
N numbers
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= n <= 10^9
0 < a[i] <= 255
Sample Input
3
197
130
1
Sample Output
true
*/

import java.io.*;
import java.util.*;

class utf_8_encoding {

    public static boolean solution(int[] arr) {
        //write your code here
        int rBytes = 0;

        for(int val:arr){
            if(rBytes == 0){
                if(((val) >> 7) == 0b0){
                    rBytes = 0;
                }else if(((val) >> 5) == 0b110){
                    rBytes = 1;
                }else if(((val) >> 4) == 0b1110){
                    rBytes = 2;
                }else if(((val) >> 3) == 0b11110){
                    rBytes = 3;
                }else{
                    return false;
                }
            }else{
                if(((val) >> 6) == 0b10){
                    rBytes--;
                }else{
                    return false;
                }
            }
        }
        
        return true;
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
    
    
}