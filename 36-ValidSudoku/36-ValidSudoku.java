// Last updated: 22/06/2026, 22:48:45
1class Solution {
2    public boolean isValidSudoku(char[][] board) {
3        int n=9;
4        for(int i=0;i<n;i++){
5            Set<Character> iSet= new HashSet<>();
6            for(int j=0;j<n;j++){
7                if(board[i][j]=='.')
8                    continue;
9                else if(iSet.contains(board[i][j]) )
10                    return false;
11                else
12                    iSet.add(board[i][j]);        
13            }
14        }
15
16        for(int i=0;i<n;i++){
17            Set<Character> jSet= new HashSet<>();
18            for(int j=0;j<n;j++){
19                if(board[j][i]=='.')
20                    continue;
21                else if(jSet.contains(board[j][i]) )
22                    return false;
23                else
24                    jSet.add(board[j][i]);        
25            }
26        }
27
28        for(int square=0; square < 9;square++){
29            Set <Character> boxSet= new HashSet<>();
30            for(int i=0;i<3;i++){
31                for(int j=0;j<3;j++){
32                    int row = (square / 3) * 3 + i;
33                    int col= (square % 3) * 3 + j;
34                    if(board[row][col]=='.') continue;
35                    else if(boxSet.contains(board[row][col]))
36                        return false;
37                    else
38                        boxSet.add(board[row][col]);    
39                }
40            }
41        }
42        
43        return true;
44    }
45}