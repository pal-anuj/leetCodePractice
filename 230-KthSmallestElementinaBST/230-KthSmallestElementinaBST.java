// Last updated: 30/08/2026, 22:15:13
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
16
17class Solution {
18    int preOrder=0;
19    public int kthSmallest(TreeNode root, int k) {
20        return kthSmallestDFS(root, k);
21    }
22
23    public int kthSmallestDFS(TreeNode root, int k) {
24        if (root == null)
25            return -1;
26
27        if (root.left != null) {
28            int left = kthSmallestDFS(root.left, k);
29            if (left != -1)
30                return left;
31        }
32        preOrder++;
33        if (preOrder == k) {
34            return root.val;
35        }
36
37        return kthSmallestDFS(root.right, k);
38    }
39}