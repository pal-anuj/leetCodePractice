// Last updated: 12/12/2025, 08:20:32
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
17    public int countNodes(TreeNode root) {
18        if(root==null) return 0;
19        // int l= countNodes(root.left);
20        // int r= countNodes(root.right);
21        // return 1+l+r;
22        
23        int lh= leftTreeHeight(root);
24        int rh= rightTreeHeight(root);
25        if(lh==rh) return (1 << lh) - 1;
26        else return 1+(countNodes(root.left)+ countNodes(root.right));
27    }
28
29    public int leftTreeHeight(TreeNode root){
30        int c=0;
31        while(root!=null)
32        {
33            c++;
34            root=root.left;
35        }
36        return c;
37    }
38    public int rightTreeHeight(TreeNode root){
39        int c=0;
40        while(root!=null)
41        {
42            c++;
43            root=root.right;
44        }
45        return c;
46    }
47}