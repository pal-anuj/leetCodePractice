// Last updated: 18/08/2025, 00:05:05
class Solution {
    public int countPrimes(int n) {
        boolean[] prime= new boolean[n+1];
        Arrays.fill(prime, true);

        for(int p=2; p*p<n;p++){
            if(prime[p])             
                for(int i=p*p; i<n; i+=p)
                    prime[i]=false;
        }

        int count=0;
        for(int i=2;i<n;i++){
            if(prime[i])
                count++;
        }
        return count;

    }
}