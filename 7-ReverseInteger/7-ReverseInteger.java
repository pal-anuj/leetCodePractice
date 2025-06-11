// Last updated: 11/06/2025, 17:44:01
class Solution {
    public int reverse(int x) {

        int res=0;
        while(x!=0){
            int temp = (x%10);
            res=(res*10)+temp;
            x=x/10;
            if(res%10!=temp)
                return 0;

        }
        return res;
    }
}