// /*
// 1. Given an integers X. 
// 2. The task is to find the minimum number of jumps to reach a point X in the number line starting from zero.
// 3. The first jump made can be of length one unit and each successive jump will be exactly one unit longer than the previous jump in length. 
// 4. It is allowed to go either left or right in each jump.
// Input Format
// X = 8
// X = 9
// Output Format
// 4
// -1 -> 2 -> 3 -> 4 (order of jumps)

// 5
// 1 -> 2 -> -3 -> 4 -> 5 (prder of jumps)
// Question Video

//   COMMENTConstraints
// None
// Sample Input
// 9
// Sample Output
// 5
// */

import java.util.*;

class min_jumps_with_positive_i_and_negative_i_moves {
    // ~~~~~~~~~~~~User Section~~~~~~~~~~~
    public static int minJumps(int x) {
        // Write your code here
        
        int jump = 1;
        int sum = 0;

        while(sum < x){
            sum += jump;
            jump+=1;
        }

        if((sum-x)%2 == 0){
            return jump-1;
        }else if((sum+jump-x)%2 == 0){
            return jump;
        }
        return jump+1;

    }

    //~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();

        int jumps = minJumps(x);
        System.out.println(jumps);
    }
}
