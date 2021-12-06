// /*abstract
// 1. Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
//  2. You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
//  3. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
//  4. Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//  5. For the last line of text, it should be left justified and no extra space is inserted between words.
// Input Format
// First line contains N(total number of words)
//  Second line cntains N space separated words
//  Third line contains integer maxWidth.
// Output Format
// Return a list
// Question Video

//   COMMENTConstraints
// A word is defined as a character sequence consisting of non-space characters only.
//  Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
//  The input array words contains at least one word.
// Sample Input
// 7
// This is an example of text justification
// 16
// Sample Output
// [This    is    an, example  of text, justification   ]
// */

// import java.util.*;

// class justification_of_text {

//     public static List<String> fullJustify(String[] words, int maxWidth) {
//         //Write your code here
//         int i = 0;
//         int last = 0;
//         while(i<words.length){
//             int width = 0;
//             int j = i;
//             while(j<words.length && width+words[j].length() <= maxWidth){
//                 width += words[j].length();
//             }

//             if(j < words.length){
//                 int spaces = width
//             }
//         }
//         return null;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         String[] words = new String[n];
//         for (int i = 0; i < n; i++) {
//         words[i] = sc.next();
//         }
//         int width = sc.nextInt();
//         System.out.println(fullJustify(words, width));
//     }
// }