// Last updated: 14/12/2025, 10:55:03
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
17    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
18        List<List<Integer>> res= new ArrayList<>();
19        if(root==null) return res;
20
21        Queue<TreeNode> q= new LinkedList<>();
22        q.add(root);
23        boolean leftToRight=true;
24        while(!q.isEmpty()){
25            int n= q.size();
26            Deque<Integer> level= new LinkedList<>();
27
28            for(int i=0;i<n;i++){
29                TreeNode node= q.poll();
30                
31                // insert based on direction
32                if(leftToRight)
33                    level.addLast(node.val);
34                else
35                    level.addFirst(node.val);
36
37                if(node.left!=null) q.add(node.left);
38                if(node.right!=null) q.add(node.right);                  
39            }
40            res.add(new ArrayList<>(level));
41            leftToRight= !leftToRight;  // flip direction
42        }
43        return res;
44    }   
45}