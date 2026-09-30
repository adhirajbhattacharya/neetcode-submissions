class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Graph g = new Graph(accounts);
        Set<String> visited = new HashSet<>();
        List<List<String>> out = new ArrayList<>();

        for (String e : g.vertices) {
            List<String> emails = dfs(g, e, visited, new ArrayList<>());
            if (emails.isEmpty()) continue;
            List<String> account = new ArrayList<>();
            account.add(g.owners.get(e));
            Collections.sort(emails);
            account.addAll(emails);
            out.add(account);
        }
        return out;
    }

    List<String> dfs(Graph g, String v, Set<String> visited, List<String> emails) {
        if (visited.contains(v)) return emails;
        emails.add(v);
        visited.add(v);
        for (String e : g.adj.get(v)) {
            emails = dfs(g, e, visited, emails);
        }
        return emails;
    }
}

class Graph {
    Map<String, List<String>> adj = new HashMap<>();
    Map<String, String> owners = new HashMap<>();
    Set<String> vertices = new HashSet<>();

    Graph(List<List<String>> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            String name = account.get(0);
            String e1 = account.get(1);
            owners.put(e1, name);
            vertices.add(e1);
            adj.putIfAbsent(e1, new ArrayList<>());
            for (int j = 2; j < account.size(); j++) {
                String e2 = account.get(j);
                owners.put(e2, name);
                vertices.add(e2);
                adj.putIfAbsent(e2, new ArrayList<>());
                addEdge(e1, e2);
            }
        }
    }

    void addEdge(String e1, String e2) {
        adj.get(e1).add(e2);
        adj.get(e2).add(e1);
    }
}