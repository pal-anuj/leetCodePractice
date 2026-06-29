// Last updated: 29/06/2026, 10:30:40
1class Solution {
2
3    static class Car {
4        int position;
5        int speed;
6
7        public Car(int position, int speed) {
8            this.position = position;
9            this.speed = speed;
10        }
11    }
12
13    public int carFleet(int target, int[] position, int[] speed) {
14        int n = position.length;
15        List<Car> cars = new ArrayList<>();
16        for (int i = 0; i < n; i++) {
17            cars.add(new Car(position[i], speed[i]));
18        }
19        // Sort by position
20        cars.sort(Comparator.comparingInt(c -> c.position));
21
22        // Other Approach
23        Stack<Double> st = new Stack<>();
24        for (int i = n - 1; i >= 0; i--) {
25            double time = (double) (target - cars.get(i).position) / cars.get(i).speed;
26
27            if (st.isEmpty() || time > st.peek()) {
28                st.push(time);
29            }
30        }
31        return st.size();
32
33        // double maxTime = 0;
34        // int fleets = 0;
35
36        // for (int i = n - 1; i >= 0; i--) {
37        //     double time = (double) (target - ls.get(i).position) / ls.get(i).speed;
38
39        //     if (time > maxTime) {
40        //         fleets++;
41        //         maxTime = time;
42        //     }
43        // }
44        // return fleets;
45    }
46}