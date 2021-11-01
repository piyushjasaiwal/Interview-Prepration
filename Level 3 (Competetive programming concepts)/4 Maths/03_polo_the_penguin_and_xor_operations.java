/*abstract
Little penguin Polo likes permutations. But most of all he likes permutations of integers from 0 to n, inclusive.

For permutation p = p0, p1, ..., pn, Polo has defined its beauty — number .
beauty number = (0^p0) + (1^p1) + (2^p2) + ............. + (n^pn)

Expression  means applying the operation of bitwise excluding "OR" to numbers x and y. This operation exists in all modern programming languages, for example, in language C++ and Java it is represented as "^" and in Pascal — as "xor".

Help him find among all permutations of integers from 0 to n the permutation with the maximum beauty.

Input
The single line contains a positive integer n (1 ≤ n ≤ 106).

Output
In the first line print integer m the maximum possible beauty. In the second line print any permutation of integers from 0 to n with the beauty equal to m.

If there are several suitable permutations, you are allowed to print any of them.

Examples
inputCopy
4
outputCopy
20
0 2 1 4 3
*/

import java.io.*;

class polo_the_penguin_and_xor_operations {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        
    }
}
