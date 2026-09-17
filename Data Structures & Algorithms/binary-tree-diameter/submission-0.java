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
    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        return diameterOfBinaryTree(root, memo);
    }

    int diameterOfBinaryTree(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) return 0;

        int left = maxHeight(root.left, memo);
        int right = maxHeight(root.right, memo);

        int diaWithCurrent = left + right;
        int diaLeft = diameterOfBinaryTree(root.left, memo);
        int diaRight = diameterOfBinaryTree(root.right, memo);

        return Math.max(diaWithCurrent, Math.max(diaLeft, diaRight));
    }

    int maxHeight(TreeNode node, Map<TreeNode, Integer> memo) {
        if (node == null) return 0;

        Integer ht = memo.get(node);

        if (ht != null) return ht;

        int leftHt = maxHeight(node.left, memo);
        int rightHt = maxHeight(node.right, memo);

        ht = 1 + Math.max(leftHt, rightHt);
        memo.put(node, ht);

        return ht;
    }
}