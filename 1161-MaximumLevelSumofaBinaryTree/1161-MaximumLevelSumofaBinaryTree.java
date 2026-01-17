// Last updated: 17/01/2026, 16:13:14
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
17    public int maxLevelSum(TreeNode root) {
18        if (root == null)
19            return 0;
20
21        Queue<TreeNode> q = new LinkedList<>();
22        q.offer(root);
23        int currLevel = 0;
24        int level=0; //level which have max sum
25
26        int maxSum = Integer.MIN_VALUE;
27        while (!q.isEmpty()) {
28            int n = q.size();
29            currLevel++;
30
31            int currSum = 0;
32            for (int i = 0; i < n; i++) {
33                TreeNode temp = q.poll();
34                System.out.println(temp.val);
35                currSum += temp.val;
36
37                if (temp.left != null)
38                    q.offer(temp.left);
39                if (temp.right != null)
40                    q.offer(temp.right);
41            }
42            if (maxSum < currSum) {
43                maxSum = currSum;
44                level= currLevel;
45            }
46        }
47        return level;
48    }
49}