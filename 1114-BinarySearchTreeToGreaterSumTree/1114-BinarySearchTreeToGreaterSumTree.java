// Last updated: 24/01/2026, 00:09:40
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

    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        return reverseInorder(root);
    }

    public TreeNode reverseInorder(TreeNode root) {

        if (root == null)
            return null;

        // Visit right subtree first (greater values)
        reverseInorder(root.right);

        // Update sum and node value
        sum += root.val;
        root.val = sum;

        // Visit left subtree
        reverseInorder(root.left);

        return root;
    }
}