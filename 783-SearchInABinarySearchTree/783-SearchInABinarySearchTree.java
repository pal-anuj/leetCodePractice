// Last updated: 11/12/2025, 09:57:19
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
    public TreeNode searchBST(TreeNode root, int key) {
        if(root==null)
            return root;

        if(root.val==key)
            return root;
        else if(root.val>key)   
            return searchBST(root.left, key);
        else
            return searchBST(root.right, key);

    }
}