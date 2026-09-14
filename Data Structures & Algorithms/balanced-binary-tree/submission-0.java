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
    static final Map<TreeNode, Integer> memo = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        if (!isBalanced(root.left) || !isBalanced(root.right)) return false;

        int height_left = height(root.left, 0, memo);
        int height_right = height(root.right, 0, memo);

        return Math.abs(height_left - height_right) <= 1;
    }

    int height(TreeNode node, int count, Map<TreeNode, Integer> memo) {
        if (node == null) return count;

        Integer height = memo.get(node);

        if (height != null) return height;

        int height_left = height(node.left, count, memo);
        int height_right = height(node.right, count, memo);

        height = 1 + (height_left > height_right ? height_left : height_right);

        return height;
    }
}