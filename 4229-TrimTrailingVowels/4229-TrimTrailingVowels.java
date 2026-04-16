// Last updated: 16/04/2026, 05:36:27
class Solution {
    public String trimTrailingVowels(String s) {
        
        int end= s.length()-1;
        while(end >=0 && isVowel(s.charAt(end)))
            end--;

        return s.substring(0, end+1);
        
    }
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' 
            || c == 'o' || c == 'u';
    }
}