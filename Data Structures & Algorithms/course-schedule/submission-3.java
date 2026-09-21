class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses, prerequisites);
        g.runTopoSort();
        return g.isDag();
    }
}

class Graph {
    int v;
    List<Integer>[] adj;
    int[] indegrees;
    List<Integer> topoOrder;

    Graph(int numCourses, int[][] prerequisites) {
        this.v = numCourses;
        adj = new List[v];
        indegrees = new int[v];
        topoOrder = new ArrayList<>();
        
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] dep : prerequisites) {
            adj[dep[1]].add(dep[0]);
            indegrees[dep[0]]++;
        }
    }

    void runTopoSort() {
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < v; i++) {
            if (indegrees[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            topoOrder.add(curr);

            for(int i : adj[curr]) {
                indegrees[i] -= 1;
                if (indegrees[i] == 0) q.offer(i);
            }
        }
    }

    boolean isDag() {
        return v == topoOrder.size();
    }
}