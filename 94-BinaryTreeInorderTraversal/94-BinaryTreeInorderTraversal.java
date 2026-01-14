// Last updated: 14/01/2026, 09:23:46
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
18    public List<Integer> inorderTraversal(TreeNode root) {
19        
20        List<Integer> ls= new ArrayList<>();        
21
22        if(root==null) return ls;
23        inorderTraversalRec(root, ls);
24        return ls;
25    }
26    public void inorderTraversalRec(TreeNode root, List<Integer> ls){
27        if(root.left != null) inorderTraversalRec(root.left, ls);
28        ls.add(root.val);
29        if(root.right != null) inorderTraversalRec(root.right, ls);       
30    }
31}