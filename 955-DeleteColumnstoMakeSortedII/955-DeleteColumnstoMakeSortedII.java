// Last updated: 24/12/2025, 08:34:12
1class Solution {
2    public int minDeletionSize(String[] strs) {
3        int rows= strs.length;
4        int cols= strs[0].length();
5        System.out.println("cols= "+ cols);
6        System.out.println("rows= "+rows);
7        int deletion=0;
8        
9        boolean[] alreadySorted= new boolean[rows-1];
10
11        int row;
12        int col;
13
14        for(col=0; col < cols; col++){
15            
16            boolean needDelete= false;
17            for( row=0; row < rows - 1; row++){
18                if(!alreadySorted[row] && 
19                    strs[row].charAt(col) > strs[row + 1].charAt(col))
20                {
21                    deletion++;
22                    needDelete= true;
23                    break;
24                }
25            }
26
27            if(needDelete) continue;
28
29            for(row=0; row < rows - 1;row++){
30                alreadySorted[row]= alreadySorted[row] | strs[row].charAt(col) < strs[row+1].charAt(col);
31            }
32
33        }
34
35        return deletion;
36    }
37}