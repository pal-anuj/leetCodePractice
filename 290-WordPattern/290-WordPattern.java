// Last updated: 12/01/2026, 23:29:33
1class Solution {
2    public boolean wordPattern(String pattern, String s) {
3        
4        // Split words by space
5        String[] words = s.split(" ");
6
7        // Length mismatch → cannot follow pattern
8        if (pattern.length() != words.length) {
9            return false;
10        }
11
12        // Maps for bidirectional mapping
13        Map<Character, String> charToWord= new HashMap<>();
14        Map<String, Character> wordToChar= new HashMap<>();
15
16        int n= pattern.length();
17        for(int i=0;i<n;i++){
18            char ch= pattern.charAt(i);
19            String word= words[i];
20
21            if(charToWord.containsKey(ch)){
22                String w= charToWord.get(ch);
23                if(!w.equals(word))
24                    return false;
25            } else {
26                charToWord.put(ch, word);
27            }
28            if(wordToChar.containsKey(word)){
29                char p= wordToChar.get(word);
30                if(ch != p)
31                    return false;
32            }else{
33                wordToChar.put(word, ch);                
34            }
35        }
36        return true;
37    }
38}