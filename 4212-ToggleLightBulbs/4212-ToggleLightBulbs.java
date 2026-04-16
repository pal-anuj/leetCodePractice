// Last updated: 16/04/2026, 05:36:32
class Solution {

    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int num : bulbs) {
            if (!map.containsKey(num))
                map.put(num, true);
            else if (map.get(num) == true)
                map.put(num, false);
            else
                map.put(num, true);
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Boolean> entry : map.entrySet())
            if (entry.getValue())
                res.add(entry.getKey());

        Collections.sort(res);
        return res;
    }
}