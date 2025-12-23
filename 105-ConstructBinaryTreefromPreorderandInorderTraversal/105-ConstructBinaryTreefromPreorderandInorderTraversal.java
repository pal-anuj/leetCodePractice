// Last updated: 23/12/2025, 09:05:18
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
18        // preorder -> PLR [3,9,20,15,7]
19        // inOrder -> LPR  [9,3,15,20,7]
20
21    // Map to store value -> index mapping for inorder traversal
22    // This helps us find root index in O(1) time
23    // Map will be: {9=0, 3=1, 15=2, 20=3, 7=4}
24    Map<Integer, Integer> inorderIndexMap= new HashMap<>();     
25
26    public TreeNode buildTree(int[] pre, int[] in) {
27        int si=0; // STARTING INDEX
28        int ei=pre.length-1; // ENDING INDEX
29
30
31        for(int i=0;i < in.length;i++){
32            inorderIndexMap.put(in[i], i);
33        }
34        return cTree(pre, in, si, ei);
35    }
36
37    // This index keeps track of the current root in preorder array
38    // Preorder traversal = Root -> Left -> Right
39    int preIndex=0;
40
41
42
43    public TreeNode cTree(int[] pre, int[] in, int si, int ei){
44        
45        // Base case
46        if(si>ei) return null;
47
48        // Step 1: Pick the current root value from preorder traversal
49        // preIndex is incremented because next preorder element
50        // will be used for the next recursive call
51        TreeNode root= new TreeNode(pre[preIndex++]);
52
53
54        // Step 2: Find the index of this root value in inorder traversal
55        // This index splits the inorder array into left and right subtrees
56        // int inIndex=-1; // initialize to avoid unassigned usage
57        // for(int i=si;i <= ei; i++){
58        //     if(in[i]== root.val){
59        //         inIndex= i;
60        //         break;
61        //     }
62        // }
63
64        int inIndex= inorderIndexMap.get(root.val);
65
66        // Step 3: Construct the left subtree
67        // Elements to the left of inIndex in inorder belong to left subtree
68        root.left= cTree(pre, in, si, inIndex-1);
69
70        // Step 4: Construct the right subtree
71        // Elements to the right of inIndex in inorder belong to right subtree 
72        root.right= cTree(pre, in, inIndex+1, ei);
73
74        // Step 5: Return the constructed subtree rooted at 'root'
75        return root;
76    } 
77}