// Last updated: 28/08/2026, 00:15:22
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
17    public List<List<Integer>> levelOrder(TreeNode root) {
18        List<List<Integer>> res= new ArrayList<>();
19        if(root == null) return res;
20        Queue<TreeNode> q= new LinkedList<>();
21        q.add(root);
22        while(!q.isEmpty()){
23            int n= q.size();
24            List<Integer> ls= new ArrayList<>();
25            for(int i=0;i<n;i++){
26                TreeNode curr= q.poll();
27                ls.add(curr.val);
28                if(curr.left!=null) q.add(curr.left);
29                if(curr.right!=null) q.add(curr.right);
30            }
31            res.add(ls);
32        }
33
34        return res;
35    }
36}