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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();
        if (root != null) q.offer(root);

        while(!q.isEmpty()) {
            int sz = q.size();
            Integer right = null;
            for (int i = 0; i < sz; i++) {
                TreeNode curr = q.poll();
                right = curr.val;
                
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            view.add(right);
        }

        return view;
    }
}