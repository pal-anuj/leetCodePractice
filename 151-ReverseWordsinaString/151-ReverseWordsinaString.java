// Last updated: 20/12/2025, 18:49:10
1class Solution {
2    public String reverseWords(String s) {
3        int n= s.length();
4        StringBuilder ans= new StringBuilder();
5        StringBuilder sb = new StringBuilder(s);         
6        sb.reverse();
7        s=sb.toString();
8
9        for(int i=0;i<n;i++){ 
10            StringBuilder word= new StringBuilder();
11            while(i<n && s.charAt(i) !=' '){
12                word.append(s.charAt(i));
13                i++;
14            }
15            word.reverse();
16            if(word.length()>0){
17                ans.append(" ").append(word);
18            }
19        }
20
21        return ans.substring(1);
22    }
23}