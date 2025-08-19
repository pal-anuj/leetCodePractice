// Last updated: 19/08/2025, 11:36:54
class Solution {
    public int numSplits(String s) {

        int res=0;
        //right side character count
        Map<Character, Integer> rmap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            rmap.put(s.charAt(i), rmap.getOrDefault(s.charAt(i), 0)+1);
        }

        //left side character count
        Set<Character> lset = new HashSet<>();
        for(int i=0;i<s.length();i++){
            lset.add(s.charAt(i));    
            rmap.put(s.charAt(i), rmap.get(s.charAt(i))-1);

            if(rmap.get(s.charAt(i))==0)
                rmap.remove(s.charAt(i));

            //compare unique count    
            if(lset.size() == rmap.size())
                res++;    
        }
        return res;
    }
}