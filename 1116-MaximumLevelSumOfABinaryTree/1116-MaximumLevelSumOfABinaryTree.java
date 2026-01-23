// Last updated: 24/01/2026, 00:09:39
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

    private List<Integer> levelSums = new ArrayList<>();

    public void DFS(TreeNode node, int level) {
        if (node == null)
            return;

        if (levelSums.size() < level) {
            levelSums.add(node.val);
        } else {
            levelSums.set(level - 1, levelSums.get(level - 1) + node.val);
        }
        DFS(node.left, level + 1);
        DFS(node.right, level + 1);
    }

    public int maxLevelSum(TreeNode root) {

        //DFS
        DFS(root, 1);
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        for (int i = 0; i < levelSums.size(); i++) {
            if (levelSums.get(i) > maxSum) {
                maxSum = levelSums.get(i);
                maxLevel = i + 1; //1-indexed
            }
        }

        return maxLevel;

        /*
        //BFS Algo 
        if (root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int currLevel = 0;
        int level=0; //level which have max sum
        
        int maxSum = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int n = q.size();
            currLevel++;
        
            int currSum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode temp = q.poll();
                System.out.println(temp.val);
                currSum += temp.val;
        
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
            }
            if (maxSum < currSum) {
                maxSum = currSum;
                level= currLevel;
            }
        }
        return level;
        */
    }

}
