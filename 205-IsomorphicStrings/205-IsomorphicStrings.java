// Last updated: 25/07/2026, 13:06:37
1class Solution {
2    public boolean isIsomorphic(String s, String t) {
3        int[] mapS= new int[256];
4        int[] mapT= new int[256];
5        for(int i=0;i<s.length();i++){
6            char a= s.charAt(i);
7            char b= t.charAt(i);
8
9            if(mapS[a] != mapT[b])
10                return false;
11
12            mapS[a]= i+1;
13            mapT[b]= i+1;
14        }
15
16        // Time: O(n), Space: O(k)
17        // Map<Character, Character> sToT = new HashMap<>();
18        // Map<Character, Character> tToS = new HashMap<>();
19        // for (int i = 0; i < s.length(); i++) {
20        //     char a = s.charAt(i);
21        //     char b = t.charAt(i);
22
23        //     Character x = sToT.get(a);
24        //     Character y = tToS.get(b);
25
26        //     if (x != null && x != b)
27        //         return false;
28
29        //     if (y != null && y != a)
30        //         return false;
31
32        //     sToT.put(a, b);
33        //     tToS.put(b, a);
34
35        // }
36        return true;
37    }
38}