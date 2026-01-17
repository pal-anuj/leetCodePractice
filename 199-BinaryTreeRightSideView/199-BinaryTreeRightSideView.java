// Last updated: 17/01/2026, 12:45:01
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
18        if (root == null)
19            return new ArrayList<>();
20
21        List<Integer> res = new ArrayList<>();
22        Queue<TreeNode> q = new LinkedList<>();
23        q.offer(root);
24
25        while (!q.isEmpty()) {
26            int n = q.size();
27
28            for (int i = 0; i < n; i++) {
29                TreeNode curr = q.poll();
30                if (i == n - 1)
31                    res.add(curr.val);
32
33                if (curr.left != null)
34                    q.offer(curr.left);
35                if (curr.right != null)
36                    q.offer(curr.right);
37            }
38        }
39        return res;
40
41    }
42}