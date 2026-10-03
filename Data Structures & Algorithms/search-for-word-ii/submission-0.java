class Solution {
    private int n;
    private int m;

    private static class TrieNode {
        TrieNode[] childern = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {

        //build the tree
        TrieNode root = new TrieNode();
        TrieNode dummy = root;

        for (String word : words) {
            char[] charWord = word.toCharArray();
            int n = charWord.length;
            root = dummy;

            for (int i = 0; i < n-1; i++) {
                if (root.childern[charWord[i] -'a'] != null) {
                    root = root.childern[charWord[i] -'a'];
                } else {
                    root.childern[charWord[i] -'a'] = new TrieNode();
                    root = root.childern[charWord[i] -'a'];
                }
            }

            if (root.childern[charWord[n-1] - 'a'] != null) {
                    root = root.childern[charWord[n-1] - 'a'];
                    root.word = word;
            } else {
                    root.childern[charWord[n-1] - 'a'] = new TrieNode();
                    root = root.childern[charWord[n-1] - 'a'];
                    root.word = word;
            }
            
        }

        
        this.n = board.length;
        this.m = board[0].length;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n;  i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] visited = new boolean[n][m];
                root = dummy;
                dfs(i, j, root, visited, board, result);           
            }
        }

    return result;
    }


    private void dfs(int i, int j, TrieNode root, boolean[][] visited, char[][] board, List<String> result) {
        if (root.word != null) {                 // previous cell: check first
        result.add(root.word);
        root.word = null;                    // avoid adding it 4 times
        }
        
        if (i < 0 || i >= n || j >= m || j < 0 || visited[i][j]) return;

        visited[i][j] = true;

        if (root.childern[board[i][j] - 'a'] != null) {
            root = root.childern[board[i][j] - 'a'];
            dfs(i, j + 1, root, visited, board, result);  
            dfs(i, j - 1, root, visited, board, result);
            dfs(i + 1, j, root, visited, board, result);  
            dfs(i - 1, j, root, visited, board, result);  
     }

        visited[i][j] = false;
    }

    
}
