// Last updated: 17/09/2025, 00:16:40
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
    public TreeNode deleteNode(TreeNode root, int key) {
        // Base case
        if(root==null)
            return root;

        // If key to be searched is in a subtree
        if(root.val> key)
            root.left= deleteNode(root.left, key);
        else if(root.val<key)
            root.right= deleteNode(root.right, key);
        else{
            // If root matches with the given key
            // Cases when root has 0 children or
            // only right child
            if(root.left==null)
            {
                return root.right;
            }
            // When root has only left child
            else if(root.right==null){
                return root.left;
            }
            // When both children are present
            else{
                TreeNode succ= getSuccessor(root);
                root.val=succ.val;
                root.right= deleteNode(root.right, succ.val);
            }
        }                            

        return root;

    }
    
    // Note that it is not a generic inorder successor 
    // function. It mainly works when the right child
    // is not empty, which is the case we need in BST
    // delete. 
    public static TreeNode getSuccessor(TreeNode root){
        TreeNode node= root.right;
        while(node.left!=null)
            node=node.left;

        return node;
    }
}