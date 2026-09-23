class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind();
        Map<String, String> emailOwners = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            String email1 = account.get(1);
            emailOwners.put(email1, name);
            for (int i = 2; i < account.size(); i++) {
                emailOwners.put(account.get(i), name);
                uf.union(email1, account.get(i));
            }
        }

        Map<String, List<String>> components = new HashMap<>();
        for (String email : emailOwners.keySet()) {
            String component = uf.find(email);
            List<String> emails = components.get(component);
            if (emails == null) {
                emails = new ArrayList<>();
                components.put(component, emails);
            }
            emails.add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : components.entrySet()) {
            List<String> account = new ArrayList<>();
            account.add(emailOwners.get(entry.getKey()));
            entry.getValue().sort(null);
            account.addAll(entry.getValue());
            result.add(account);
        }
        return result;
    }
}

class UnionFind {
    Map<String, String> parents = new HashMap<>();
    Map<String, Integer> sizes = new HashMap<>();
    Set<String> nodes = new HashSet<>();
    int cc = 0;

    void union(String s1, String s2) {
        String root1 = find(s1);
        String root2 = find(s2);
        if (root1.equals(root2)) return;

        int sz1 = sizes.get(root1);
        int sz2 = sizes.get(root2);

        if (sz1 > sz2) {
            parents.put(root2, root1);
            sizes.put(root1, sz1 + sz2);
        } else {
            parents.put(root1, root2);
            sizes.put(root2, sz1 + sz2);
        }
        cc--;
    }

    boolean connected(String s1, String s2) {
        return find(s1).equals(find(s2));
    }

    String find(String s) {
        init(s);

        String parent = parents.get(s);
        if (parent.equals(s)) return parent;

        String gParent = parents.get(parent);
        parents.put(s, gParent);

        return find(parent);
    }

    void init(String s) {
        if (nodes.contains(s)) return;
        parents.put(s, s);
        sizes.put(s, 1);
        nodes.add(s);
        cc++;
    }

    int connectedComponents() {
        return cc;
    }
}