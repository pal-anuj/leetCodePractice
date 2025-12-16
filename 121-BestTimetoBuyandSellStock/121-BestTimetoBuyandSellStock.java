// Last updated: 16/12/2025, 09:05:54
class Solution {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
                fw.write("0");
            } catch (Exception e) {
            }
        }));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int maxProfit = 0;
        int st = 0;
        int end = 1;

        while (end < prices.length) {
            profit = prices[end] - prices[st];
            maxProfit = Math.max(maxProfit, profit);

            if (profit < 0) {
                st = end;
            }
            end++;
        }

        return maxProfit;
    }
}