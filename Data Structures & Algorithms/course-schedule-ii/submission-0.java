class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        Graph g = new Graph(numCourses, prerequisites);

        int[] topo = new int[numCourses];
        int count = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (g.indegrees[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            topo[count++] = curr;
            for (int i : g.adj[curr]) {
                g.indegrees[i] -= 1;
                if (g.indegrees[i] == 0) q.offer(i);
            }
        }
        
        boolean isTopoPossible = Arrays.stream(g.indegrees).filter(i -> i != 0).count() == 0L;

        return isTopoPossible ? topo : new int[0];
    }
}

class Graph {
    List<Integer>[] adj;
    int v;
    int[] indegrees;

    Graph(int v, int[][] edges) {
        this.v = v;
        this.indegrees = new int[v];
        this.adj = (List<Integer>[]) new List[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            addEdge(edge[1], edge[0]);
        }
    }

    private void addEdge(int s, int d) {
        adj[s].add(d);
        indegrees[d] += 1;
    }
}