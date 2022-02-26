/*abstract
Some balloons are placed around x-axis , find minimum number of arrows needed to burst balloon.
1. coordinates for each Balloon will be given as input. 
2. coordinates[i] = [starting point of ith Balloon , ending point of ith Balloon]
3. Some Balloons may overlap each other.
4. An arrow will burst a balloon only if arrow passes through / touches the balloon.

Task is to "find minimum number of arrows required to burst all Balloons".
NOTE: Each arrow can be shot from any x-coordinate(vertically upwards).

Example 1 : 
    coordinates[] : [[1,3],[4,5]]
    output : 2
    explanation : Two seperate arrows will be needed to burst each balloon.

Example 2 : 
    coordinates[] : [[1,3],[3,5]]
    output : 1
    explanation : One arrow can burst both , if arrow is fired from x = 3(vertically upwards).

Example 3 :
    coordinates[] : [[10,13],[3,5],[5,7],[1,5],[2,6],[12,14]]
    output : 2
    explanation : First arrow will burst 4 balloons i.e. [3,5],[5,7],[1,5] & [2,6] , if arrow is shot from x = 5(vertically upwards). Second arrow will burst 2 baloons i.e. [10,13] & [12,14] , if arrow is shot from x = 12(vertically upwards); 

Example 4 : 
    coordinates[] : [[1,3],[5,7],[9,10]]
    output : 3
Input Format
A Number "n" (no. of balloons)
sp_1 ep_1
sp_2 ep_2
sp_3 ep_3
sp_4 ep_4
.
.
.
sp_n ep_n
NOTE : 1. sp_i & ep_i are starting & ending coordinate of ith balloon.
    2. Input is handled for you.
Output Format
"find minimum number of arrows required to burst all Balloons"
(Output Format is handled for you.)
Question Video

  COMMENTConstraints
1. coordinates[i] = [sp_i,ep_i] ,  where sp_i & ep_i are starting & ending coordinate of ith balloon.
2. 0 <= sp_i <= ep_i
3. 0 < (Number of Balloons)coordinates[][] <= 10^6
4. length(coordinates[i]) = 2
Sample Input
2
1 3
4 5
Sample Output
2
*/

import java.util.*;

class find_minimum_number_of_arrows_to_burst_ballons {
    public static int minArrows(int coordinates[][]) {
        // write your code here

        List<Pair> list = new ArrayList<>();

        for(int [] c : coordinates){
            list.add(new Pair(c[0], c[1]));
        }

        Collections.sort(list);

        int cnt = 1;
        int end = list.get(0).e;
        
        for(int i = 1;i<list.size();i++){
            if(list.get(i).s > end){
                cnt++;
                end = list.get(i).e;
            }
        }

        return cnt;
    }

    static class Pair implements Comparable<Pair>{
        int s;
        int e;
        Pair(int s, int e){
            this.s = s;
            this.e = e;
        }

        public int compareTo(Pair o){
            return this.e - o.e;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // number of balloons
        int coordinates[][] = new int[n][2];
        for (int i = 0 ; i < n ; i++) {
            coordinates[i][0] = scn.nextInt();
            coordinates[i][1] = scn.nextInt();
        }

        System.out.println(minArrows(coordinates));
    }
}