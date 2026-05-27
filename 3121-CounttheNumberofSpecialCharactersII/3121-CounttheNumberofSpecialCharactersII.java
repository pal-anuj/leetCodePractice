// Last updated: 28/05/2026, 01:32:29
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        int n = word.length();
4        int count = 0;
5        for (char ch = 'a'; ch <= 'z'; ch++) {
6            boolean ignoreChar = false;
7            // efficient approach
8            int lastLower = word.lastIndexOf(ch);
9            int firstUpper = word.indexOf(Character.toUpperCase(ch));
10
11            if (lastLower != -1 && firstUpper != -1 && lastLower < firstUpper)
12                count++;
13
14            // brute force O(26 * n)
15            // for (int j = n - 1; j >= 0; j--) {
16            //     if (ch == word.charAt(j))
17            //         break;
18            //     if (Character.toUpperCase(ch) == word.charAt(j)) {
19            //         j = j - 1;
20            //         boolean validLower = false;
21            //         while (j >= 0) {
22            //             if (validLower && Character.toUpperCase(ch) == word.charAt(j)) {
23            //                 ignoreChar = true;
24            //                 validLower = false;
25            //                 System.out.println("Anuj=> " + j);
26            //                 break;
27            //             }
28
29            //             if (word.charAt(j) == ch) {
30            //                 // System.out.println(j);
31            //                 validLower = true;
32            //             }
33            //             j--;
34            //         }
35            //         if (validLower) {
36            //             System.out.println(ch + ", j=>" + j);
37            //             count++;
38            //             break;
39            //         }
40
41            //         if (ignoreChar)
42            //             break;
43            //     }
44            // }
45        }
46        return count;
47    }
48}