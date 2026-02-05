// Last updated: 05/02/2026, 23:11:49
1class Solution {
2    public int lengthOfLastWord(String s) {
3        List<String> strList= Arrays.asList(s.split(" "));
4        int n= strList.size()-1;
5        return strList.get(n).length();
6    }
7}