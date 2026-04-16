// Last updated: 16/04/2026, 05:36:19
class Solution {
    public int firstMatchingIndex(String s) {
        int l=0;
        int h=s.length()-1;
        while(l<=h){
            if(s.charAt(l) == s.charAt(h))
                return l;
            l++; h--;
        }
        return -1;
    }
}