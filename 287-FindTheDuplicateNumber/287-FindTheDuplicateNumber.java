// Last updated: 24/01/2026, 00:09:56
class Solution {
    public int findDuplicate(int[] arr) {
        /* 
        //using extra space
        HashSet<Integer> hs= new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(hs.contains(arr[i]))
                return arr[i];
            else
                hs.add(arr[i]);
        }
        return 0;
        */

        // fast slow pointer similar to cycle linkedlist 0(n) with space 0(1)
        int slow=arr[0];
        int fast=arr[0];

        do{
            slow= arr[slow];
            fast= arr[arr[fast]];
        } while(slow != fast);

        fast= arr[0];
        while(slow != fast){
            slow= arr[slow];
            fast= arr[fast];
        }
        return slow;
    }
}