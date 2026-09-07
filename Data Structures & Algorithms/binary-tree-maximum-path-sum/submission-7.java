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
    
    public int maxPathSum(TreeNode root) {
        AtomicInteger maxsum = new AtomicInteger(Integer.MIN_VALUE);
        maxPathSumUtil(root, maxsum);

        return maxsum.get();
    }

    public int maxPathSumUtil(TreeNode node, AtomicInteger maxsum) {
        if (node == null) return 0;

        int maxleft = maxPathSumUtil(node.left, maxsum);
        int maxright = maxPathSumUtil(node.right, maxsum);

        int sumwithcurrnodeasroot = maxleft + maxright + node.val;

        maxsum.set(Math.max(maxsum.get(), sumwithcurrnodeasroot));

        int maxchild = Math.max(maxleft, maxright);

        int pathsumwithnode = node.val + maxchild;

        return Math.max(pathsumwithnode, 0);
    }
}
