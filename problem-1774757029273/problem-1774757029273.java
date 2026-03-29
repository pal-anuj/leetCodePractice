// Last updated: 29/03/2026, 09:33:49
1class EventManager {
2    TreeMap<Integer, TreeSet<Integer>> priorityMap = new TreeMap<>();
3    Map<Integer, Integer> eventToPriority = new HashMap<>();
4
5    public EventManager(int[][] events) {
6        for (int i = 0; i < events.length; i++) {
7            priorityMap.computeIfAbsent(events[i][1], k -> new TreeSet<>()).add(events[i][0]);
8            eventToPriority.put(events[i][0], events[i][1]);
9        }
10    }
11
12    public void updatePriority(int eventId, int newPriority) {
13        if (eventToPriority.containsKey(eventId)) {
14            int oldPriority = eventToPriority.get(eventId);
15
16            // remove from old priority
17            TreeSet<Integer> set = priorityMap.get(oldPriority);
18            set.remove(eventId); // O(log n)
19            if (set.isEmpty()) {
20                priorityMap.remove(oldPriority);
21            }
22
23        }
24        // add to new priority
25        priorityMap
26                .computeIfAbsent(newPriority, k -> new TreeSet<>())
27                .add(eventId);
28
29        eventToPriority.put(eventId, newPriority);
30    }
31
32    public int pollHighest() {
33        if (priorityMap.isEmpty())
34            return -1;
35
36        int lastKey = priorityMap.lastKey(); // highest priority
37
38        TreeSet<Integer> set = priorityMap.get(lastKey);
39
40        int eventId = set.pollFirst(); // largest eventId
41
42        if (set.isEmpty()) {
43            priorityMap.remove(lastKey);
44        }
45
46        eventToPriority.remove(eventId);
47
48        return eventId;
49    }
50}
51
52/**
53 * Your EventManager object will be instantiated and called as such:
54 * EventManager obj = new EventManager(events);
55 * obj.updatePriority(eventId,newPriority);
56 * int param_2 = obj.pollHighest();
57 */