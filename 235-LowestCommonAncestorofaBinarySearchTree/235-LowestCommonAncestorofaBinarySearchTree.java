// Last updated: 31/08/2026, 05:36:45
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10
11class Solution {
12    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
13        if (root == null) return null;
14
15        if (root.val > p.val && root.val > q.val) {
16            return lowestCommonAncestor(root.left, p, q);
17        }
18        if (root.val < p.val && root.val < q.val) {
19            return lowestCommonAncestor(root.right, p, q);
20        }
21        return root;
22    }
23}