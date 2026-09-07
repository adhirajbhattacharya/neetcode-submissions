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
    
    int maxsum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);

        return maxsum;
    }

    public int maxPathSumUtil(TreeNode node) {
        if (node == null) return 0;

        int maxleft = maxPathSumUtil(node.left);
        int maxright = maxPathSumUtil(node.right);

        int sumwithcurrnodeasroot = maxleft + maxright + node.val;

        maxsum = Math.max(maxsum, sumwithcurrnodeasroot);

        int maxchild = Math.max(maxleft, maxright);

        int pathsumwithnode = node.val + maxchild;

        return Math.max(pathsumwithnode, 0);
    }
}
