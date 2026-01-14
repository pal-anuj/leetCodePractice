// Last updated: 14/01/2026, 09:23:34
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
17    public List<Integer> preorderTraversal(TreeNode root) {
18        List<Integer> res= new ArrayList<>();
19        if(root ==null) return res;
20        preorderTraversalRec(root, res);
21        return res;    
22    }
23
24    public void preorderTraversalRec(TreeNode root, List<Integer> res){
25        res.add(root.val);
26        if(root.left!=null) preorderTraversalRec(root.left, res);        
27        if(root.right !=null) preorderTraversalRec(root.right, res);
28    }
29}