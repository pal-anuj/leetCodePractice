// Last updated: 11/12/2025, 09:57:30
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] arr, int indexDiff, int valueDiff) {
        TreeSet<Long> window= new TreeSet<>();

        for(int i=0;i<arr.length;i++){
            long num = arr[i];

            //check floor (closest smaller or equal
            //largest element in the TreeSet which is <=x  
            Long floor= window.floor(num);    
            if(floor!=null && num-floor <= valueDiff)
                return true;

            //check ceiling (closest bigger or equal
            //smallest element in the TreeSet which is >=x
            Long ceiling= window.ceiling(num);
            if(ceiling!=null && ceiling-num <= valueDiff)
                return true;

            //add current number to window
            window.add(num);

            //maintain window size
            if(i >= indexDiff)
                window.remove((long) arr[i-indexDiff]);
        }
        return false;    
    }
}