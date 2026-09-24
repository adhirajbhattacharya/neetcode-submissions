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
    Map<Integer, Integer> memo = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            memo.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n - 1, 0, n - 1, memo);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int pr_st, int pr_en, int in_st, int in_en, Map<Integer, Integer> memo) {
        if (in_st > in_en) return null;

        int nodeval = preorder[pr_st];
        int in_idx = find(inorder, in_st, in_en, nodeval, memo);

        TreeNode node = new TreeNode(nodeval);

        int left_sz = (in_idx - 1) - in_st;
        int pr_st_left = pr_st + 1;
        int pr_en_left = pr_st_left + left_sz;

        int right_sz = in_en - (in_idx + 1);
        int pr_st_right = pr_en_left + 1;
        int pr_en_right = pr_en;


        node.left = buildTree(preorder, inorder, pr_st_left, pr_en_left, in_st, in_idx - 1, memo);
        node.right = buildTree(preorder, inorder, pr_en_left + 1, pr_en_right, in_idx + 1, in_en, memo);

        return node;
    }

    int find(int[] inorder, int in_st, int in_en, int nodeval, Map<Integer, Integer> memo) {
        return memo.getOrDefault(nodeval, -1);
    }
}