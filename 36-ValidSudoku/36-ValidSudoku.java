// Last updated: 23/06/2026, 06:29:09
1class Solution {
2    public boolean isValidSudoku(char[][] board) {
3        int n = 9;
4        Map<Integer, Set<Character>> rows = new HashMap<>();
5        Map<Integer, Set<Character>> cols = new HashMap<>();
6        Map<String, Set<Character>> squares = new HashMap<>();
7        for (int r = 0; r < n; r++) {
8            for (int c = 0; c < n; c++) {
9                if (board[r][c] == '.')
10                    continue;
11                String squareKey = r / 3 + "," + c / 3;
12
13                if (rows.computeIfAbsent(r, k -> new HashSet()).contains(board[r][c])
14                        || cols.computeIfAbsent(c, k -> new HashSet()).contains(board[r][c])
15                        || squares.computeIfAbsent(squareKey, k -> new HashSet()).contains(board[r][c]))
16                    return false;
17
18                rows.get(r).add(board[r][c]);
19                cols.get(c).add(board[r][c]);
20                squares.get(squareKey).add(board[r][c]);
21            }
22        }
23
24        // // Brute Force
25        // for(int i=0;i<n;i++){
26        //     Set<Character> iSet= new HashSet<>();
27        //     for(int j=0;j<n;j++){
28        //         if(board[i][j]=='.')
29        //             continue;
30        //         else if(iSet.contains(board[i][j]) )
31        //             return false;
32        //         else
33        //             iSet.add(board[i][j]);        
34        //     }
35        // }
36
37        // for(int i=0;i<n;i++){
38        //     Set<Character> jSet= new HashSet<>();
39        //     for(int j=0;j<n;j++){
40        //         if(board[j][i]=='.')
41        //             continue;
42        //         else if(jSet.contains(board[j][i]) )
43        //             return false;
44        //         else
45        //             jSet.add(board[j][i]);        
46        //     }
47        // }
48
49        // for(int square=0; square < 9;square++){
50        //     Set <Character> boxSet= new HashSet<>();
51        //     for(int i=0;i<3;i++){
52        //         for(int j=0;j<3;j++){
53        //             int row = (square / 3) * 3 + i;
54        //             int col= (square % 3) * 3 + j;
55        //             if(board[row][col]=='.') continue;
56        //             else if(boxSet.contains(board[row][col]))
57        //                 return false;
58        //             else
59        //                 boxSet.add(board[row][col]);    
60        //         }
61        //     }
62        // }
63
64        return true;
65    }
66}