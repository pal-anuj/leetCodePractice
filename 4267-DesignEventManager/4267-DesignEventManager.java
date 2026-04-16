// Last updated: 16/04/2026, 05:36:18
class EventManager {
    TreeMap<Integer, TreeSet<Integer>> priorityMap = new TreeMap<>();
    Map<Integer, Integer> eventToPriority = new HashMap<>();

    public EventManager(int[][] events) {
        for (int i = 0; i < events.length; i++) {
            priorityMap.computeIfAbsent(events[i][1], k -> new TreeSet<>()).add(events[i][0]);
            eventToPriority.put(events[i][0], events[i][1]);
        }
    }

    public void updatePriority(int eventId, int newPriority) {
        if (eventToPriority.containsKey(eventId)) {
            int oldPriority = eventToPriority.get(eventId);

            // remove from old priority
            TreeSet<Integer> set = priorityMap.get(oldPriority);
            set.remove(eventId); // O(log n)
            if (set.isEmpty()) {
                priorityMap.remove(oldPriority);
            }

        }
        // add to new priority
        priorityMap
                .computeIfAbsent(newPriority, k -> new TreeSet<>())
                .add(eventId);

        eventToPriority.put(eventId, newPriority);
    }

    public int pollHighest() {
        if (priorityMap.isEmpty())
            return -1;

        int lastKey = priorityMap.lastKey(); // highest priority

        TreeSet<Integer> set = priorityMap.get(lastKey);

        int eventId = set.pollFirst(); // largest eventId

        if (set.isEmpty()) {
            priorityMap.remove(lastKey);
        }

        eventToPriority.remove(eventId);

        return eventId;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */