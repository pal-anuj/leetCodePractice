// Last updated: 18/01/2026, 16:24:27
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        HashMap<Integer, Integer> inOrderMap;
        int postOrderIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrderMap = new HashMap<>();
        postOrderIdx =inorder.length-1;
        for(int i =0; i<inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        return build(postorder, 0, inorder.length-1);

    }
    private TreeNode build(int[] postorder, int left, int right){
        if(left>right) return null;

        TreeNode root = new TreeNode(postorder[postOrderIdx]);
        int rootIdx = inOrderMap.get(postorder[postOrderIdx]);

        postOrderIdx--;

        root.right = build(postorder, rootIdx+1, right);
        root.left = build(postorder, left, rootIdx-1);
        return root;
    }
}