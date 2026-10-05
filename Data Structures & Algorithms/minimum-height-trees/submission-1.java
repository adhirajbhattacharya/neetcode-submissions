class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }

        Graph g = new Graph(n, edges);

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < g.v; i++) {
            if (g.indegrees[i] == 1) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            if (n <= 2) break;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                g.indegrees[curr] = g.indegrees[curr] - 1;
                n--;
                for (int neighbor : g.adj[curr]) {
                    g.indegrees[neighbor] = g.indegrees[neighbor] - 1;
                    if (g.indegrees[neighbor] == 1) {
                        q.offer(neighbor);
                    }
                }
            }
        }

        // while (!q.isEmpty()) {
        //     res.add(q.poll());
        // }

        // for (int i = 0; i < g.v; i++) {
        //     if (g.indegrees[i] > 0) {
        //         res.add(i);
        //     }
        // }

        return new ArrayList<>(q);
    }
}

class Graph {
    List<Integer>[] adj;
    int v;
    int[] indegrees;

    Graph(int n, int[][] edges) {
        v = n;
        adj = new List[n];
        indegrees = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            addEdge(edge);
        }
    }

    void addEdge(int[] edge) {
        int a = edge[0];
        int b = edge[1];
        adj[a].add(b);
        adj[b].add(a);
        indegrees[a] = indegrees[a] + 1;
        indegrees[b] = indegrees[b] + 1;
    }
}