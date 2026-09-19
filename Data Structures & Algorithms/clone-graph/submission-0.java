/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> memo = new HashMap<>();
        dfs(node, memo);
        
        return memo.get(node);
    }

    void dfs(Node node, Map<Node, Node> memo) {
        if (memo.containsKey(node)) return;

        Node clone = new Node(node.val);
        memo.put(node, clone);

        for (Node n : node.neighbors) {
            dfs(n, memo);
            clone.neighbors.add(memo.get(n));
        }
    }
}