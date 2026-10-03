class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, graph, visited);
                count++;
            }
        }

        return count;
    }

    private void bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            for(int neighbour : graph.get(current)) {
                if (!visited[neighbour]) {
                    q.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
}
