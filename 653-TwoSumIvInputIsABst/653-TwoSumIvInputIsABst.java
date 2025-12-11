// Last updated: 11/12/2025, 09:57:20
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
    public boolean findTarget(TreeNode root, int k) {

        Set<Integer> set= new HashSet<>();
        return findTarget2(root, k, set);
        
    }

    public boolean findTarget2(TreeNode root, int k, Set<Integer> set){
        if(root==null)
            return false;

        if(set.contains(k-root.val))
            return true;

        set.add(root.val);    

        //DFS -> calling recusion with left element || right element
        return findTarget2(root.left, k,set) || findTarget2(root.right, k, set);
    }
}