/*Concept used

how to remove last set bit or the least significant bit from a number.
(i&-i)
here -i represents 2's Complement of a number.
how to calculate 2's complement just flip all the bits of the number and add 1 to it.
*/


/*abstract
Mr. Pepcoder has an array A, and his Friend love to do operations on the
array. The operations can be a query or an update.

For each query the Friend say two indices l and r , and their father answers back with the sum
of the elements from indices l to r (both included).

When there is an update, the friend says an index i and a value x , and Pepcoder will add x to
ith index of array (so the new value of arr[i]  is arr[i] + x ).

Because indexing the array from zero is too obscure for children, all indices start from 1.
Input Format
The first line of the input contains N. The second line contains N integers, the initial values of the array. The third line contains Q, the number of operations that will be made. Each of the next Q lines contains an operation. 
Query operations are of the form (q l r )  , while update operations are of the form (u i x)  .
Output Format
You have to print the answer for every query in a different line, in the same order of the input.
Question Video

  COMMENTConstraints
1 <= N <= 10^6
1 <= Q <= 10^5
1 <= l,r,i <= N
-10^9 <=  arr[i]  <= 10^9
Sample Input
10
1 23 4 10 24 33 -1 -9 7 4
6
q 2 5
q 1 9
u 3 -2
q 4 5
u 6 10
q 4 9
Sample Output
61
92
34
74
*/

/*Concept

important concept of fenwick tree
during query => i = i + (i&-i)
during update => i = i - (i&-i)
*/

import java.io.*;

class Fenwick_Tree {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] tokens = br.readLine().split(" ");
        int [] ar = new int[n+1];
        for(int i = 1;i<=n;i++){
            ar[i] = Integer.parseInt(tokens[i-1]);
        }

        int q = Integer.parseInt(br.readLine());
        int [][] queries = new int[q][3];
        for(int i = 0;i<q;i++){
            tokens = br.readLine().split(" ");
            if(tokens[0].charAt(0) == 'q'){
                queries[i][0] = 0;
                queries[i][1] = Integer.parseInt(tokens[1]);
                queries[i][2] = Integer.parseInt(tokens[2]);
            }else{
                queries[i][0] = 1;
                queries[i][1] = Integer.parseInt(tokens[1]);
                queries[i][2] = Integer.parseInt(tokens[2]);
            }
        }

        fenwick_tree_queries(ar, queries);
	}

    private static void fenwick_tree_queries(int[] ar, int[][] queries) {
        fenwick_tree ft = new fenwick_tree(ar);
        // display(ar);
        // ft.display();
        for(int [] query:queries){
            if(query[0] == 0){
                System.out.println(ft.query(query[2]) - ft.query(query[1]-1));
            }else{
                ft.update(query[1], query[2]);
                ar[query[1]] += query[2];
            }
        }
    }

    public static void display(int [] ar){
        for(int a : ar){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    static class fenwick_tree{
        long [] FT;
    
        public fenwick_tree(int [] ar){
            FT = new long[ar.length];
            make_fenwick_tree(ar);
        }
    
        //making the fenwick tree
        private void make_fenwick_tree(int[] ar) {
            for(int i = 1;i<ar.length;i++){
                int idx = i;
                while(idx < ar.length){
                    FT[idx] += ar[i];
                    idx = idx + (idx & -idx);
                }
            }
        }
    
    
        //Querying the fenwick tree
        
        public long query(int idx){
            long sum = 0;
            while(idx > 0){
                sum+=FT[idx];
                idx = idx - (idx&-idx);
            }
            return sum;
        }
    
        //Updating the Fenwick tree
        
        public void update(int idx, int new_val){
            while(idx < FT.length){
                FT[idx] = FT[idx] + new_val;
                idx = idx + (idx&-idx);
            }
        }
    
        public void display(){
            for(long a : FT){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
    
}
