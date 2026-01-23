// Last updated: 23/01/2026, 22:19:56
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
17    public List<List<Integer>> levelOrder(TreeNode root) {
18
19        List<List<Integer>> res = new ArrayList<>();
20        if (root == null)
21            return res;
22        Queue<TreeNode> q = new LinkedList<>();
23        q.offer(root);
24
25        while (!q.isEmpty()) {
26            int n = q.size();
27            List<Integer> ls = new ArrayList<>();
28            for (int i = 0; i < n; i++) {
29                TreeNode temp = q.poll();
30                ls.add(temp.val);
31                if (temp.left != null)
32                    q.offer(temp.left);
33                if (temp.right != null)
34                    q.offer(temp.right);
35            }
36            res.add(ls);
37        }
38        return res;
39    }
40}