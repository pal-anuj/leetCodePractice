// Last updated: 19/01/2026, 22:08:33
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
17    long prev = Long.MIN_VALUE;
18
19    public boolean isValidBST(TreeNode root) {
20        if (root == null)
21            return true;
22
23        if (isValidBST(root.left) == false)
24            return false;
25        if (root.val <= prev)
26            return false;
27
28        prev = root.val;
29        return isValidBST(root.right);
30    }
31}