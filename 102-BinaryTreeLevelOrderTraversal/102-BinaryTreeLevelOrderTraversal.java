// Last updated: 14/12/2025, 11:01:04
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
19
20        if(root==null) return res;
21        Queue<TreeNode> q = new LinkedList<>();
22        q.add(root);
23
24        while(!q.isEmpty()){
25            List<Integer> ls= new ArrayList<>();
26            int n=q.size();
27            for(int i=0;i<n;i++){
28                TreeNode a= q.poll();
29                ls.add(a.val);
30                // System.out.println(a.val);
31                if(a.left!=null) q.add(a.left);
32                if(a.right!=null) q.add(a.right);
33            }
34            res.add(ls);
35        }
36
37        return res;
38    }
39}