// Last updated: 11/06/2025, 17:43:39
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i =1; i<=n;i++){
            list.add(i);
        }
        list.sort((a,b) -> String.valueOf(a).compareTo(String.valueOf(b)));
        
        return list;  
    }
}