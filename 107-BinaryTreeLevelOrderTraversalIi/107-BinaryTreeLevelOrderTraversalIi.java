// Last updated: 14/12/2025, 00:10:17
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> ls= new ArrayList<>();
            int n= q.size();
            for(int i=0;i<n;i++){
                TreeNode node= q.poll();
                ls.add(node.val);

                if(node.left !=null) q.add(node.left);
                if(node.right !=null) q.add(node.right);
            }
            res.add(ls);
        }
        Collections.reverse(res);
        return res;

    }
}