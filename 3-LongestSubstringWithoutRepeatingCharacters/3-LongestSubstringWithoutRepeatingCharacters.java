// Last updated: 19/08/2025, 00:22:52
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set= new HashSet<>();
        int right=0;
        int left=0;
        int maxLen=0;
        while(right < s.length()){
            char c= s.charAt(right);

            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            maxLen= Math.max(maxLen, right-left+1);
            right++;

        }
        return maxLen;

    }
}