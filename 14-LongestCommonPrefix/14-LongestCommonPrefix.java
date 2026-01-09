// Last updated: 09/01/2026, 23:16:13
1class Solution {
2    public String longestCommonPrefix(String[] strs) {
3            
4         if(strs==null || strs.length==0) return "";
5
6        String first=strs[0];
7
8        for(int i=0;i<first.length();i++){
9            char c= first.charAt(i);
10
11            for(int j=1;j<strs.length;j++){
12                if(i >= strs[j].length() || strs[j].charAt(i)!= c ){
13                    return first.substring(0, i);
14                }
15            }
16        }
17
18        return first;
19    }
20
21    public String matchString(String str1, String str2){
22        StringBuilder sb= new StringBuilder();
23        int c=0;
24        for(int i=0;i<str1.length() & i<str2.length();i++){
25            if(str1.charAt(i)== str2.charAt(i))
26                c++;
27            else
28                break;
29        }
30
31        return str1.substring(0,c);
32    }
33}