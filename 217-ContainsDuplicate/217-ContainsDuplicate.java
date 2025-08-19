// Last updated: 19/08/2025, 16:44:55
class Solution {
    public boolean containsNearbyDuplicate(int[] arr, int k) {
        Map<Integer,Integer> map= new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                int a= i - map.get(arr[i]);
                if(a<=k)
                    return true;
                map.put(arr[i], i);
            }
            else{
                map.put(arr[i], i);
            }

        }
        return false;
    }
}