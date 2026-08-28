// Last updated: 28/08/2026, 20:52:04
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
17    public int preIndex = 0;
18
19    public TreeNode buildTree(int[] preorder, int[] inorder) {
20        int n = preorder.length - 1;
21        TreeNode root = buildTreeDFS(preorder, inorder, 0, n);
22        return root;
23    }
24
25    private TreeNode buildTreeDFS(int[] preorder, int[] inorder, int is, int ie) {
26        if (is > ie)
27            return null;
28
29        TreeNode root = new TreeNode(preorder[preIndex++]);
30
31        int inidx = -1;
32        for (int i = is; i <= ie; i++) {
33            if (inorder[i] == root.val) {
34                inidx = i;
35                break;
36            }
37        }
38        // System.out.println("recStra: " + is);
39        // System.out.println("recEnd: " + ie);
40        root.left = buildTreeDFS(preorder, inorder, is, inidx - 1);
41        root.right = buildTreeDFS(preorder, inorder, inidx + 1, ie);
42
43        return root;
44    }
45}