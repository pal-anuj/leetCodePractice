// Last updated: 19/04/2026, 22:41:02
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        int right = 0;
        int left = 0;
        int count = map.size();
        int k = s1.length();

        while(right < s2.length()) {
            char rightChar = s2.charAt(right);
            
            if(map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);

                if(map.get(rightChar) == 0) {
                    count--;
                }
            }

            if(right - left + 1 < k) {
                right++;
            }
            else if(right - left + 1 == k) {

                if(count == 0) {
                    return true;
                }

                char leftChar = s2.charAt(left);

                if(map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);

                    if(map.get(leftChar) == 1) {
                        count++;
                    }
                }
                left++;
                right++;
            }

        }
        return false;
    }
}