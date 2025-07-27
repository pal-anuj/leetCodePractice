// Last updated: 28/07/2025, 02:46:53
class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        
        String upperLimit= String.valueOf(n);
        int digit= upperLimit.length();
        int digitSize= digits.length;
        int res=0;

        //Scenario 1: where number of digit is less than upperlimit
        for(int i=1;i<digit;++i)
            res+= Math.pow(digitSize, i);

        //Scenaior 2: where number of digits are same a upper limit    
        for(int i=0;i<digit;++i){
            boolean startingNameNumber= false;
            for(String d : digits){
                if(d.charAt(0) < upperLimit.charAt(i))
                    res+= Math.pow(digitSize, digit -i-1);
                else if(d.charAt(0)==upperLimit.charAt(i)){
                    startingNameNumber=true;  
                }
            }
            if(!startingNameNumber)
                return res;
        }
        // 3. Include n itself if all digits matched
        return res+1;

        // //My Approach naive : getting TLE for big number
        // int count=0;
        // boolean countreachedToN=false;
        // Queue<String> q = new LinkedList<String>();
        // for(int i=0;i<digits.length;i++){
        //     if(Integer.valueOf(digits[i])<=n)
        //         q.add(digits[i]);
        //     else{
        //         countreachedToN=true;
        //         break;
        //     }        
        // }

        // while(!q.isEmpty() && !countreachedToN){
        //     String s= q.poll();
        //     count++;

        //     for(int i=0;i<digits.length;i++){
        //         String t=s+digits[i];
        //         if(Integer.valueOf(t)<=n)
        //             q.add(t);
        //         else{
        //             countreachedToN=true;
        //             break;
        //         }
        //     }
        // }
        // return count+q.size();
    }
}