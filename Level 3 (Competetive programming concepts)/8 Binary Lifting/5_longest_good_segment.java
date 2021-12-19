/*abstract
Chef has a sequence A1,A2,…,AN. Let's call a contiguous subsequence of A a segment.

A segment is good if it can be divided into at most K segments such that the sum of elements in each of these sub-segments is at most S.

You need to find the maximum number of elements in a good segment.

Input Format
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains three space-separated integers N, K and S.
The second line contains N space-separated integers A1,A2,…,AN.
Output Format
For each test case, print a single line containing one integer — the maximum length of a good segment.

Constraints
1≤T≤150,000
1≤K≤N≤105
1≤S≤109
1≤Ai≤S for each valid i
the sum of N over all test cases does not exceed 106
Subtasks
Subtask #1 (100 points): original constraints

Sample Input 1 
2
5 2 5
1 3 2 1 5
5 3 5
5 1 5 1 1
Sample Output 1 
4
4
Explanation
Example case 1: One of the segments with length 4 is [1,3,2,1]. It can be divided into two segments [1,3] and [2,1] whose sums are at most S=5.
*/

class longest_good_segment{
    public static void main(String[] args) {
        
    }
}