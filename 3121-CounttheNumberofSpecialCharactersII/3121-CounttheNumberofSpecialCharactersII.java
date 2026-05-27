// Last updated: 28/05/2026, 01:25:45
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        int n = word.length();
4        int count = 0;
5        for (char ch = 'a'; ch <= 'z'; ch++) {
6            boolean ignoreChar= false;
7            for (int j = n - 1; j >= 0; j--) {
8                if (ch == word.charAt(j))
9                    break;
10                if (Character.toUpperCase(ch) == word.charAt(j)) {
11                    j = j - 1;
12                    boolean validLower = false;
13                    while (j >= 0) {
14                        if (validLower && Character.toUpperCase(ch) == word.charAt(j)) {
15                            ignoreChar= true;
16                            validLower = false;
17                            System.out.println("Anuj=> "+j);
18                            break;
19                        }
20
21                        if (word.charAt(j) == ch) {
22                            // System.out.println(j);
23                            validLower = true;
24                        }
25                        j--;
26                    }
27                    if (validLower) {
28                        System.out.println(ch + ", j=>"+j);
29                        count++;
30                        break;
31                    }
32
33                    if(ignoreChar)
34                        break;
35                }
36            }
37        }
38        return count;
39    }
40}