// Last updated: 24/01/2026, 00:09:21
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
18    private int sum = 0;
19
20    public TreeNode bstToGst(TreeNode root) {
21        return reverseInorder(root);
22    }
23
24    public TreeNode reverseInorder(TreeNode root) {
25
26        if (root == null)
27            return null;
28
29        // Visit right subtree first (greater values)
30        reverseInorder(root.right);
31
32        // Update sum and node value
33        sum += root.val;
34        root.val = sum;
35
36        // Visit left subtree
37        reverseInorder(root.left);
38
39        return root;
40    }
41}