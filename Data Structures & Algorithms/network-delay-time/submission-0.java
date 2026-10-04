class Solution {
    record Edge(int to, int weight) {}

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int m = times.length;
        for (int i = 0; i < m; i++) {
            graph.get(times[i][0]).add(new Edge(times[i][1], times[i][2]));
        }

        int[] dist = dijkstra(k, graph);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }


    private int[] dijkstra(int start,List<List<Edge>> graph) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int currNode = cur[0], currDist = cur[1];
            for (Edge neighbour : graph.get(currNode)) {
                if (currDist + neighbour.weight() < dist[neighbour.to()]) {
                    pq.offer(new int[]{neighbour.to(), currDist + neighbour.weight()});
                    dist[neighbour.to()] = currDist + neighbour.weight();
                }
            }
            
        }

        return dist;
    }
}
