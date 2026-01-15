// Last updated: 15/01/2026, 13:11:34
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
17    public boolean isSymmetric(TreeNode root) {
18        if(root==null) return true;
19
20        //BFS
21        Queue<TreeNode> q1= new LinkedList<>();
22        Queue<TreeNode> q2= new LinkedList<>();
23
24        q1.offer(root.left);
25        q2.offer(root.right);
26
27        while(!q1.isEmpty() && !q2.isEmpty()){
28            TreeNode c1= q1.poll();
29            TreeNode c2= q2.poll();
30
31            if(c1==null && c2==null) continue;
32            if(c1==null || c2==null) return false;
33            if(c1.val != c2.val) return false;
34
35            q1.offer(c1.left);    
36            q1.offer(c1.right);    
37            q2.offer(c2.right);
38            q2.offer(c2.left);
39        }
40        return true;
41        
42        //// DFS
43        // if (root == null)
44        //     return false;
45        // return isSymmetricHelp(root.left, root.right);
46    }
47
48    public boolean isSymmetricHelp(TreeNode left, TreeNode right) {
49        if (left == null || right == null)
50            return left == right;
51
52        if(left.val!= right.val)
53            return false;
54
55        return  isSymmetricHelp(left.left, right.right) 
56                && 
57                isSymmetricHelp(left.right, right.left);     
58    }
59}