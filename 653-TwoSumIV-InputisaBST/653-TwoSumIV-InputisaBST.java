// Last updated: 31/08/2026, 05:58:30
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
17    public boolean findTarget(TreeNode root, int k) {
18        HashSet<Integer> set= new HashSet<>();
19        return findTargetDFS(root, set, k);
20    }
21
22    public boolean findTargetDFS(TreeNode root, HashSet<Integer> set, int k){
23        if(root==null) return false;
24
25        if(set.contains(k-root.val)) return true;
26        set.add(root.val);
27
28        return findTargetDFS(root.left, set, k) || 
29            findTargetDFS(root.right, set, k);
30        
31    }
32}