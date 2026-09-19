/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();

        if (root == null) return levelOrder;

        TreeNode DUMMY = new TreeNode(1001, null, null);

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        q.offer(DUMMY);

        List<Integer> level = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            
            if (curr == DUMMY) {
                if (!q.isEmpty()) q.offer(DUMMY);
                levelOrder.add(level);
                level = new ArrayList<>();
                continue;
            }

            level.add(curr.val);

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }

        return levelOrder;
    }
}