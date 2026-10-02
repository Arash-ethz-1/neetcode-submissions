class Solution {
    public boolean exist(char[][] board, String word) {
        boolean found = false;
        String subWord = word.substring(1,word.length());
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i <  board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    found |= dfs(i, j, subWord, board, visited);
                } 
            }
        }

        return found;
    }

    private boolean dfs(int i, int j, String subWord, char[][] board, boolean[][] visited) {
        if (subWord.length() == 0) {
            return true;
        }

        
        visited[i][j] = true;
        boolean found = false;

        for (int k = -1; k < 2; k++) {
            if (k == 0) continue;

            int row = i + k;
            int col = j + k;
    
            if (row < board.length && 0 <= row && !visited[row][j] && board[row][j] == subWord.charAt(0)){
                found |= dfs(row, j, subWord.substring(1, subWord.length()), board, visited);
            }

            if (col < board[0].length && 0 <= col && !visited[i][col] && board[i][col] == subWord.charAt(0)){
                found |= dfs(i, col, subWord.substring(1, subWord.length()), board, visited);
            }

        }

        visited[i][j] = false;
        return found;
    }
}
