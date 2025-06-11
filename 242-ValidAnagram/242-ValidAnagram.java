// Last updated: 11/06/2025, 17:43:44
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())  return false;    
        int count[] = new int[26];
        for(int i =0; i<s.length();i++){
            count[s.charAt(i) -'a']++;
            count[t.charAt(i) -'a']--;  }

        for(int j=0;j<count.length;j++){
            if(count[j] !=0 )   return false;
        }
        return true;
    }
}