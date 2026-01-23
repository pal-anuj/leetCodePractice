// Last updated: 24/01/2026, 00:09:42
class Solution {
    public int minDeletionSize(String[] strs) {
        int rows= strs.length;
        int cols= strs[0].length();
        System.out.println("cols= "+ cols);
        System.out.println("rows= "+rows);
        int deletion=0;
        
        boolean[] alreadySorted= new boolean[rows-1];

        int row;
        int col;

        for(col=0; col < cols; col++){
            
            boolean needDelete= false;
            for( row=0; row < rows - 1; row++){
                if(!alreadySorted[row] && 
                    strs[row].charAt(col) > strs[row + 1].charAt(col))
                {
                    deletion++;
                    needDelete= true;
                    break;
                }
            }

            if(needDelete) continue;

            for(row=0; row < rows - 1;row++){
                alreadySorted[row]= alreadySorted[row] | strs[row].charAt(col) < strs[row+1].charAt(col);
            }

        }

        return deletion;
    }
}