// Last updated: 19/01/2026, 21:56:32
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
18        if (nums.length == 0)
19            return null;
20
21        return sortedArrayToBSTRec(nums, 0, nums.length - 1);
22
23    }
24
25    public TreeNode sortedArrayToBSTRec(int[] nums, int l, int h) {
26        if (h >= l) {
27            int mid = l + (h - l) / 2;
28            TreeNode root = new TreeNode(nums[mid]);
29            root.left = sortedArrayToBSTRec(nums, l, mid - 1);
30            root.right = sortedArrayToBSTRec(nums, mid + 1, h);
31
32            return root;
33        }
34        return null;
35    }
36}