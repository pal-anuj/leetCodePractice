// Last updated: 14/12/2025, 10:09:49
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
17    public List<Double> averageOfLevels(TreeNode root) {
18        List<Double> res= new ArrayList<>();
19        if(root==null) return res;
20
21        Queue<TreeNode> q= new LinkedList<>();
22        q.add(root);
23
24        while(!q.isEmpty()){
25            int n= q.size();
26            double sum=0;
27            for(int i=0;i<n;i++){
28                TreeNode node= q.poll();
29                sum+=(double) node.val;
30
31                if(node.left!=null) q.add(node.left);
32                if(node.right!=null) q.add(node.right);
33            }
34            sum = sum/n;
35            res.add(sum);
36        }
37        return res;
38    }
39}