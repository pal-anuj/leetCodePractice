// Last updated: 28/08/2026, 00:19:06
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
17    public List<Integer> rightSideView(TreeNode root) {
18        List<Integer> res = new ArrayList<>();
19        if (root == null) return res;
20        Queue<TreeNode> q = new LinkedList<>();
21        q.add(root);
22        while (!q.isEmpty()) {
23            int n = q.size();
24            for (int i = 0; i < n; i++) {
25                TreeNode curr = q.poll();
26                if (i == n - 1) {
27                    res.add(curr.val);
28                }
29
30                if (curr.left != null) q.offer(curr.left);
31                if (curr.right != null) q.offer(curr.right);
32            }
33        }
34
35        return res;
36    }
37}