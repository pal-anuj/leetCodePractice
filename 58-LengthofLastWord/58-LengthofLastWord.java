// Last updated: 05/02/2026, 23:19:10
class Solution {
    public int lengthOfLastWord(String s) {
        int a=0;
        int length=s.length()-1;

        while(s.charAt(length)==' ')
        {
            length=length-1;
        }
        for(int i=length; i>=0; i--){

            if(s.charAt(i)!=' '){
                a++;
            }
            else{
                break;
            }
        }
        return a;
    }
}