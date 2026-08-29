// Last updated: 29/08/2026, 20:17:24
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    long prev= Long.MIN_VALUE;
18    public boolean isValidBST(TreeNode root) {
19        if(root==null) return true;
20
21        if(isValidBST(root.left)==false){
22            return false;
23        }
24
25        if(root.val <= prev) return false;
26        prev= (long)root.val;
27        return isValidBST(root.right);
28    }
29}