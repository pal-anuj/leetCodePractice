// Last updated: 17/01/2026, 12:24:01
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
17
18    public int findBottomLeftValue(TreeNode root) {
19        
20        int bottomLeftestEle= Integer.MIN_VALUE;            
21        Queue<TreeNode> q= new LinkedList<>();
22        q.add(root);
23        
24        while(!q.isEmpty()){
25            int n=q.size();
26            for(int i=0;i< n;i++){
27                TreeNode curr= q.poll();            
28                if(i==0){
29                    bottomLeftestEle= curr.val;
30                    System.out.println("i="+i+" , currVal= "+curr.val );
31                }
32                
33                if(curr.left!=null) q.add(curr.left);
34                if(curr.right!=null) q.add(curr.right);
35            }
36        }
37        return bottomLeftestEle;
38    }
39}