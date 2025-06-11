// Last updated: 11/06/2025, 17:43:28
class Solution {
    public int minAddToMakeValid(String s) {
        int counterOpen =0; int counterClose=0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='(')
                counterOpen++;
            else if(counterOpen>0)
                counterOpen--;
            else
                counterClose++;
        }
        return counterOpen+counterClose;
    }
}