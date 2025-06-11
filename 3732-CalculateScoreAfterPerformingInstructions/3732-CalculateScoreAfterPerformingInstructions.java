// Last updated: 11/06/2025, 17:43:34
class Solution {
       public long calculateScore(String[] instructions, int[] values) {
        long res=0;
        int i=0;
        Set<Integer> visited = new HashSet<>();
        while(i>=0 && i<instructions.length && !visited.contains(i)){
            visited.add(i);
            if(instructions[i].equals("add"))
            {
                res+=values[i];
                i++;
            }
            else if(instructions[i].equals("jump"))
            {
                i+=values[i];

            }
            

        }
        return res;
    }
}