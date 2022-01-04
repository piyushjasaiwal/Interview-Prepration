/*abstract
It is so boring in the summer holiday, isn't it? So Alice and Bob have invented a new game to play. The rules are as follows. First, they get a set of n distinct integers. And then they take turns to make the following moves. During each move, either Alice or Bob (the player whose turn is the current) can choose two distinct integers x and y from the set, such that the set doesn't contain their absolute difference |x - y|. Then this player adds integer |x - y| to the set (so, the size of the set increases by one).

If the current player has no valid move, he (or she) loses the game. The question is who will finally win the game if both players play optimally. Remember that Alice always moves first.

Input
The first line contains an integer n (2 ≤ n ≤ 100) — the initial number of elements in the set. The second line contains n distinct space-separated integers a1, a2, ..., an (1 ≤ ai ≤ 109) — the elements of the set.

Output
Print a single line with the winner's name. If Alice wins print "Alice", otherwise print "Bob" (without quotes).

Examples
inputCopy
2
2 3
outputCopy
Alice
inputCopy
2
5 3
outputCopy
Alice
inputCopy
3
5 6 7
outputCopy
Bob
Note
Consider the first test sample. Alice moves first, and the only move she can do is to choose 2 and 3, then to add 1 to the set. Next Bob moves, there is no valid move anymore, so the winner is Alice.
*/

import java.util.*;


class Alice_Bob{
    static int cnt ;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        ArrayList<Long> list = new ArrayList<>();
        HashSet<Long> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            list.add(s.nextLong());
            set.add(list.get(i));
        }

        cnt = 0;

        while(true){
            boolean flag = is_any(list, set);
            if(!flag){
                break;
            }
        }

        // System.out.println(cnt);
        // System.out.println(list);
        if(cnt%2 == 1){
            System.out.println("Alice");
        }else{
            System.out.println("Bob");
        }
    }

    private static boolean is_any(ArrayList<Long> list, HashSet<Long> set) {
        boolean flag = false;
        int size = list.size();
        for(int i = 0;i<size;i++){
            for(int j = i+1;j<size;j++){
                long dif = Math.abs(list.get(i)-list.get(j));
                if(!set.contains(dif)){
                    list.add(dif);
                    set.add(dif);
                    cnt ++;
                    flag = true;
                }
            }
        }
        return flag;
    }
}