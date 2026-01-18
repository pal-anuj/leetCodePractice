// Last updated: 18/01/2026, 16:05:52
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
14//      inorder = Left → Root → Right       inorder =   [9,3,15,20,7]
15//      postorder = Left → Right → Root     postorder = [9,15,7,20,3]
16 * }
17 */
18class Solution {
19    
20    int postIndex;
21
22    public TreeNode buildTree(int[] inorder, int[] postorder) {
23        postIndex= postorder.length-1;
24        return buildTreeRec(inorder, postorder, 0, postIndex);
25    }
26
27    public TreeNode buildTreeRec(int[] in, int[] po, int is, int ie){
28        if(is>ie) return null;
29
30        TreeNode root= new TreeNode(po[postIndex--]);
31        int index= Integer.MIN_VALUE;
32        for(int i=is;i <= ie;i++){
33            if(in[i]== root.val){
34                index=i;
35                break;
36            }
37        }
38        root.right= buildTreeRec(in, po, index+1, ie);
39        root.left= buildTreeRec(in, po, is, index-1);
40        return root;
41    }
42}