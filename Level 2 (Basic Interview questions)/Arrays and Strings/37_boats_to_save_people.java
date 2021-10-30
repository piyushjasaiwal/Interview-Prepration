/*abstract
1. You are given an array people where people[i] is the weight of the ith person.
2. You have infinite number of boats where each boat can carry a maximum weight of limit. 
3. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
4. Return the minimum number of boats to carry every given person.
Input Format
people = [3,2,2,1], limit = 3
Output Format
3
Explanation: 3 boats (1, 2), (2) and (3)
Question Video

  COMMENTConstraints
1. 1 <= people.length <= 5 * 10^4
2. 1 <= people[i] <= limit <= 3 * 10^4
Sample Input
4
3 2 2 1
3
Sample Output
3
*/


import java.util.*;

class boats_to_save_people {

  // ~~~~~~~~~~~User's Section~~~~~~~~~~~~
    public static int numRescueBoats(int[] people, int limit) {
        // write your code here
        Arrays.sort(people);
        int cnt = 0;
        int i = 0;
        int j = people.length-1;

        while(i<=j){
            if(i == j){
                i++;
                j--;
                cnt++;
            }else{
                if(people[i] + people[j] <= limit){
                    i++;
                    j--;
                    cnt++;
                }else{
                    cnt++;
                    j--;
                }
            }
        }

        return cnt;
    }

  // ~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] people = new int[n];

        for (int i = 0; i < n; i++)
            people[i] = scn.nextInt();

        int limit = scn.nextInt();
        int boats = numRescueBoats(people, limit);
        System.out.println(boats);
    }
}