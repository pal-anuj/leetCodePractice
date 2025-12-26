// Last updated: 26/12/2025, 10:28:17
1class Solution {
2    public boolean isPalindrome(String s) {
3        
4        s= s.replaceAll("[^a-zA-Z0-9]", "");
5        s= s.toLowerCase();
6    
7        int n= s.length();
8        int low=0;
9        int high=n-1;
10
11        while(low<high){
12
13            if(s.charAt(low) == s.charAt(high)){
14                low++; high--;
15            }
16            else
17                return false;
18        }
19
20        return true;
21    }
22}