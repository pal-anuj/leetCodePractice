// Last updated: 15/01/2026, 12:47:13
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
17    public boolean isSymmetric(TreeNode root) {
18        if (root == null)
19            return false;
20        return isSymmetricHelp(root.left, root.right);
21    }
22
23    public boolean isSymmetricHelp(TreeNode left, TreeNode right) {
24        if (left == null || right == null)
25            return left == right;
26
27        if(left.val!= right.val)
28            return false;
29
30        return  isSymmetricHelp(left.left, right.right) 
31                && 
32                isSymmetricHelp(left.right, right.left);     
33    }
34}