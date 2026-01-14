// Last updated: 14/01/2026, 09:23:16
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
17    public List<Integer> postorderTraversal(TreeNode root) {
18        List<Integer> ls = new ArrayList<>();
19        if( root ==null) return ls;
20        postorderTraversalRec(root, ls);
21        return ls;
22    }
23
24    public void postorderTraversalRec(TreeNode root, List<Integer> ls){
25        if (root.left!=null) postorderTraversalRec(root.left, ls);
26        if (root.right!=null) postorderTraversalRec(root.right, ls);
27        ls.add(root.val);
28    }
29
30}