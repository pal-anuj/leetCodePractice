// Last updated: 19/01/2026, 23:39:50
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
18    int prev = 0;
19
20    public int kthSmallest(TreeNode root, int k) {
21        if (root == null)
22            return -1;
23
24        if (root.left != null) {
25            int leftAns = kthSmallest(root.left, k);
26            if (leftAns != -1)
27                return leftAns;
28        }
29
30        prev++;
31        if (prev == k)
32            return root.val;
33
34        if (root.right != null) {
35            int rightAns = kthSmallest(root.right, k);
36            if (rightAns != -1)
37                return rightAns;
38        }
39        return -1;
40    }
41}