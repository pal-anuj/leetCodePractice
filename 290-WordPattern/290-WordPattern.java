// Last updated: 12/01/2026, 23:30:40
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] parts = s.split(" ");
        if (parts.length != pattern.length()) return false;
        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = parts[i];
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) return false;
            } 
            else if (wordToChar.containsKey(word)) {
                return false;
            } 
            else {
                charToWord.put(c, word);
                wordToChar.put(word, c);
            }
        }
        return true;
    }
}
