/*abstract
There are n houses numbered from 0 to n-1 connected by pipes forming a network where connections[i] = [a, b] represents a connection between houses a and b. 
Any house can reach any other house directly or indirectly through the network.

Given an initial pipeline network connections. You can extract certain pipes between two directly connected houses, 
and place them between any pair of disconnected houses to make them directly connected. 

Return the minimum number of times you need to do this in order to make all the houses connected. 
If it's not possible, return -1. 

Example 1:

Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove pipe between house 1 and 2 and place between houses 1 and 3.
Input Format
A number 'n' (number of houses) and connections array will be provided as arguments in the function.
Input/output is handled for you. You just need to complete the function.
Output Format
A number 'n' (number of houses) and connections array will be provided as arguments in the function.
Input/output is handled for you. You just need to complete the function.
Question Video

Constraints
1. 1 <= n <= 10^5
2. 1 <= connections.length <= min(n*(n-1)/2, 10^5)
3. connections[i].length == 2
4. 0 <= connections[i][0], connections[i][1] < n
5. connections[i][0] != connections[i][1]
6. There are no repeated connections.
7. No two houses are connected by more than one pipe.
Sample Input
4
3
0
1
0
2
1
2
Sample Output
1
*/

import java.util.*;
import java.io.*;

class number_of_connections_to_make_pipelines_connected {
    public static int makeConnected(int n, int[][] connections) {
        // Write your code here
        
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int numberOfHouses = scn.nextInt();

        int n = scn.nextInt();
        int[][] connections = new int[n][2];

        for (int i = 0; i < n; i++) {
            connections[i][0] = scn.nextInt();
            connections[i][1] = scn.nextInt();
        }

        int ans = makeConnected(numberOfHouses, connections);
        System.out.println(ans);
    }
}
