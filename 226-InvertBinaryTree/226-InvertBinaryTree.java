// Last updated: 15/01/2026, 11:24:57
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
17    public TreeNode invertTree(TreeNode root) {
18        if(root==null)
19            return null;
20
21        Queue<TreeNode> q= new LinkedList<>();
22        q.add(root);
23
24        while(!q.isEmpty()){
25            TreeNode curr= q.poll();
26
27            // Shuffle left child with right child
28            TreeNode temp= curr.left;
29            curr.left= curr.right;
30            curr.right= temp;
31
32            if(curr.left!=null) q.offer(curr.left);
33            if(curr.right!=null) q.offer(curr.right);
34        }
35        return root;
36        
37        ////DFS use StackOverflow
38        // if(root==null)
39        //     return null;            
40        // TreeNode temp= root.left;
41        // root.left= root.right;
42        // root.right= temp;
43
44        // invertTree(root.left);
45        // invertTree(root.right);
46        // return root;
47    }
48}