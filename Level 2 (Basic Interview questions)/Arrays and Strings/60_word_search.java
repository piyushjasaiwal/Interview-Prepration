/*abstract
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
*/

class word_search{
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        Solution_word_search sol = new Solution_word_search();
        System.out.println(sol.exist(board, word));
    }
}

class Solution_word_search{
    public boolean exist(char[][] board, String word) {
        boolean [][] taken = new boolean[board.length][board[0].length];
        boolean ans = false;
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                ans = ans || exists_helper(i, j, board, word, taken, 0);
                if(ans){
                    return true;
                }
            }
        }
        return ans;
    }

    private boolean  exists_helper(int r, int c, char[][] board, String word, boolean[][] taken, int vidx) {
        boolean ans = false;
        

        if(vidx >= word.length()){
            return true;
        }

        if(r >= board.length || c >= board[0].length || r < 0 || c < 0 || taken[r][c] || board[r][c] != word.charAt(vidx)){
            return false;
        }

        taken[r][c] = true;
        ans = ans || exists_helper(r+1, c, board, word, taken, vidx+1);
        ans = ans || exists_helper(r-1, c, board, word, taken, vidx+1);
        ans = ans || exists_helper(r, c+1, board, word, taken, vidx+1);
        ans = ans || exists_helper(r, c-1, board, word, taken, vidx+1);
        taken[r][c] = false;
        
        return ans;
    }
}