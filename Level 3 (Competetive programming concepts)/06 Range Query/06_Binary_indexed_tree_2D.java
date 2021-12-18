/*abstract
Mr. Pepcoder has a 2D Array, and his Friend love to do operations on thearray. The operations can be a query or an update.

For each query the Friend say four indices x1, y1, x2 and y2, and their father answers back with the sum of the elements of the rectangle whose top left index is x1, y1 and bottom right is x2, y2.

When there is an update, the friend says index (x1,y1) and a value x , and Pepcoder will add x to arr[x1][y1] (so the new value of arr[x1][y1]  is arr[x1][y1] + x ).

Because indexing the array from zero is too obscure for friend, all indices start from 1.
Input Format
The first line of the input contains n and m. The next n lines contain m integers each, the initial values of the array.Next line contains Q, the number of operations that will be made. Each of the next Q lines contains an operation.
Query operations are of the form "q x1 y1 x2 y2", while update operations are of the form "u x1 x2 x".
Output Format
You have to print the answer for every query in a different line, in the same order of the input.
Question Video

  COMMENTConstraints
1 <= n,m <= 10^3
1 <= Q <= 10^5
1 <= x1,y1,x2,y2 <= N
-10^9 <= arr[i] <= 10^9
Sample Input
3 3
1 2 3 
4 5 6
7 8 9
3
q 1 1 2 2
q 1 2 3 3
q 2 1 3 2
Sample Output
12
33
24
*/

import java.io.*;
import java.util.Scanner;

class Binary_indexed_tree_2D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();

		int [][] matrix = new int[n+1][m+1];
		for(int i = 1;i<=n;i++){
			for(int j = 1;j<=m;j++){
				matrix[i][j] = s.nextInt();
			}
		}

		binary_indexed_tree_2d bt = new binary_indexed_tree_2d(matrix);

		int q = s.nextInt();
		while(q-->0){
			char ch = s.next().charAt(0);
			if(ch == 'q'){
				int x1 = s.nextInt();
				int y1 = s.nextInt();
				int x2 = s.nextInt();
				int y2 = s.nextInt();

				System.out.println(bt.query(x2, y2) - bt.query(x1-1, y2) - bt.query(x2, y1-1) + bt.query(x1-1, y1-1));
			}else{
				int x = s.nextInt();
				int y = s.nextInt();
				int val = s.nextInt();
				bt.update(x, y, val);
			}
		}

	}

	static class binary_indexed_tree_2d{
		long [][] BIT;
		
		public binary_indexed_tree_2d(int [][] arr){
			BIT = new long[arr.length][arr[0].length];
			for(int i = 1;i<arr.length;i++){
				for(int j = 1;j<arr[0].length;j++){
					update(i, j, arr[i][j]);
				}
			}
		}

		public void update(int x, int y, int val){
			int xdash = x;
			while(xdash < BIT.length){
				int ydash = y;
				while(ydash < BIT[0].length){
					BIT[xdash][ydash] += val;
					ydash = ydash + (ydash&-ydash);
				}
				xdash = xdash + (xdash&-xdash);	
			}
		}

		public long query(int x, int y){
			long sum = 0;
			int xdash = x;
			while(xdash > 0){
				int ydash = y;
				while(ydash > 0){
					sum += BIT[xdash][ydash];
					ydash = ydash - (ydash&-ydash);
				}
				xdash = xdash - (xdash&-xdash);
			}
			return sum;
		}
	}
}
