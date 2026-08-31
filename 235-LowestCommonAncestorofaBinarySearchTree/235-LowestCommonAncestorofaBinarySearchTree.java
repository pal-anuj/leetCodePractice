// Last updated: 31/08/2026, 05:41:04
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
13        while (root != null) {
14            // Both nodes are in the left subtree
15            if (root.val > p.val && root.val > q.val) {
16                root= root.left;
17            } 
18            // Both nodes are in the right subtree
19            else if (root.val < p.val && root.val < q.val) {
20                root= root.right;
21            } 
22             // They split here, or root is p/q
23            else
24                return root;
25        }
26        return null;
27
28        // // Using Recursion, Time: O(n), SPace: O(n) stack space
29        // if (root == null) return null;
30
31        // if (root.val > p.val && root.val > q.val) {
32        //     return lowestCommonAncestor(root.left, p, q);
33        // }
34        // if (root.val < p.val && root.val < q.val) {
35        //     return lowestCommonAncestor(root.right, p, q);
36        // }
37        // return root;
38    }
39}