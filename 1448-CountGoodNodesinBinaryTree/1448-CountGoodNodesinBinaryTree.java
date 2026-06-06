// Last updated: 06/06/2026, 11:02:46
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
17
18    int count = 0;
19
20    public int goodNodes(TreeNode root) {
21        dfs(root, root.val);
22        return count;
23    }
24
25    void dfs(TreeNode node, int maxSoFar) {
26
27        if (node == null)
28            return;
29        if (node.val >= maxSoFar) {
30            count++;
31            maxSoFar = node.val;
32        }
33        dfs(node.left, maxSoFar);
34        dfs(node.right, maxSoFar);
35    }
36}