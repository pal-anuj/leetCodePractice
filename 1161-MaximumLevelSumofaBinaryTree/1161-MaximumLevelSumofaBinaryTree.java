// Last updated: 17/01/2026, 16:41:29
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
17    private List<Integer> levelSums = new ArrayList<>();
18
19    public void DFS(TreeNode node, int level) {
20        if (node == null)
21            return;
22
23        if (levelSums.size() < level) {
24            levelSums.add(node.val);
25        } else {
26            levelSums.set(level - 1, levelSums.get(level - 1) + node.val);
27        }
28        DFS(node.left, level + 1);
29        DFS(node.right, level + 1);
30    }
31
32    public int maxLevelSum(TreeNode root) {
33
34        //DFS
35        DFS(root, 1);
36        int maxSum = Integer.MIN_VALUE;
37        int maxLevel = 1;
38        for (int i = 0; i < levelSums.size(); i++) {
39            if (levelSums.get(i) > maxSum) {
40                maxSum = levelSums.get(i);
41                maxLevel = i + 1; //1-indexed
42            }
43        }
44
45        return maxLevel;
46
47        /*
48        //BFS Algo 
49        if (root == null)
50            return 0;
51        
52        Queue<TreeNode> q = new LinkedList<>();
53        q.offer(root);
54        int currLevel = 0;
55        int level=0; //level which have max sum
56        
57        int maxSum = Integer.MIN_VALUE;
58        while (!q.isEmpty()) {
59            int n = q.size();
60            currLevel++;
61        
62            int currSum = 0;
63            for (int i = 0; i < n; i++) {
64                TreeNode temp = q.poll();
65                System.out.println(temp.val);
66                currSum += temp.val;
67        
68                if (temp.left != null)
69                    q.offer(temp.left);
70                if (temp.right != null)
71                    q.offer(temp.right);
72            }
73            if (maxSum < currSum) {
74                maxSum = currSum;
75                level= currLevel;
76            }
77        }
78        return level;
79        */
80    }
81
82}
83