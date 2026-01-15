// Last updated: 15/01/2026, 22:00:39
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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int left = heightOfBT(root.left);
        int right = heightOfBT(root.right);

        int diff = Math.abs(left - right);
        if(diff>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int heightOfBT(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = heightOfBT(root.left);
        int right = heightOfBT(root.right);

        return Math.max(left,right)+1;
    }
}