// Last updated: 27/02/2026, 05:38:04
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
17    public List<Integer> inorderTraversal(TreeNode root) {
18
19        List<Integer> res = new ArrayList<>();
20        dfs(root, res);
21        return res;
22    }
23
24    private void dfs(TreeNode node, List<Integer> res) {
25
26        if (node == null)
27            return;
28
29        dfs(node.left, res);
30        res.add(node.val);
31        dfs(node.right, res);
32    }
33}