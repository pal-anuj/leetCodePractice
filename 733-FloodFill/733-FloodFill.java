// Last updated: 31/08/2026, 22:08:06
1class Solution {
2    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
3        dfs(image, sr, sc, color, image[sr][sc]);
4        return image;
5    }
6
7    private void dfs(int[][] image, int i, int j, int color, int oldColor) {
8        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != oldColor
9                || image[i][j] == color) {
10            return;
11        }
12
13        image[i][j] = color;
14        dfs(image, i - 1, j, color, oldColor); //top
15        dfs(image, i + 1, j, color, oldColor); //bottom
16        dfs(image, i, j + 1, color, oldColor); //right
17        dfs(image, i, j - 1, color, oldColor); //left
18    }
19}