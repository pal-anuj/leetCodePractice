// Last updated: 15/01/2026, 21:20:52
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
17    // for binary tree balanace factor should be 1,0
18    boolean isbal=true;
19    public boolean isBalanced(TreeNode root) {
20        if(root==null) return true;
21        DFS(root);
22        return isbal;
23    }
24
25    public int DFS(TreeNode root){
26        if(root==null) return 0;
27        if(!isbal) return 0;
28        int leftheight= DFS(root.left);
29        int rightheight= DFS(root.right);
30
31        int balfactor= leftheight - rightheight;
32        if(balfactor > 1 || balfactor < -1)
33            isbal=false;
34
35        return 1+ Math.max(DFS(root.left), DFS(root.right));
36    }
37}
38