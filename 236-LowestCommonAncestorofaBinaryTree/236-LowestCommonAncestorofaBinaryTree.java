// Last updated: 23/01/2026, 22:55:38
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10class Solution {
11    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
12        if (root == null)
13            return null;
14
15        if (root == p || root == q)
16            return root;
17
18        TreeNode lLCA = lowestCommonAncestor(root.left, p, q);
19        TreeNode rLCA = lowestCommonAncestor(root.right, p, q);
20
21        if (lLCA != null && rLCA != null)
22            return root;
23        else if (lLCA != null)
24            return lLCA;
25        else
26            return rLCA;
27
28    }
29}