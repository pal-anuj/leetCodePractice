// Last updated: 11/06/2025, 17:44:00
class Solution {
    public boolean isPalindrome(int x) {
    
        if(x < 0 ||(x % 10 ==0  && x!=0) ){
            return false;
        }

        int reserveHalf = 0;

        while (x > reserveHalf){
            int digit = x % 10;
            reserveHalf = reserveHalf * 10 + digit;
            x /= 10;
        }

        return x == reserveHalf || x == reserveHalf/10;
    }
}