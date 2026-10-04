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
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestDfs(root, new int[] { k });
    }

    int kthSmallestDfs(TreeNode node, int[] k) {
        if (node == null) return -1;

        int l = kthSmallestDfs(node.left, k);
        if (k[0] == 0) return l;
        
        k[0]--;
        if (k[0] == 0) return node.val;

        int r = kthSmallestDfs(node.right, k);
        if (k[0] == 0) return r;

        return -1;

        // if (node == null) return -1;
        
        // // 1. Check before going left
        // if (out.size() == k) return out.get(k - 1);
        // int leftResult = kthSmallest(node.left, k, out);
        // // If the left subtree already found it, pass it up
        // if (out.size() == k) return leftResult;
        
        // // 2. Process current node
        // out.add(node.val);
        // if (out.size() == k) return out.get(k - 1);
        
        // // 3. Go right
        // return kthSmallest(node.right, k, out);
    }
}