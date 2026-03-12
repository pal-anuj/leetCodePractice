// Last updated: 12/03/2026, 07:41:09
1class Solution {
2    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
3        DFS(image, sr, sc, color, image[sr][sc]);
4        return image;
5    }
6
7    private void DFS(int[][] image, int i, int j, int newColor, int orgColor) {
8
9        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length ||
10                image[i][j] != orgColor || image[i][j] == newColor)
11            return;
12
13        image[i][j] = newColor;
14
15        DFS(image, i + 1, j, newColor, orgColor);
16        DFS(image, i - 1, j, newColor, orgColor);
17        DFS(image, i, j + 1, newColor, orgColor);
18        DFS(image, i, j - 1, newColor, orgColor);
19    }
20
21    // private void DFS(int[][] image, int i, int j, int newColor, int orgColor) {
22
23    //     if (i < 0 || j < 0 || i >= image.length || j >= image[0].length ||
24    //             image[i][j] != orgColor || image[i][j] == newColor)
25    //         return;
26
27    //     image[i][j] = newColor;
28
29    //     DFS(image, i - 1, j, newColor, orgColor); // Top
30    //     DFS(image, i, j - 1, newColor, orgColor); // right
31    //     DFS(image, i, j + 1, newColor, orgColor); // left 
32    //     DFS(image, i + 1, j, newColor, orgColor); // bottom               
33    // }
34}