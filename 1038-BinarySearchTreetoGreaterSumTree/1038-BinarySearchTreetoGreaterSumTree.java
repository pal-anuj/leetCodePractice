// Last updated: 24/01/2026, 00:04:51
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
17
18    private Map<Integer, Integer> map = new HashMap<>();
19    private int sum = 0;
20
21    public void setMapDFS(TreeNode root) {
22        if (root == null)
23            return;
24
25        setMapDFS(root.right);
26        sum += root.val;
27        map.put(root.val, sum);
28        setMapDFS(root.left);
29    }
30
31    public TreeNode bstToGst(TreeNode root) {
32
33        if (root == null)
34            return null;
35
36        setMapDFS(root);
37        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
38        return bstToGstRec(root);
39    }
40
41    public TreeNode bstToGstRec(TreeNode root) {
42
43        if (root == null)
44            return null;
45
46        bstToGstRec(root.left);
47        root.val = map.get(root.val);
48        bstToGstRec(root.right);
49
50        return root;
51    }
52}