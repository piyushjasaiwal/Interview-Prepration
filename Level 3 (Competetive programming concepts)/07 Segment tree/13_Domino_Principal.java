/*abstract
Vasya is interested in arranging dominoes. He is fed up with common dominoes and he uses the dominoes of different heights. He put n dominoes on the table along one axis, going from left to right. Every domino stands perpendicular to that axis so that the axis passes through the center of its base. The i-th domino has the coordinate xi and the height hi. Now Vasya wants to learn for every domino, how many dominoes will fall if he pushes it to the right. Help him do that.

Consider that a domino falls if it is touched strictly above the base. In other words, the fall of the domino with the initial coordinate x and height h leads to the fall of all dominoes on the segment [x + 1, x + h - 1].


Input
The first line contains integer n (1 ≤ n ≤ 105) which is the number of dominoes. Then follow n lines containing two integers xi and hi ( - 108 ≤ xi ≤ 108, 2 ≤ hi ≤ 108) each, which are the coordinate and height of every domino. No two dominoes stand on one point.

Output
Print n space-separated numbers zi — the number of dominoes that will fall if Vasya pushes the i-th domino to the right (including the domino itself).

Examples
inputCopy
4
16 5
20 5
10 10
18 2
outputCopy
3 1 4 1 
inputCopy
4
0 10
1 5
9 10
15 10
outputCopy
4 1 2 1 
*/

import java.io.*;
import java.util.*;

class Domino_Principal {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] input;
        StringBuilder sb = new StringBuilder();
        int [][] ar = new int[n][2];
        int [] val = new int[n];
        for(int i = 0;i<n;i++){
            input = br.readLine().split(" ");
            ar[i][0] = Integer.parseInt(input[0]);
            ar[i][1] = Integer.parseInt(input[1]);
            val[i] = ar[i][0];
        }

        Arrays.sort(ar, new comp());
        // for(int i = 0;i<)
    }
}

class comp implements Comparator<int[]>{

    @Override
    public int compare(int[] o1, int[] o2) {
        // TODO Auto-generated method stub
        return o1[0] - o2[0];
    }
    
}