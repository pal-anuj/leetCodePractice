// Last updated: 30/08/2026, 21:45:47
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
17    public TreeNode sortedArrayToBST(int[] nums) {
18        return helper(nums, 0, nums.length-1);
19    }
20
21    private TreeNode helper(int[] nums, int st, int end) {
22        if (st > end)
23            return null;
24
25        int mid = st + (end - st) / 2;
26        TreeNode root = new TreeNode(nums[mid]);
27        root.left = helper(nums, st, mid - 1);
28        root.right = helper(nums, mid + 1, end);
29        return root;
30    }
31}