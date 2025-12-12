// Last updated: 12/12/2025, 09:05:35
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
17    public List<List<Integer>> levelOrderBottom(TreeNode root) {
18        List<List<Integer>> res= new ArrayList<>();
19        if(root==null) return res;
20        Queue<TreeNode> q= new LinkedList<>();
21        q.add(root);
22        while(!q.isEmpty()){
23            List<Integer> ls= new ArrayList<>();
24            int n= q.size();
25            for(int i=0;i<n;i++){
26                TreeNode node= q.poll();
27                ls.add(node.val);
28
29                if(node.left !=null) q.add(node.left);
30                if(node.right !=null) q.add(node.right);
31            }
32            res.add(ls);
33        }
34        Collections.reverse(res);
35        return res;
36
37    }
38}