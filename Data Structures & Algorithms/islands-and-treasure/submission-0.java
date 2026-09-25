class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }

        int[] current;
        int currentDistance;
        

        while (!q.isEmpty()) {
            current = q.poll();
            currentDistance = grid[current[0]][current[1]];

            for (int[] neighbour : neighbours(current[0], current[1], m, n)) {
                if (grid[neighbour[0]][neighbour[1]] == 2147483647) {
                    grid[neighbour[0]][neighbour[1]] = currentDistance + 1;
                    q.add(neighbour);
                }
            }

        }
    }

    private int[][] neighbours(int i, int j, int gridNumRow, int gridNumCol){
        List<int[]> arr = new ArrayList<>();
        arr.add(new int[]{i+1, j});
        arr.add(new int[]{i-1, j});
        arr.add(new int[]{i, j+1});
        arr.add(new int[]{i, j-1});

        arr.removeIf(x -> x[0] >= gridNumRow || x[0] < 0 || x[1] >= gridNumCol || x[1] < 0);
        return arr.toArray(new int[0][]);
    }

    
}
