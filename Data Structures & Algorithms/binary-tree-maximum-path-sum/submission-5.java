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
    
    // int maxsum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        int[] maxsum = new int[] {Integer.MIN_VALUE};
        maxPathSumUtil(root, maxsum);

        return maxsum[0];
    }

    public int maxPathSumUtil(TreeNode node, int[] maxsum) {
        if (node == null) return 0;

        int maxleft = maxPathSumUtil(node.left, maxsum);
        int maxright = maxPathSumUtil(node.right, maxsum);

        int sumwithcurrnodeasroot = maxleft + maxright + node.val;

        maxsum[0] = Math.max(maxsum[0], sumwithcurrnodeasroot);

        int maxchild = Math.max(maxleft, maxright);

        int pathsumwithnode = node.val + maxchild;

        return Math.max(pathsumwithnode, 0);
    }
}
