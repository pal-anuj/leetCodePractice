// Last updated: 13/10/2026, 09:52:39
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
17    public int maxDepth(TreeNode root) {
18        if(root==null) return 0;
19        Queue<TreeNode> q= new LinkedList<>();
20        q.add(root);
21        int depth=0;
22        while(!q.isEmpty()){
23            depth++;
24            int size= q.size();
25            for(int i=0;i<size;i++){
26                TreeNode cur= q.poll();
27                if(cur.left!=null) q.offer(cur.left);
28                if(cur.right!=null) q.offer(cur.right);
29            }
30        }
31
32        return depth;
33    }
34}