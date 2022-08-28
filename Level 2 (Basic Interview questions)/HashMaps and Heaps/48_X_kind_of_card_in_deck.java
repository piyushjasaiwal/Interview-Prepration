/*
 * In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

Each group has exactly X cards.
All the cards in each group have the same integer.
 

Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
Example 2:

Input: deck = [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.
 

Constraints:

1 <= deck.length <= 104
0 <= deck[i] < 104
 */

import java.util.*;

class Solution_X_kind_of_card_in_deck {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length == 0 || deck.length == 1){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int c : deck){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        if(map.size() == 1){
            return true;
        }
        
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        int gcd = gcd(map.get(keys.get(0)), map.get(keys.get(1)));
        for(int i = 2;i<keys.size();i++){
            gcd = gcd(gcd, map.get(keys.get(i)));
        }
        return gcd != 1;
    }
    
    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        
        return gcd(b, a%b);
    }
}